package pidev.spring.services;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.Offer;
import pidev.spring.entities.User;
import pidev.spring.repositories.OfferRepo;
import pidev.spring.repositories.UserRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

@Service
public class ServiceOffer implements IServiceOffer {

	@Autowired
	OfferRepo offerRepo;
	@Autowired
	UserRepo userRepo;

	@Override
	public List<Offer> retrieveAllOffers() {
		List<Offer> offers = (List<Offer>) offerRepo.findAll();
		return offers;
	}

	@Override
	public Offer addOffer(Offer o, Long idUser) {
		User u = userRepo.findById(idUser).orElse(null);
		u.getOffers().add(o);
		return offerRepo.save(o);
	}

	@Override
	public void affectUserToOffer(int idOffer, Long idUser) {
		Offer o = offerRepo.findById(idOffer).orElse(null);
		User u = userRepo.findById(idUser).orElse(null);
		o.getUsers().add(u);
		offerRepo.save(o);
	}

	@Override
	public Offer updateOffer(Offer o) {
		Offer offer = offerRepo.findById(o.getIdOffer()).orElse(null);
		offer.setTitle(o.getTitle());
		offer.setDescription(o.getDescription());
		offer.setDateExp(o.getDateExp());
		offer.setCategory(o.getCategory());
		offer.setPoint(o.getPoint());
		offer.setAddress(o.getAddress());
		offer.setLimitedNumber(o.getLimitedNumber());
		offer.setImage(null); // à modifier
		return offerRepo.save(offer);
	}

	@Override
	public Offer retrieveOffer(int id) {
		return offerRepo.findById(id).orElse(null);
	}

	@Override
	public void deleteOffer(int id) {
		offerRepo.deleteById(id);
	}

	@Override
	public List<Offer> retrieveByCategory(CategoryOffer category) {
		return offerRepo.findAllByCategory(category);
	}

	@Override
	public List<Offer> retrieveByDateExpAsc() {
		return offerRepo.findByOrderByDateExpAsc();
	}

	@Override
	public List<Offer> retrieveByDateExpDesc() {
		return offerRepo.findByOrderByDateExpDesc();
	}

	@Override
	public List<Offer> retrieveByPointAsc() {
		return offerRepo.findByOrderByPointAsc();
	}

	@Override
	public List<Offer> retrieveByPointDesc() {
		return offerRepo.findByOrderByPointDesc();
	}

	@Override
	public List<Offer> retrieveFullOffer(Long idUser) {
		List<Offer> full = new ArrayList<>();
		List<Offer> offers = offerRepo.findAll();
		for (Offer o : offers) {
			if (o.getLimitedNumber() == o.getPersonsNumber()) {
				full.add(o);
			}
		}
		return full;
	}

	@Override
	public void getOfferAndCoupon(HttpServletResponse response, int idOffer, Long idUser)
			throws DocumentException, IOException {
		Offer o = offerRepo.findById(idOffer).orElse(null);
		User u = userRepo.findById(idUser).orElse(null);
		
		//tester si l'offre est encore valable
		if (o.getPersonsNumber() < o.getLimitedNumber()) { 
			// Comparer les points d'user et les points de l'offre
			if (u.getBadge().getPoint() >= o.getPoint()) {
				// création coupon PDF
				response.setContentType("application/pdf");
				DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
				String currentDateTime = dateFormatter.format(new Date());

				String headerKey = "Content-Disposition";
				String headerValue = "attachment; filename=" + o.getTitle() + "_" + currentDateTime + ".pdf";
				response.setHeader(headerKey, headerValue);

				export(response, o, u);

				// mise à jours nombre de personnes de l'offre
				o.setPersonsNumber(o.getPersonsNumber() + 1);

				// mise à jours les points du user
				int up = u.getBadge().getPoint() - o.getPoint();
				u.getBadge().setPoint(up);
				userRepo.save(u);
				offerRepo.save(o);
			}
		}
	}

	public void export(HttpServletResponse response, Offer offer, User user) throws DocumentException, IOException {
		Document document = new Document(PageSize.A5.rotate());
		PdfWriter.getInstance(document, response.getOutputStream());

		DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
		Date todayy = new Date();
		Date tomorroww = new Date(todayy.getTime() + (1000 * 60 * 60 * 360)); // 15 jours avant l'éxpiration du coupon 
		String s = dateFormatter.format(tomorroww);

		document.open();

		Font font1 = FontFactory.getFont(FontFactory.COURIER_BOLD, Font.ITALIC);
		font1.setSize(20);
		font1.setColor(Color.PINK);

		Paragraph p = new Paragraph(offer.getTitle() + "\n\n", font1);
		p.setAlignment(Paragraph.ALIGN_CENTER);

		document.add(p);

		Font font2 = FontFactory.getFont(FontFactory.COURIER, Font.ITALIC);
		font2.setSize(20);
		font2.setColor(Color.BLACK);

		Paragraph p1 = new Paragraph(user.getFirstname() + " " + user.getLastName(), font2);
		Paragraph p2 = new Paragraph("Address : " + offer.getAddress(), font2);
		Paragraph p3 = new Paragraph("Category : " + offer.getCategory().toString(), font2);
		Paragraph p4 = new Paragraph("Expiration Date : " + s, font2);

		document.add(p1);
		document.add(p2);
		document.add(p3);
		document.add(p4);

		document.close();

	}

	@Override
	public List<Offer> searchOffer(String title) {
		return offerRepo.searchOffer(title);
	}

}

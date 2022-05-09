package pidev.spring.services;

import java.awt.Color;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import pidev.spring.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import pidev.spring.entities.Badge;
import pidev.spring.entities.Event;
import pidev.spring.entities.User;
import pidev.spring.repositories.BadgeRepository;

@Service
public class BadgeServices {
	@Autowired
	BadgeRepository BadgeRepository;
	@Autowired
	UserRepository UserRepository;

	public Badge addBadge(Badge c) {
		return BadgeRepository.save(c);
	}
	//Delete
	public void deleteBadge(int id) {
		BadgeRepository.deleteById(id);
	}
	//FindById
	public Badge retrieveBadge(int id) {
		return BadgeRepository.findById(id).orElse(null);
	}
	//Update
	public Badge updateBadge(Badge c) {
		Badge badge = BadgeRepository.findById((int) c.getId()).orElse(null);
		badge.setTitle(c.getTitle());
		badge.setDescription(c.getDescription());
		badge.setCost(c.getCost());
		return BadgeRepository.save(badge);
	}
	//FindAll
	public List<Badge> listedesBadges() {
		return BadgeRepository.findAll();
	}
	//Affecter BADGE To USER
	public String AffecterBadgeToUser (int idBadge, Long userid) {
		//l’affecter au centre commercial crée dans la question
		String check="";
		Badge Badge=BadgeRepository.findById(idBadge).orElse(null);
		User User=UserRepository.findById(userid).orElse(null);
		if(User.getAcquiredBadges().contains(Badge)) {
			System.out.println("User Already Joined Have This Badge");
			check="User Already Joined Have This Badge";
			return check;
		}else {
			if(User.getPoints()<Badge.getCost()) {
				System.out.println("You Cant Afford This Badge, Consider Joining Events To Win Enough Points.");
				check="You Cant Afford This Badge, Consider Joining Events To Win Enough Points.";
				return check;
	
			}else {
				User.setPoints(User.getPoints()-Badge.getCost());
				User.getAcquiredBadges().add(Badge);
				UserRepository.save(User);
				check="User Now Has The Badge";
				return check;
			}		
		}
	}
	//Remove BADGE From USER
	public String RemoveBadgeFromUser (int idBadge, Long userid) {
		//l’affecter au centre commercial crée dans la question
		
		Badge Badge=BadgeRepository.findById(idBadge).orElse(null);
		User User=UserRepository.findById(userid).orElse(null);
		if(!User.getAcquiredBadges().contains(Badge)) {
			System.out.println("User Already Does Not Have This Badge");
			return "User Already Does Not Have This Badge";
		}else {
			User.getAcquiredBadges().remove(Badge);
			UserRepository.save(User);
			return "Removed Badge";
					
		}
	}
	//USER List BADGES
	public Set<Badge> UserBadges (Long userid) {
		User User=UserRepository.findById(userid).orElse(null);
		return User.getAcquiredBadges();
	}
	//SortBadgeBy Id Asc
	public List<Badge> SortBadgesByIdAsc(){
		return BadgeRepository.findAllByOrderByIdAsc();
	}
	//SortBadgeBy Id Desc
	public List<Badge> SortBadgesByIdDesc(){
		return BadgeRepository.findAllByOrderByIdDesc();
	}
	//SortBadgeBy Title Asc
	public List<Badge> SortBadgesByTitleAsc(){
		return BadgeRepository.findAllByOrderByTitleAsc();
	}
	//SortBadgeBy Title Desc
	public List<Badge> SortBadgesByTitleDesc(){
		return BadgeRepository.findAllByOrderByTitleDesc();
	}
	//SortBadgeBy Description Asc
	public List<Badge> SortBadgesByDescriptionAsc(){
		return BadgeRepository.findAllByOrderByDescriptionAsc();
	}
	//SortBadgeBy Title Desc
	public List<Badge> SortBadgesByDescriptionDesc(){
		return BadgeRepository.findAllByOrderByDescriptionDesc();
	}
	//SortBadgeBy Top 10 Title Asc
	public List<Badge> SortBadgesTop10ByOrderByTitleAsc(){
		return BadgeRepository.findTop10ByOrderByTitleAsc();
	}
	//SortBadgeBy Top 10 Title Desc
	public List<Badge> SortBadgesTop10ByOrderByTitleDesc(){
			return BadgeRepository.findTop10ByOrderByTitleDesc();
	}
	public void PDFBadge(HttpServletResponse response, int idOffer, Long idUser) throws DocumentException, IOException {
		Badge o = BadgeRepository.findById(idOffer).orElse(null);
		User u = UserRepository.findById(idUser).orElse(null);
		
		
			//creation coupon
			response.setContentType("application/pdf");
			DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
			String currentDateTime = dateFormatter.format(new Date());
			
			String headerKey = "Content-Disposition";
			String headerValue = "attachment; filename=" + o.getTitle() + "_" + currentDateTime + ".pdf";
			response.setHeader(headerKey, headerValue);
			
			export(response,o, u);
	}
	public void export(HttpServletResponse response, Badge Badge, User user) throws DocumentException, IOException {
        Document document = new Document(PageSize.A6.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());
        
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
        Date todayy = new Date();
        Date tomorroww = new Date(todayy.getTime() + (1000 * 60 * 60 * 360));
        String s = dateFormatter.format(tomorroww);

        document.open();
        
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(20);
        font1.setColor(Color.PINK);
        
        Paragraph p = new Paragraph(Badge.getTitle(), font1);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
        
        Font font2 = FontFactory.getFont(FontFactory.HELVETICA);
        font2.setSize(20);
        font2.setColor(Color.BLACK);
       
        Paragraph p1 = new Paragraph(user.getFirstname() + " " + user.getUsername(), font2);
        Paragraph p2 = new Paragraph(String.valueOf(Badge.getTitle()), font2);
        Paragraph p3 = new Paragraph(Badge.getDescription(), font2);
        Paragraph p4 = new Paragraph("Expiration Date : "+s, font2);
        
        document.add(p1);
        document.add(p2);
        document.add(p3);
        document.add(p4);
        
         
        document.close();
         
    }
}

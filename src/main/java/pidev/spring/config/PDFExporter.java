package pidev.spring.config;

import java.awt.Color;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

import pidev.spring.entities.Offer;
import pidev.spring.entities.User;

public class PDFExporter {
	private Offer offer;
	private User user;
    
    public PDFExporter(Offer offer, User user) {
        this.offer = offer;
        this.offer = offer;
    }
 
    /*private void writeTableHeader(PdfPTable table) {
        PdfPCell cell = new PdfPCell();
        cell.setBackgroundColor(Color.BLUE);
        cell.setPadding(5);
         
        Font font = FontFactory.getFont(FontFactory.HELVETICA);
        font.setColor(Color.WHITE);
         
        cell.setPhrase(new Phrase("User ID", font));
         
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("E-mail", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Full Name", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Roles", font));
        table.addCell(cell);
         
        cell.setPhrase(new Phrase("Enabled", font));
        table.addCell(cell);       
    }*/
     
    /*private void writeTableData(PdfPTable table) {
        for (Offer user : listUsers) {
            table.addCell(String.valueOf(user.getIdOffer()));
            table.addCell(user.getDescription());
            table.addCell(user.getTitle());
            //table.addCell(user.getRoles().toString());
            table.addCell(String.valueOf(user.getPoint()));
        }
    }*/
     
    public void export(HttpServletResponse response) throws DocumentException, IOException {
        Document document = new Document(PageSize.A6.rotate());
        PdfWriter.getInstance(document, response.getOutputStream());
         
        document.open();
        
        Font font1 = FontFactory.getFont(FontFactory.HELVETICA_BOLD);
        font1.setSize(20);
        font1.setColor(Color.PINK);
        System.out.println(user.toString());
        Paragraph p = new Paragraph(offer.getTitle(), font1);
        p.setAlignment(Paragraph.ALIGN_CENTER);
         
        document.add(p);
        
        Font font2 = FontFactory.getFont(FontFactory.HELVETICA);
        font2.setSize(20);
        font2.setColor(Color.BLACK);
        
        System.out.println(user.toString());
        Paragraph p1 = new Paragraph(user.getFirstname() + " " + user.getLastName(), font2);
        Paragraph p2 = new Paragraph(String.valueOf(user.getBadge().getPoint()), font2);
        Paragraph p3 = new Paragraph(offer.getAddress(), font2);
        //Paragraph p4 = new Paragraph(o.getTitle(), font2);
        
        document.add(p1);
        document.add(p2);
        document.add(p3);
        //document.add(p4);
        
         
        document.close();
         
    }
}

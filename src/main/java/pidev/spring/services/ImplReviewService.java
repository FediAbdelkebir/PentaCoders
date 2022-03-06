package pidev.spring.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pidev.spring.entities.CategoryReview;
import pidev.spring.entities.Classification;
import pidev.spring.entities.Review;
import pidev.spring.entities.TypeReview;
import pidev.spring.entities.User;
import pidev.spring.repositories.ReviewRepository;
import pidev.spring.repositories.UserRepository;


@Service
public class ImplReviewService implements IReviewServices {

	
	@Autowired 
	ReviewRepository ReviewRepo;
	@Autowired 
	UserRepository userRepo;
	@Autowired 
	 JavaMailSender emailSender;
	
	
	@Override
	public List<Review> retrieveAllReview() {
		List<Review> review = (List<Review>) ReviewRepo.findAll();
		return review;
	}
	
	@Override
	public List<Review> ClassifictionReview(Review r) {
		/*	List<Review> review = (List<Review>) ReviewRepo.findAll();
		String	w = WordFiltre.getCensoredText(r.getContentReview());
		if (WordFiltre.getCensoredText(r.getContentReview()))
		{
			return r.setClassf()== "Bad";
		}
		else
		{
			
				commentRepository.save(comment);
				
				return r.setClassf('Good');
		}	*/
		
		return null ;
	}
	

	@Override
	public Review addReviewCompany(Review r , Long idUser ) {
		r.setEmployeeName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		
		//String	w = WordFiltre.getCensoredText(r.getContentReview());
		//System.out.println(w);
		if (WordFiltre.getCensoredText(r.getContentReview())=="Bad"){
			//System.out.println(w);
			r.setClassf(Classification.Bad);
		}
			else 
			
			{
				//System.out.println("Good");
				r.setClassf(Classification.Good);
			
			}
		sendSimpleEmail(u.getEmailAddress().toString(), "Review", "you have new Reveiw");
			
		return ReviewRepo.save(r);
	}
	@Override
	public Review addReviewEmployee(Review r, Long idUser) {
		r.setSocieteName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		sendSimpleEmail(u.getEmailAddress().toString(), "Review", "you have new Reveiw");
		return ReviewRepo.save(r);
	}

	@Override
	public Review updateReviewEmployee(Review r, Long idUser) {
		r.setSocieteName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return ReviewRepo.save(r);
	}
	
	@Override
	public Review updateReviewCompany(Review r, Long idUser) {
		r.setEmployeeName(null);
		User u = userRepo.findById(idUser).orElse(null);
		r.setUser(u);
		return ReviewRepo.save(r);
	}

	@Override
	public void deleteReview(Integer id) {
		ReviewRepo.deleteById(id);
		
	}

	@Override
	public Review addReviewEmployeEtAffecter(Review R, Long idUser) {
		R.setSocieteName(null);
		User u = userRepo.findById(idUser).orElse(null);
		R.setUser(u);
		ReviewRepo.save(R);
        List<Review> Review = new ArrayList<>();
        List<User> users = userRepo.findAll();
        
        for(User U : users){
        	System.out.println(U.getEmailAddress());
            if(R.getEmployeeName() .equals( U.getEmailAddress())){
            	//System.out.println(R.getContentReview());
            	//System.out.println(U.toString());
            }
            
            if (WordFiltre.getCensoredText(R.getContentReview())=="Bad"){
            	
    			//System.out.println(w);
    			R.setClassf(Classification.Bad);
    		}
    			else 
    			
    			{
    				//System.out.println("Good");
    				R.setClassf(Classification.Good);
    			
    			}
            
        }
		sendSimpleEmail(u.getEmailAddress().toString(), "Review", "you have new Reveiw");
        return R;
    }
	
	
	@Override
	public Review addReviewCompanyEtAffecter(Review R, Long idUser) {
		R.setEmployeeName(null);
		User u = userRepo.findById(idUser).orElse(null);
		R.setUser(u);
		ReviewRepo.save(R);
        List<Review> Review = new ArrayList<>();
        List<User> users = userRepo.findAll();
        
        for(User U : users){
        	System.out.println(U.getEmailAddress());
            if(R.getSocieteName() .equals( U.getEmailAddress())){
            	//System.out.println(R.getContentReview());
            	//System.out.println(U.toString());
            }
if (WordFiltre.getCensoredText(R.getContentReview())=="Bad"){
            	
    			//System.out.println(w);
    			R.setClassf(Classification.Bad);
    		}
    			else 
    			
    			{
    				//System.out.println("Good");
    				R.setClassf(Classification.Good);
    			
    			}
            
        }
		sendSimpleEmail(u.getEmailAddress().toString(), "Review", "you have new Reveiw ");
        return R;
    }
	
	//filtre by categoryyy
	@Override
	public List<Review> retrieveByCategorie(CategoryReview categorie) {
		
		return ReviewRepo.findByCategory(categorie);
	} 
	//filtre by Annonyme et publiccc
	@Override
	public List<Review> retrieveByType(TypeReview review) {
		
		return ReviewRepo.findByReview(review);
	}
	//search By Name Employee
	@Override
	public List<Review> searchReviewEm(String EmployeeName) {
		
		return ReviewRepo.searchReviewEmp(EmployeeName);
	}

	//search by name Societe
	@Override
	public List<Review> searchReviewSociete(String SocieteName) {
		
		return ReviewRepo.searchReviewSociete(SocieteName);
	} 
	
	public void sendSimpleEmail(String toAddress, String subject, String message) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setTo(toAddress);
        simpleMailMessage.setSubject(subject);
        simpleMailMessage.setText(message);
        emailSender.send(simpleMailMessage);
    }

	//Classification
		@Override
		public List<Review> retrieveByClassification(Classification classf) {
			
			return ReviewRepo.findByClassf(classf);
		} 
	//Affiche by userId
	
	
}

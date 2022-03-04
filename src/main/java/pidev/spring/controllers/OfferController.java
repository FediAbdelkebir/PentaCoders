package pidev.spring.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lowagie.text.DocumentException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import pidev.spring.entities.CategoryOffer;
import pidev.spring.entities.Offer;
import pidev.spring.services.ServiceOffer;

@RestController
@RequestMapping("/Offer")
@Api(tags = "Offer Controller")
public class OfferController {

	//http://localhost:8089/WorkMood/swagger-ui/index.html
	
	@Autowired
	ServiceOffer offerService;
	
	@GetMapping("/ShowAllOffers")
	@ResponseBody
	@ApiOperation(value="Show all offers")
	List<Offer> retrieveAllOffers(){
		return offerService.retrieveAllOffers();
	}
	
	@PostMapping("/AddOffer/{idUser}")
	@ResponseBody
	@ApiOperation(value="Add offer")
	Offer addOffer(@RequestBody Offer o, @PathVariable Long idUser){
		return offerService.addOffer(o, idUser);
	}
	
	@PutMapping("/UpdateOffer")
	@ResponseBody
	@ApiOperation(value="Update offer")
	Offer updateOffer(@RequestBody Offer o){
		return offerService.updateOffer(o);
	}
	
	@GetMapping("/ShowOffer/{id}")
	@ResponseBody
	@ApiOperation(value="Show offer by id ")
	Offer retrieveOffer(@PathVariable(name="id") int id){
		return offerService.retrieveOffer(id);
	}
	
	@DeleteMapping("/DeleteOffer/{id}")
	@ApiOperation(value="Delete offer")
	void deleteOffer(@PathVariable(name="id") int id){
		offerService.deleteOffer(id);
	}
	
	@PostMapping("/AffectUserToOffer/{idUser}/{idOffer}")
	@ResponseBody
	@ApiOperation(value="Affect offer to user")
	void affectUserToOffer(@PathVariable int idOffer, @PathVariable Long idUser){
		offerService.affectUserToOffer(idOffer, idUser);
	}
	
	@GetMapping("/FindOfferByCategory")
	@ResponseBody
	@ApiOperation(value="Find by category")
	List<Offer> retrieveByCategory(@RequestParam CategoryOffer category){
		return offerService.retrieveByCategory(category);
	}
	
	@GetMapping("/FindOfferByDateExpAsc")
	@ResponseBody
	@ApiOperation(value="Find by DateExp Asc")
	List<Offer> retrieveByDateExpAsc(){
		return offerService.retrieveByDateExpAsc();
	}
	
	@GetMapping("/FindOfferByDateExpDesc")
	@ResponseBody
	@ApiOperation(value="Find by DateExp Desc")
	List<Offer> retrieveByDateExpDesc(){
		return offerService.retrieveByDateExpDesc();
	}
	
	@GetMapping("/FindOfferByPointAsc")
	@ResponseBody
	@ApiOperation(value="Find by Point Asc")
	List<Offer> retrieveByPointAsc(){
		return offerService.retrieveByPointAsc();
	}
	
	@GetMapping("/FindOfferByPointDesc")
	@ResponseBody
	@ApiOperation(value="Find by Point Desc")
	List<Offer> retrieveByPointDesc(){
		return offerService.retrieveByPointDesc();
	}
	
	@GetMapping("/ShowFullOffers")
	@ResponseBody
	@ApiOperation(value="Show full offers")
	List<Offer> retrieveFullOffer(Long idUser){
		return offerService.retrieveFullOffer(idUser);
	}
	
	@GetMapping("/GetOfferAndCoupon/{idUser}/{idOffer}")
    public void getOfferAndCoupon(HttpServletResponse response, @PathVariable int idOffer, @PathVariable Long idUser) throws DocumentException, IOException {
        offerService.getOfferAndCoupon(response, idOffer, idUser);
    }
	
	@GetMapping("/SearchOffer/{title}")
	@ResponseBody
	public List<Offer> searchOffer(@PathVariable("title") String title) {
	return offerService.searchOffer(title);
}
	

}

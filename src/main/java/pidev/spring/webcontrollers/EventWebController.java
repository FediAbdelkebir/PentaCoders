package pidev.spring.webcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import pidev.spring.entities.Event;
import pidev.spring.entities.Event;
import pidev.spring.entities.User;
import pidev.spring.services.EventServices;

@RestController
@RequestMapping("/Evenements")
public class EventWebController {
	@Autowired
	EventServices ES;
	//Add
	@PostMapping("/AddEvent")
	@ResponseBody //trajaa retour
void AddEvent(@RequestBody Event event) {
		try {
			ES.addEvent(event);
			
		}catch(Exception e){
			System.out.println("An Error Occured While Adding an Event ");
		}
		
	}
	
	//Update
	@PostMapping("/UpdateEvent")
	@ResponseBody //trajaa retour
void UpdateEvent(@RequestBody Event event) {
		try {
			ES.updateEvent(event);
		}catch(Exception e){
			System.out.println("An Error Occured While Updating an Event ");
		}
		
	}
	//Delete
		@GetMapping("/DeleteEvent/{idEvent}")
		@ResponseBody
void DeleteEvent(@PathVariable("idEvent") int idEvent){
			try{
				ES.deleteEvent(idEvent);
				System.out.println("Event Deleted");
				}
			catch(Exception e) {
				System.out.println("An Error Occured While Deleting an Event ");
			}
			}
	//FindAll
	@GetMapping("/Events")
	@ResponseBody
List<Event> Events(){
		System.out.println(ES.listedesEvents());
		return ES.listedesEvents();
		}
	
	//FindById
	@GetMapping("/FindEvent/{idEvent}")
	@ResponseBody
	Event FindEventById(@PathVariable("idEvent") int idEvent){
		System.out.println(ES.retrieveEvent(idEvent));
			return ES.retrieveEvent(idEvent);
	}
	
	//AffecterEventToUser
			@PostMapping("/AffecterEventToUser/{badge}/{userid}")
			@ResponseBody
			User FindEventById(@PathVariable("badge") int badge,@PathVariable("userid") int userid){
				return ES.AffecterEventToUser(badge, userid);
			}
	//SortEventsByIdDesc
			@PostMapping("/SortEventsByIdDesc")
			@ResponseBody
			List<Event> SortEventsByIdDesc(){
				return ES.SortEventsByIdDesc();
			}
	//SortEventsByIdAsc
			@PostMapping("/SortEventsByIdAsc")
			@ResponseBody
			List<Event> SortEventsByIdAsc(){
				return ES.SortEventsByIdAsc();
			}
	//SortEventsByTitleAsc
			@PostMapping("/SortEventsByTitleAsc")
			@ResponseBody
			List<Event> SortEventsByTitleAsc(){
				return ES.SortEventsByTitleAsc();
			}
	//SortEventsByTitleDesc
			@PostMapping("/SortEventsByTitleDesc")
			@ResponseBody
			List<Event> SortEventsByTitleDesc(){
				return ES.SortEventsByTitleDesc();
			}
	//SortEventsByDescriptionAsc
			@PostMapping("/SortEventsByDescriptionAsc")
			@ResponseBody
			List<Event> SortEventsByDescriptionAsc(){
				return ES.SortEventsByDescriptionAsc();
			}
	//SortEventsByDescriptionDesc
			@PostMapping("/SortEventsByDescriptionDesc")
			@ResponseBody
			List<Event> SortEventsByDescriptionDesc(){
				return ES.SortEventsByDescriptionDesc();
			}
//SortEventsByDateStartAsc
			@PostMapping("/SortEventsByDateStartAsc")
			@ResponseBody
			List<Event> SortEventsByDateStartAsc(){
				return ES.SortEventsByDateStartAsc();
			}
//SortEventsByDateStartDesc
			@PostMapping("/SortEventsByDateStartDesc")
			@ResponseBody
			List<Event> SortEventsByDateStartDesc(){
				return ES.SortEventsByDateStartDesc();
			}
//SortEventsByDateEndAsc
			@PostMapping("/SortEventsByDateEndAsc")
			@ResponseBody
			List<Event> SortEventsByDateEndAsc(){
				return ES.SortEventsByDateEndAsc();
			}
//SortEventsByDateEndDesc
			@PostMapping("/SortEventsByDateEndDesc")
			@ResponseBody
			List<Event> SortEventsByDateEndDesc(){
				return ES.SortEventsByDateEndDesc();
			}
//SortEventsByNbrplaceAsc
			@PostMapping("/SortEventsByNbrplaceAsc")
			@ResponseBody
			List<Event> SortEventsByNbrplaceAsc(){
				return ES.SortEventsByNbrplaceAsc();
			}
//SortEventsByNbrPlaceDesc
			@PostMapping("/SortEventsByNbrPlaceDesc")
			@ResponseBody
			List<Event> SortEventsByNbrPlaceDesc(){
				return ES.SortEventsByNbrplaceDesc();
			}
//SortEventsByTypeAsc
			@PostMapping("/SortEventsByTypeAsc")
			@ResponseBody
			List<Event> SortEventsByTypeAsc(){
				return ES.SortEventsByTypeAsc();
			}
//SortEventsByTypeDesc
			@PostMapping("/SortEventsByTypeDesc")
			@ResponseBody
			List<Event> SortEventsByTypeDesc(){
				return ES.SortEventsByTypeDesc();
			}
//SortEventsByTrouphyAsc
			@PostMapping("/SortEventsByTrouphyAsc")
			@ResponseBody
			List<Event> SortEventsByTrouphyAsc(){
				return ES.SortEventsByTrouphyAsc();
			}
//SortEventsByTrouphyDesc
			@PostMapping("/SortEventsByTrouphyDesc")
			@ResponseBody
			List<Event> SortEventsByTrouphyDesc(){
				return ES.SortEventsByTrouphyDesc();
			}
	//SortEventsTop10ByOrderByTitleAsc
			@PostMapping("/SortEventsTop10ByOrderByTitleAsc")
			@ResponseBody
			List<Event> SortEventsTop10ByOrderByTitleAsc(){
				return ES.SortEventsTop10ByOrderByTitleAsc();
			}
	//SortEventsTop10ByOrderByTitleDesc
			@PostMapping("SortEventsTop10ByOrderByTitleDesc")
			@ResponseBody
			List<Event> SortEventsTop10ByOrderByTitleDesc(){
				return ES.SortEventsTop10ByOrderByTitleDesc();
			}
}

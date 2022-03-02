package pidev.spring.webcontrollers;

import java.util.Date;
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
import pidev.spring.entities.EventType;
import pidev.spring.entities.Event;
import pidev.spring.entities.User;
import pidev.spring.services.EventServices;
import pidev.spring.services.MailSenderFactory;

@RestController
@RequestMapping("/Evenements")
public class EventWebController {
	@Autowired
	EventServices ES;
	@Autowired
	MailSenderFactory MSF;
	
	@PostMapping("/MailTest")
	@ResponseBody //trajaa retour
void MailTest() {
		try {
			MSF.sendSimpleEmail("abdelkebir.fedi@esprit.tn", "Tester", "Testmessage");
			
		}catch(Exception e){
			System.out.println("An Error Occured While Adding an Event ");
		}
		
	}
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
//Find By Title
	@GetMapping("/FindEvent/Title/{Title}")
	@ResponseBody
	Event FindEventById(@PathVariable("Title") String Title){
		System.out.println(ES.FindEventByTitle(Title));
			return ES.FindEventByTitle(Title);
	}
//Find By DateStart
		@GetMapping("/FindEvent/DateStart/{DateStart}")
		@ResponseBody
		List<Event> FindEventByDateStart(@PathVariable("DateStart") Date DateStart){
			System.out.println(ES.FindEventByDateStart(DateStart));
				return ES.FindEventByDateStart(DateStart);
		}
//Find By DateEnd
		@GetMapping("/FindEvent/DateEnd/{DateEnd}")
		@ResponseBody
		List<Event> FindEventByDateEnd(@PathVariable("DateEnd") Date DateEnd){
			System.out.println(ES.FindEventByDateEnd(DateEnd));
			return ES.FindEventByDateEnd(DateEnd);
		}
//Find By Type
		@GetMapping("/FindEvent/Type/{Type}")
		@ResponseBody
		List<Event> FindEventByType(@PathVariable("Type") EventType Type){
					System.out.println(ES.FindEventByType(Type));
					return ES.FindEventByType(Type);
				}
	//AffecterEventToUser
			@PostMapping("/AffecterEventToUser/{badge}/{userid}")
			@ResponseBody
			User FindEventById(@PathVariable("badge") int badge,@PathVariable("userid") int userid){
				return ES.AffecterEventToUser(badge, userid);
			}
	//SortEventsByIdDesc
			@GetMapping("/SortEventsByIdDesc")
			@ResponseBody
			List<Event> SortEventsByIdDesc(){
				return ES.SortEventsByIdDesc();
			}
	//SortEventsByIdAsc
			@GetMapping("/SortEventsByIdAsc")
			@ResponseBody
			List<Event> SortEventsByIdAsc(){
				return ES.SortEventsByIdAsc();
			}
	//SortEventsByTitleAsc
			@GetMapping("/SortEventsByTitleAsc")
			@ResponseBody
			List<Event> SortEventsByTitleAsc(){
				return ES.SortEventsByTitleAsc();
			}
	//SortEventsByTitleDesc
			@GetMapping("/SortEventsByTitleDesc")
			@ResponseBody
			List<Event> SortEventsByTitleDesc(){
				return ES.SortEventsByTitleDesc();
			}
	//SortEventsByDescriptionAsc
			@GetMapping("/SortEventsByDescriptionAsc")
			@ResponseBody
			List<Event> SortEventsByDescriptionAsc(){
				return ES.SortEventsByDescriptionAsc();
			}
	//SortEventsByDescriptionDesc
			@GetMapping("/SortEventsByDescriptionDesc")
			@ResponseBody
			List<Event> SortEventsByDescriptionDesc(){
				return ES.SortEventsByDescriptionDesc();
			}
//SortEventsByDateStartAsc
			@GetMapping("/SortEventsByDateStartAsc")
			@ResponseBody
			List<Event> SortEventsByDateStartAsc(){
				return ES.SortEventsByDateStartAsc();
			}
//SortEventsByDateStartDesc
			@GetMapping("/SortEventsByDateStartDesc")
			@ResponseBody
			List<Event> SortEventsByDateStartDesc(){
				return ES.SortEventsByDateStartDesc();
			}
//SortEventsByDateEndAsc
			@GetMapping("/SortEventsByDateEndAsc")
			@ResponseBody
			List<Event> SortEventsByDateEndAsc(){
				return ES.SortEventsByDateEndAsc();
			}
//SortEventsByDateEndDesc
			@GetMapping("/SortEventsByDateEndDesc")
			@ResponseBody
			List<Event> SortEventsByDateEndDesc(){
				return ES.SortEventsByDateEndDesc();
			}
//SortEventsByNbrplaceAsc
			@GetMapping("/SortEventsByNbrplaceAsc")
			@ResponseBody
			List<Event> SortEventsByNbrplaceAsc(){
				return ES.SortEventsByNbrplaceAsc();
			}
//SortEventsByNbrPlaceDesc
			@GetMapping("/SortEventsByNbrPlaceDesc")
			@ResponseBody
			List<Event> SortEventsByNbrPlaceDesc(){
				return ES.SortEventsByNbrplaceDesc();
			}
//SortEventsByTypeAsc
			@GetMapping("/SortEventsByTypeAsc")
			@ResponseBody
			List<Event> SortEventsByTypeAsc(){
				return ES.SortEventsByTypeAsc();
			}
//SortEventsByTypeDesc
			@GetMapping("/SortEventsByTypeDesc")
			@ResponseBody
			List<Event> SortEventsByTypeDesc(){
				return ES.SortEventsByTypeDesc();
			}
//SortEventsByTrouphyAsc
			@GetMapping("/SortEventsByTrouphyAsc")
			@ResponseBody
			List<Event> SortEventsByTrouphyAsc(){
				return ES.SortEventsByTrouphyAsc();
			}
//SortEventsByTrouphyDesc
			@GetMapping("/SortEventsByTrouphyDesc")
			@ResponseBody
			List<Event> SortEventsByTrouphyDesc(){
				return ES.SortEventsByTrouphyDesc();
			}
	//SortEventsTop10ByOrderByTitleAsc
			@GetMapping("/SortEventsTop10ByOrderByTitleAsc")
			@ResponseBody
			List<Event> SortEventsTop10ByOrderByTitleAsc(){
				return ES.SortEventsTop10ByOrderByTitleAsc();
			}
	//SortEventsTop10ByOrderByTitleDesc
			@GetMapping("SortEventsTop10ByOrderByTitleDesc")
			@ResponseBody
			List<Event> SortEventsTop10ByOrderByTitleDesc(){
				return ES.SortEventsTop10ByOrderByTitleDesc();
			}
}

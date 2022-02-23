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
}

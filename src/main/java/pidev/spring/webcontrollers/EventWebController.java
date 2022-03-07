package pidev.spring.webcontrollers;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import pidev.spring.entities.Event;
import pidev.spring.entities.EventTags;
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
	String AddEvent(@RequestBody Event event) {
		try {
			ES.addEvent(event);
			
		}catch(Exception e){
			System.out.println("An Error Occured While Adding an Event ");
		}
		return "Event Succefully Added.";
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
//Find By Multiple Critére :
	//findByDateStartAndDateEnd
		@GetMapping("/FindEvent/FindByDateStartAndDateEnd/{DateStart}/{DateEnd}")
		@ResponseBody
		List<Event> findByDateStartAndDateEnd(@PathVariable("DateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date StartDate,@PathVariable("DateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateEnd){
			return ES.findByDateStartAndDateEnd(StartDate,DateEnd);
		}
	//findByDateStartAndTrouphy
		@GetMapping("/FindEvent/FindByDateStartAndTrouphy/{DateStart}/{Trouphy}")
		@ResponseBody
		List<Event> findByDateStartAndTrouphy(@PathVariable("DateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date StartDate,@PathVariable("Trouphy") boolean Trouphy){
			return ES.findByDateStartAndTrouphy(StartDate,Trouphy);
		}
	//findByDateEndAndTrouphy
		@GetMapping("/FindEvent/FindByDateEndAndTrouphy/{DateEnd}/{Trouphy}")
		@ResponseBody
		List<Event> FindByDateEndAndTrouphy(@PathVariable("DateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateEnd,@PathVariable("Trouphy") boolean Trouphy){
			return ES.findByDateEndAndTrouphy(DateEnd,Trouphy);
		}
		//findByDateStartAndType
		@GetMapping("/FindEvent/FindByDateStartAndType/{DateStart}/{Type}")
		@ResponseBody
		List<Event> findByDateStartAndType(@PathVariable("DateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date StartDate,@PathVariable("Type") EventType Type){
			return ES.findByDateStartAndType(StartDate,Type);
		}
	//FindByDateEndAndType
		@GetMapping("/FindEvent/FindByDateEndAndType/{DateEnd}/{Type}")
		@ResponseBody
		List<Event> FindByDateEndAndType(@PathVariable("DateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateEnd,@PathVariable("Type") EventType Type){
			return ES.FindByDateEndAndType(DateEnd,Type);
		}
	//findByTypeAndTrouphy
		@GetMapping("/FindEvent/FindByTypeAndTrouphy/{Type}/{Trouphy}")
		@ResponseBody
		List<Event> FindByTypeAndTrouphy(@PathVariable("Type") EventType Type,@PathVariable("Trouphy") boolean Trouphy){
			return ES.findByTypeAndTrouphy(Type,Trouphy);
		}
	//findByDateStartAndDateEndAndTrouphy
		@GetMapping("/FindEvent/FindByDateStartAndDateEnd/{DateStart}/{DateEnd}/{Trouphy}")
		@ResponseBody
		List<Event> findByDateStartAndDateEndAndTrouphy(@PathVariable("DateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date StartDate,@PathVariable("DateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateEnd,@PathVariable("Trouphy") boolean Trouphy){
			return ES.findByDateStartAndDateEndAndTrouphy(StartDate,DateEnd,Trouphy);
		}
	//findByDateStartAndDateEndAndTrouphyAndType
		@GetMapping("/FindEvent/FindByDateStartAndDateEnd/{DateStart}/{DateEnd}/{Trouphy}/{Type}")
		@ResponseBody
		List<Event> findByDateStartAndDateEndAndTrouphyAndType(@PathVariable("DateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date StartDate,@PathVariable("DateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateEnd,@PathVariable("Trouphy") boolean Trouphy,@PathVariable("Type") EventType Type){
			return ES.findByDateStartAndDateEndAndTrouphyAndType(StartDate,DateEnd,Trouphy,Type);
		}
	//findAllByStartDateLessThanEqualAndDateEndGreaterThanEqual
		@GetMapping("/FindEvent/FindAllBetween/{DateStart}/{DateEnd}")
		@ResponseBody
		List<Event> findAllByStartDateLessThanEqualAndDateEndGreaterThanEqual(@PathVariable("DateStart") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date StartDate,@PathVariable("DateEnd") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date DateEnd){
			return ES.findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual(StartDate,DateEnd);
		}
////
	//AffecterEventToUser
			@PostMapping("/AffecterEventToUser/{Event}/{userid}")
			@ResponseBody
			String FindEventById(@PathVariable("Event") int Event,@PathVariable("userid") int userid){
				return ES.AffecterEventToUser(Event, userid);
			}
	//RemoveUserFromEvent
			@GetMapping("/RemoveUserFromEvent/{idEvent}/{idUser}")
			@ResponseBody
			String RemoveUserFromEvent(@PathVariable("idEvent") int idEvent,@PathVariable("idUser") int idUser){
				return ES.RemoveUserFromEvent(idEvent, idUser);
			}
	//RemoveUserFromEvent
			@GetMapping("/UserJoinedEvents/{idUser}")
			@ResponseBody
			Set<Event> UserJoinedEvents(@PathVariable("idUser") int idUser){
				return ES.UserJoinedEvents(idUser);
			}
	//Recommendations 
			@GetMapping("/RecomendedEvents/{Tags}")
			@ResponseBody
			List<Event> UserJoinedEvents(@PathVariable("Tags") EventTags Tags){
				return ES.RecommendedEvents(Tags);
			}
	//LikeEvent 
			@PostMapping("/LikeEvent/{idEvent}/{idUser}")
			@ResponseBody
			String  UserJoinedEvents(@PathVariable("idEvent") int idEvent,@PathVariable("idUser") int idUser){
				return ES.LikeEvent(idEvent,idUser);
			}
	//DisLikeEvent 
			@PostMapping("/DisLikeEvent/{idEvent}/{idUser}")
			@ResponseBody
			String  DislikeEvent(@PathVariable("idEvent") int idEvent,@PathVariable("idUser") int idUser){
				return ES.DisLikeEvent(idEvent,idUser);
			}
	//LikedEventById 
			@GetMapping("/LikedEventById/{idUser}")
			@ResponseBody
			Set<Event>  LikedEventById(@PathVariable("idUser") int idUser){
				return ES.LikedEventById(idUser);
			}
	//LikedEventById 
			@GetMapping("/LikedUsersByEventId/{idEvent}")
			@ResponseBody
			Set<User>  LikedUsersByEventId(@PathVariable("idEvent") int idEvent){
				return ES.LikedUsersByEventId(idEvent);
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
	//Nombre TOTAL Events
			@GetMapping("/TotalNumberEvents")
			@ResponseBody
	int TotalNumberEvents(){
				return ES.TotalNumberEvents();
				}
	//Nombre Total CHALLENGE
			@GetMapping("/TotalNumberEventsChallenge")
			@ResponseBody
	int TotalNumberEventsChallenge(){
				return ES.TotalNumberEventsChallenge();
				}
	//Nombre Total FORMATION
			@GetMapping("/TotalNumberEventsFORMATION")
			@ResponseBody
	int TotalNumberEventsFORMATION(){
				return ES.TotalNumberEventsFormation();
				}
	//Nombre Total Trouphy=true
			@GetMapping("/TotalNumberEventsTrouphyTrue")
			@ResponseBody
	int TotalNumberEventsTrouphyTrue(){
				return ES.TotalNumberEventsTrouphyTrue();
				}
	//Nombre Total Trouphy=false
			@GetMapping("/TotalNumberEventsTrouphyFalse")
			@ResponseBody
	int TotalNumberEventsTrouphyFalse(){
				return ES.TotalNumberEventsTrouphyFalse();
				}
}

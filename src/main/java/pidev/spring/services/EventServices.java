package pidev.spring.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Event;
import pidev.spring.entities.EventType;
import pidev.spring.entities.Event;
import pidev.spring.entities.User;
import pidev.spring.repositories.EventRepository;
import pidev.spring.repositories.UserRepository;

@Service
public class EventServices {
	@Autowired
	EventRepository EventRepository;
	@Autowired
	UserRepository UserRepository;
	//Ajout
	public Event addEvent(Event c) {
		return EventRepository.save(c);
	}
	//Delete
	public void deleteEvent(int id) {
		EventRepository.deleteById(id);
	}
	//FindById
	public Event retrieveEvent(int id) {
		return EventRepository.findById(id).orElse(null);
	}
	//Update
	public Event updateEvent(Event c) {
		Event event = EventRepository.findById((int) c.getId()).orElse(null);
		event.setDateEnd(c.getDateEnd());
		event.setDateStart(c.getDateStart());
		event.setDescription(c.getDescription());
		event.setNbrplace(c.getNbrplace());
		event.setTitle(c.getTitle());
		event.setTrouphy(c.isTrouphy());
		event.setType(c.getType());
		return EventRepository.save(event);
	}
	//FindAll
	public List<Event> listedesEvents() {
		return EventRepository.findAll();
	}
	//Find By Title
	public Event FindEventByTitle(String Title) {
		return EventRepository.findByTitle(Title);
	}
	//Find By DateStart
	public List<Event> FindEventByDateStart(Date DateStart) {
		return EventRepository.findByDateStart(DateStart);
	}
	//Find By DateEnd
	public List<Event> FindEventByDateEnd(Date DateEnd) {
		return EventRepository.findByDateEnd(DateEnd);
	}
	//Find By Type
	public List<Event> FindEventByType(EventType EventType) {
		return EventRepository.findByType(EventType);
	}

	/*
	public void ajouterEtaffecterListeevent (List<Event> lb, Long idCentre) {
		//ajouter à la fois la liste des events suivante
		EventRepository.saveAll(lb);
		
		//l’affecter au centre commercial crée dans la question
		CentreCommercial C=CR.findById(idCentre).orElse(null);
		C.getEvents().addAll(lb);
		CR.save(C);
	}*/
	
	//Affecter Event To User
		public User AffecterEventToUser (int badge, long userid) {
			//l’affecter au centre commercial crée dans la question
			Event Event=EventRepository.findById(badge).orElse(null);
			User User=UserRepository.findById(userid).orElse(null);
			//User.setEvent(Event);
			return UserRepository.save(User);
			
		}
		//SortEventBy Id Asc
		public List<Event> SortEventsByIdAsc(){
			return EventRepository.findAllByOrderByIdAsc();
		}
		//SortEventBy Id Desc
		public List<Event> SortEventsByIdDesc(){
			return EventRepository.findAllByOrderByIdDesc();
		}
		//SortEventBy Title Asc
		public List<Event> SortEventsByTitleAsc(){
			return EventRepository.findAllByOrderByTitleAsc();
		}
		//SortEventBy Title Desc
		public List<Event> SortEventsByTitleDesc(){
			return EventRepository.findAllByOrderByTitleDesc();
		}
		//SortEventBy DateStart Asc
		public List<Event> SortEventsByDateStartAsc(){
			return EventRepository.findAllByOrderByDateStartAsc();
		}
		//SortEventBy DateStart Desc
		public List<Event> SortEventsByDateStartDesc(){
			return EventRepository.findAllByOrderByDateStartDesc();
		}
		//SortEventBy DateEnd Asc
		public List<Event> SortEventsByDateEndAsc(){
			return EventRepository.findAllByOrderByDateEndAsc();
		}
		//SortEventBy DateStart Desc
		public List<Event> SortEventsByDateEndDesc(){
			return EventRepository.findAllByOrderByDateEndDesc();
		}
		//SortEventBy NbrPlace Asc
		public List<Event> SortEventsByNbrplaceAsc(){
			return EventRepository.findAllByOrderByNbrplaceAsc();
		}
		//SortEventBy Nbrplace Desc
		public List<Event> SortEventsByNbrplaceDesc(){
			return EventRepository.findAllByOrderByNbrplaceDesc();
		}
		//SortEventBy Type Asc
		public List<Event> SortEventsByTypeAsc(){
			return EventRepository.findAllByOrderByTypeAsc();
		}
		//SortEventBy Type Desc
		public List<Event> SortEventsByTypeDesc(){
			return EventRepository.findAllByOrderByTypeDesc();
		}
		//SortEventBy Type Asc
		public List<Event> SortEventsByTrouphyAsc(){
			return EventRepository.findAllByOrderByTrouphyAsc();
		}
		//SortEventBy Type Desc
		public List<Event> SortEventsByTrouphyDesc(){
			return EventRepository.findAllByOrderByTrouphyDesc();
		}
		//SortEventBy Description Asc
		public List<Event> SortEventsByDescriptionAsc(){
			return EventRepository.findAllByOrderByDescriptionAsc();
		}
		//SortEventBy Title Desc
		public List<Event> SortEventsByDescriptionDesc(){
			return EventRepository.findAllByOrderByDescriptionDesc();
		}
		//SortEventBy Top 10 Title Asc
		public List<Event> SortEventsTop10ByOrderByTitleAsc(){
			return EventRepository.findTop10ByOrderByTitleAsc();
		}
		//SortEventBy Top 10 Title Desc
		public List<Event> SortEventsTop10ByOrderByTitleDesc(){
				return EventRepository.findTop10ByOrderByTitleDesc();
		}
		/////
		
		}

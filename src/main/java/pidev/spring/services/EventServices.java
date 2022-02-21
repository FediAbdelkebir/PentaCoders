package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Event;
import pidev.spring.repositories.EventRepository;

@Service
public class EventServices {
	@Autowired
	EventRepository EventRepository;
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
		
		return EventRepository.save(event);
	}
	//FindAll
	public List<Event> listedesEvents() {
		return EventRepository.findAll();
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
}

package pidev.spring.services;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Event;
import pidev.spring.entities.EventTags;
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
	/*
	public String addEvent(Event c) {
		if(c.getDateStart().after(c.getDateEnd())) {
			System.out.println( "Invalid Date Interval. Please Check That The Starting Date Is Before The Ending Date");
			return "Invalid Date Interval. Please Check That The Starting Date Is Before The Ending Date";
		}else {
			 EventRepository.save(c);
			 System.out.println( "Event Succefully Added.");
			return "Event Succefully Added.";
		}
		
	}*/
	public String addEvent(Event c) {
		EventRepository.save(c);
		return "test";
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
	public String updateEvent(Event c) {
		Event event = EventRepository.findById((int) c.getId()).orElse(null);
		event.setDateEnd(c.getDateEnd());
		event.setDateStart(c.getDateStart());
		event.setDescription(c.getDescription());
		event.setNpDisponible(c.getNpDisponible());
		event.setNpMax(c.getNpMax());
		event.setEventpoints(c.getEventpoints());
		event.setEventTags(c.getEventTags());
		event.setTitle(c.getTitle());
		event.setTrouphy(c.isTrouphy());
		event.setType(c.getType());
		event.setCoverimage(c.getCoverimage());
		if(event.getDateStart().after(event.getDateEnd())){
			System.out.println( "Invalid Date Interval. Please Check That The Starting Date Is Before The Ending Date");
			return "Event Starting Date Should be Before The Event Ending Date";
		}else{
			EventRepository.save(event);	
			return "Event Updated ";
		}
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
	
	//Affecter User To Event
		public String AffecterEventToUser (int idEvent, Long userid) {
			//l’affecter au centre commercial crée dans la question
			boolean check=true;
			boolean placecheck=true;
			Event Event=EventRepository.findById(idEvent).orElse(null);
			User User=UserRepository.findById(userid).orElse(null);
			if(Event.getUsers().contains(User)) {
				System.out.println("User Already Joined This Event");
				return "User Already Joined This Event";
			}else {
				for (Event E : User.getEvents()) {
		            if(E.getDateStart().equals(Event.getDateStart())) {
		            	check=false;
		            	return "You Cant Join More Two Events With The Same Starting Date";
		            }
		        }
				if(check==false) {
	            	return "You Cant Join More Two Events With The Same Starting Date ";
				}else { 
					if(Event.getNpDisponible()<Event.getNpMax()) {
						Event.setNpDisponible(Event.getNpDisponible()+1);
						Event.getUsers().add(User);
						UserRepository.save(User);
						return "Affecting User..";
				}else {
					return "You Can't Join This Event Its Full.";
				}
					
				}
				
						
			}
		}
		//Event Winners
		public void EventWinners () {
		    SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");  
		    Date date = new Date(); 
			List<Event> Event=EventRepository.findAll();
			for(Event e:Event) {
				if(date.after(e.getDateEnd())) {
					System.out.println("Oui");
					Set<User> Users = e.getUsers();
					for(User u:Users) {
						u.setPoints(u.getPoints()+e.getEventpoints());
						if(e.isTrouphy()) {
							u.setTrouphies(u.getTrouphies()+1);	
						}			
						UserRepository.save(u);
						//Kick User when event ends
						RemoveUserFromEvent(e.getId(),u.getIdUser());
						
					}
				}
			}
		}
	//Remove User From Event
		public String RemoveUserFromEvent (int idEvent, Long userid) {
			//l’affecter au centre commercial crée dans la question
			
			Event Event=EventRepository.findById(idEvent).orElse(null);
			User User=UserRepository.findById(userid).orElse(null);
			if(!Event.getUsers().contains(User)) {
				System.out.println("User Already Not Part Of This Event");
				return "User Already Not Part Of This Event";
			}else {
				Event.setNpDisponible(Event.getNpDisponible()-1);
				Event.getUsers().remove(User);
				UserRepository.save(User);
				return "Removing User..";
						
			}
		}
		//Like Event
		public String LikeEvent (int idEvent, Long userid) {
			Event Event=EventRepository.findById(idEvent).orElse(null);
			User User=UserRepository.findById(userid).orElse(null);
				 
			if(!Event.getUsersLiked().contains(User)) {
				//Add to Liked List 
				Event.getUsersLiked().add(User);
				User.getLikedEvent().add(Event);
				//Increase +1
				Event.setNbrlikes(Event.getNbrlikes()+1);
				UserRepository.save(User);
				return "You Like This Event";	
			}else {
				return "You Already Liked This Event";
				}
		}
		//DisLike Event
		public String DisLikeEvent (int idEvent, Long userid) {
			Event Event=EventRepository.findById(idEvent).orElse(null);
			User User=UserRepository.findById(userid).orElse(null);
				 
			if(Event.getUsersLiked().contains(User) && User.getLikedEvent().contains(Event)) {
				//Add to Liked List 
				Event.getUsersLiked().remove(User);
				User.getLikedEvent().remove(Event);
				//Increase +1
				Event.setNbrlikes(Event.getNbrlikes()-1);
				UserRepository.save(User);
				return "You DisLike This Event";	
			}else {
				return "You Did Not Like This Event To Dislike";
				}
		}
	//List Liked Events By User id
		public Set<Event> LikedEventById (Long userid) {
			User User=UserRepository.findById(userid).orElse(null);
			return User.getLikedEvent();
			
		}
	//LikedUsersByEventId
		public Set<User> LikedUsersByEventId(int eventid) {
			Event Event=EventRepository.findById(eventid).orElse(null);
			return Event.getUsersLiked();
			
		}
	//Reccomend Events To User
		public List<Event> RecommendedEvents(EventTags Tags){
			List<Event> RecomendedList = EventRepository.findAllByEventTags(Tags);
			int size=3;
			if(RecomendedList.size()<3) {
				size=RecomendedList.size();
			}
			try {
				//Randomize
				List<Event> RandomList = getRandomElement(RecomendedList,size);
				//Return
				RecomendedList=RandomList;
			}catch(Exception e) {
				System.out.println("Error RecommendedEvents : "+e);
			}
			return RecomendedList;
		}
	//Random Fonction 
		public List<Event> getRandomElement(List<Event> list, int totalItems)
	    {
	        Random rand = new Random();
	 
	        // create a temporary list for storing
	        // selected element
	        List<Event> newList = new ArrayList<>();
	        for (int i = 0; i < totalItems; i++) {
	 
	            // take a random index between 0 to size
	            // of given List
	            int randomIndex = rand.nextInt(list.size());
	 
	            // add element in temporary list
	            newList.add(list.get(randomIndex));
	 
	            // Remove selected element from original list
	            list.remove(randomIndex);
	        }
	        return newList;
	    }
		//Find User Joined Events
		public Set<Event> UserJoinedEvents (Long userid) {
			//l’affecter au centre commercial crée dans la question
			User User=UserRepository.findById(userid).orElse(null);
			return User.getEvents();
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
			return EventRepository.findAllByOrderByNpDisponibleAsc();
		}
		//SortEventBy Nbrplace Desc
		public List<Event> SortEventsByNbrplaceDesc(){
			return EventRepository.findAllByOrderByNpDisponibleDesc();
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
//Multiple Critére Search 
		//find DateStart + DateEnd
		public List<Event> findByDateStartAndDateEnd(Date StartDate,Date DateEnd){
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findAllByDateStartAndDateEnd(StartDate,DateEnd);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Starting Date or Ending Date ");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findByDateStartAndDateEnd");
			}
			return E;
		}
		//findBy DateStart + Trouphy
		public List<Event> findByDateStartAndTrouphy(Date StartDate,boolean trouphy){
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findByDateStartAndTrouphy(StartDate,trouphy);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Starting Date or Trouphy");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findByDateStartAndTrouphy");
			}
			return E;
		}
		//findBy DateEnd + Trouphy
				public List<Event> findByDateEndAndTrouphy(Date StartEnd,boolean trouphy){
					List<Event> E = new ArrayList<Event>();
					try {
						List<Event> TryE = new ArrayList<Event>();
						TryE=EventRepository.findByDateEndAndTrouphy(StartEnd,trouphy);
						if(TryE.size()==0) {
							System.out.println("There Are No Events In The DataBase With The Provided Ending Date or Trouphy");
						}else {
							System.out.println("Events Avariable : ");
							System.out.println(TryE);
							E=TryE;
						}
					}catch(Exception e ) {
						System.out.println("Error Could Not Retrive findByDateEndAndTrouphy");
					}
					return E;
				}
		//findBy DateStart + DateEnd + Trouphy 
		public List<Event> findByDateStartAndDateEndAndTrouphy(Date StartDate,Date DateEnd,boolean trouphy){
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findByDateStartAndDateEndAndTrouphy(StartDate,DateEnd,trouphy);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Starting Date or Ending Date Or Trouphy.");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findByDateStartAndDateEndAndTrouphy");
			}
			return E;
		}
		//findBy DateStart + DateEnd + Trouphy + Type
		public List<Event> findByDateStartAndDateEndAndTrouphyAndType(Date StartDate,Date DateEnd,boolean trouphy,EventType Type){
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findByDateStartAndDateEndAndTrouphyAndType(StartDate,DateEnd,trouphy,Type);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Starting Date , Ending Date , Trouphy Or Type.");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findByDateStartAndDateEndAndTrouphyAndType");
			}
			return E;
		}
		//findBy Type + Trouphy 
		public List<Event> findByTypeAndTrouphy(EventType type, boolean trouphy){
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findByTypeAndTrouphy(type,trouphy);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Type Or Trouphy");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findByTypeAndTrouphy");
			}
			return E;
		}
		
		public List<Event> findByDateStartAndType(Date startDate, EventType type) {
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findByDateStartAndType(startDate,type);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Type Or StartDate");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findByDateStartAndType");
			}
			return E;
		}
		public List<Event> FindByDateEndAndType(Date dateEnd, EventType type) {
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findByDateEndAndType(dateEnd,type);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase With The Provided Type Or Ending Date");
				}else {
					System.out.println("Events Avariable : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive FindByDateEndAndType");
			}
			return E;
		}
		public List<Event> findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual(Date startDate, Date endDate) {
			List<Event> E = new ArrayList<Event>();
			try {
				List<Event> TryE = new ArrayList<Event>();
				TryE=EventRepository.findAllByDateStartGreaterThanEqualAndDateEndLessThanEqual(startDate,endDate);
				if(TryE.size()==0) {
					System.out.println("There Are No Events In The DataBase Between The Two  Provided Dates ");
				}else {
					System.out.println("Events Avariable Between "+startDate+"And "+endDate+" : ");
					System.out.println(TryE);
					E=TryE;
				}
			}catch(Exception e ) {
				System.out.println("Error Could Not Retrive findAllByStartDateLessThanEqualAndDateEndGreaterThanEqual");
			}
			return E;
		}
		/////
		//Nombre Total Events
		public int TotalNumberEvents() {
			int nbr = 0;
			try {
				int trynbr;
				trynbr=EventRepository.findAll().size();
				if(trynbr==0) {
					System.out.println("There Are No Events In The DataBase, please Consider Adding Somme Of Them To Start Counting.");
				}else {
					System.out.println("Total Number Of Events is : "+trynbr);
					nbr=trynbr;
				}
			}catch(Exception e){
				System.out.println("Error Could Not Retrive TotalNumberEvents");
			}
			return nbr;
		}
		//Nombre CHALLENGRE
		public int TotalNumberEventsChallenge() {
			int nbr = 0;
			try {
				int trynbr;
				trynbr=EventRepository.findByType(EventType.CHALLENGE).size();
				if(trynbr==0) {
					System.out.println("There Are No Events With The Type CHALLENGE In The DataBase, please Consider Adding Somme Of Them To Start Counting.");
				}else {
					System.out.println("Total Number Of Events Where The Type is CHALLENGE : "+trynbr);
					nbr=trynbr;
				}
			}catch(Exception e){
				System.out.println("Error Could Not Retrive TotalNumberEventsCHALLENGE");
			}
			return nbr;
		}
		//Nombre FORMATION
		public int TotalNumberEventsFormation() {
			int nbr = 0;
			try {
				int trynbr;
				trynbr=EventRepository.findByType(EventType.FORMATION).size();
				if(trynbr==0) {
					System.out.println("There Are No Events With The Type FORMATION In The DataBase, please Consider Adding Somme Of Them To Start Counting.");
				}else {
					System.out.println("Total Number Of Events Where The Type is FORMATION : "+trynbr);
					nbr=trynbr;
				}
			}catch(Exception e){
				System.out.println("Error Could Not Retrive TotalNumberEventsFORMATION");
			}
			return nbr;
		}
		//Number of Events With Trouphies=true
		public int TotalNumberEventsTrouphyTrue() {
			int nbr = 0;
			try {
				int trynbr;
				trynbr=EventRepository.findByTrouphy(true).size();
				if(trynbr==0) {
					System.out.println("There Are No Events With Trouphies In The DataBase, please Consider Adding Somme Of Them To Start Counting.");
				}else {
					System.out.println("Total Number Of Events With Trouphies : "+trynbr);
					nbr=trynbr;
				}
			}catch(Exception e){
				System.out.println("Error Could Not Retrive TotalNumberEventsTrouphyTrue");
			}
			return nbr;
		}
		//Number of Events With Trouphies=true
		public int TotalNumberEventsTrouphyFalse() {
			int nbr = 0;
			try {
				int trynbr;
				trynbr=EventRepository.findByTrouphy(false).size();
				if(trynbr==0) {
					System.out.println("There Are No Events With No Trouphies In The DataBase, please Consider Adding Somme Of Them To Start Counting.");
				}else {
					System.out.println("Total Number Of Events With No Trouphies : "+trynbr);
					nbr=trynbr;
				}
			}catch(Exception e){
				System.out.println("Error Could Not Retrive TotalNumberEventsTrouphyFalse");
			}
			return nbr;
		}
		
		

		}

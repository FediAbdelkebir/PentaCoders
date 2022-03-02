package pidev.spring.repositories;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Event;
import pidev.spring.entities.EventType;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>  {

	List<Event> findAllByOrderByIdAsc();

	List<Event> findAllByOrderByIdDesc();

	List<Event> findAllByOrderByTitleAsc();

	List<Event> findAllByOrderByTitleDesc();

	List<Event> findAllByOrderByDescriptionAsc();

	List<Event> findTop10ByOrderByTitleAsc();

	List<Event> findAllByOrderByDescriptionDesc();

	List<Event> findTop10ByOrderByTitleDesc();

	List<Event> findAllByOrderByDateStartDesc();

	List<Event> findAllByOrderByDateStartAsc();

	List<Event> findAllByOrderByDateEndAsc();

	List<Event> findAllByOrderByDateEndDesc();

	List<Event> findAllByOrderByNbrplaceAsc();

	List<Event> findAllByOrderByNbrplaceDesc();

	List<Event> findAllByOrderByTypeAsc();

	List<Event> findAllByOrderByTypeDesc();

	List<Event> findAllByOrderByTrouphyAsc();

	List<Event> findAllByOrderByTrouphyDesc();
	
	Event findByTitle(String Title);
	
	List<Event> findByDateStart(Date StartDate);
	
	List<Event> findByDateEnd(Date DateEnd);
	
	List<Event> findByType(EventType EventType);
	
	
}

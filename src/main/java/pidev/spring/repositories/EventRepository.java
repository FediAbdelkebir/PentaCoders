package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Event;

@Repository
public interface EventRepository extends JpaRepository<Event, Integer>  {

}

package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;

@Repository
public interface ReclamationRepo extends JpaRepository<Reclamation, Integer>{
	
	List<Reclamation> findAllByStatus(StatusReclamation status);
	List<Reclamation> findByOrderByCreationDateAsc();
	List<Reclamation> findByOrderByCreationDateDesc();
	//List<Reclamation> findByOrderByProcessingDateAsc();
	//List<Reclamation> findByOrderByProcessingDateDesc();
	
}

package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.StatusReclamation;

@Repository
public interface ReclamationRepo extends CrudRepository<Reclamation, Integer>{
	
	List<Reclamation> findAllByStatus(StatusReclamation status);
	List<Reclamation> findByOrderByCreationDateAsc();
	List<Reclamation> findByOrderByCreationDateDesc();
	//List<Reclamation> findByOrderByProcessingDateAsc();
	//List<Reclamation> findByOrderByProcessingDateDesc();
	
	
	/*@Query(value="SELECT * FROM Reclamation r WHERE r.objet LIKE %?1% OR r.message LIKE %?1% OR r.response LIKE %?1%"
			, nativeQuery=true)
	List<Reclamation> findAll(@Param("keyword") String keyword);*/
	
	
}

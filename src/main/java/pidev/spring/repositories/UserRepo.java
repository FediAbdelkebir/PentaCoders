package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Reclamation;
import pidev.spring.entities.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long>{

}

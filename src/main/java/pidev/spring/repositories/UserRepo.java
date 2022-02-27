package pidev.spring.repositories;

import org.springframework.data.repository.CrudRepository;

import pidev.spring.entities.User;

public interface UserRepo extends CrudRepository<User, Long>{

}

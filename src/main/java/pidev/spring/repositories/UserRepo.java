package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import pidev.spring.entities.User;

public interface UserRepo extends JpaRepository<User, Long>{

}

package pidev.spring.repositories;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.User;


@Repository 
public interface UserRepo extends JpaRepository<User, Long>{

}

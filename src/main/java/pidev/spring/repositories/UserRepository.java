package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pidev.spring.entities.Review;
import pidev.spring.entities.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}

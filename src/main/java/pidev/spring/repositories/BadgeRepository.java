package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Badge;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer>  {

}

package tn.esprit.workmood.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tn.esprit.workmood.entities.Name;
import tn.esprit.workmood.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	
	

}

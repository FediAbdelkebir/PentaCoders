package tn.esprit.workmood.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import tn.esprit.workmood.entities.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {

}

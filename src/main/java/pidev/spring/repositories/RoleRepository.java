package pidev.spring.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import  pidev.spring.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
	//@Query("select * from role where name=:name")
	Role getRoleByName(@Param("name")String name);

}

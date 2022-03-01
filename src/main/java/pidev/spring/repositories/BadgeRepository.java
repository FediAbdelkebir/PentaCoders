package pidev.spring.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pidev.spring.entities.Badge;

@Repository
public interface BadgeRepository extends JpaRepository<Badge, Integer>  {
	public List<Badge> findAllByOrderByIdAsc();
	public List<Badge> findAllByOrderByIdDesc();
	public List<Badge> findTop10ByOrderByTitleDesc();
	public List<Badge> findTop10ByOrderByTitleAsc();
	public List<Badge> findTop10ByOrderByDescriptionDesc();
	public List<Badge> findTop10ByOrderByDescriptionAsc();
	public List<Badge> findAllByOrderByTitleAsc();
	public List<Badge> findAllByOrderByTitleDesc();
	public List<Badge> findAllByOrderByDescriptionAsc();
	public List<Badge> findAllByOrderByDescriptionDesc();
}

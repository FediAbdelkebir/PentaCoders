package pidev.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import pidev.spring.entities.Badge;
import pidev.spring.entities.User;
import pidev.spring.repositories.BadgeRepository;

@Service
public class BadgeServices {
	@Autowired
	BadgeRepository BadgeRepository;
	@Autowired
	UserRepository UserRepository;
	public Badge addBadge(Badge c) {
		return BadgeRepository.save(c);
	}
	//Delete
	public void deleteBadge(int id) {
		BadgeRepository.deleteById(id);
	}
	//FindById
	public Badge retrieveBadge(int id) {
		return BadgeRepository.findById(id).orElse(null);
	}
	//Update
	public Badge updateBadge(Badge c) {
		Badge badge = BadgeRepository.findById((int) c.getId()).orElse(null);
		badge.setTitle(c.getTitle());
		badge.setDescription(c.getDescription());
		return BadgeRepository.save(badge);
	}
	//FindAll
	public List<Badge> listedesBadges() {
		return BadgeRepository.findAll();
	}
	//Affecter Badge To User
	public User AffecterBadgeToUser (int badge, int userid) {
		//l’affecter au centre commercial crée dans la question
		Badge Badge=BadgeRepository.findById(badge).orElse(null);
		User User=UserRepository.findById(userid).orElse(null);
		User.setBadge(Badge);
		return UserRepository.save(User);
		
	}
	//SortBadgeBy Id Asc
	public List<Badge> SortBadgesByIdAsc(){
		return BadgeRepository.findAllByOrderByIdAsc();
	}
	//SortBadgeBy Id Desc
	public List<Badge> SortBadgesByIdDesc(){
		return BadgeRepository.findAllByOrderByIdDesc();
	}
	//SortBadgeBy Title Asc
	public List<Badge> SortBadgesByTitleAsc(){
		return BadgeRepository.findAllByOrderByTitleAsc();
	}
	//SortBadgeBy Title Desc
	public List<Badge> SortBadgesByTitleDesc(){
		return BadgeRepository.findAllByOrderByTitleDesc();
	}
	//SortBadgeBy Description Asc
	public List<Badge> SortBadgesByDescriptionAsc(){
		return BadgeRepository.findAllByOrderByDescriptionAsc();
	}
	//SortBadgeBy Title Desc
	public List<Badge> SortBadgesByDescriptionDesc(){
		return BadgeRepository.findAllByOrderByDescriptionDesc();
	}
	//SortBadgeBy Top 10 Title Asc
	public List<Badge> SortBadgesTop10ByOrderByTitleAsc(){
		return BadgeRepository.findTop10ByOrderByTitleAsc();
	}
	//SortBadgeBy Top 10 Title Desc
	public List<Badge> SortBadgesTop10ByOrderByTitleDesc(){
			return BadgeRepository.findTop10ByOrderByTitleDesc();
	}
}

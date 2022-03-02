package pidev.spring.webcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import pidev.spring.entities.Badge;
import pidev.spring.entities.User;
import pidev.spring.services.BadgeServices;

@RestController
@RequestMapping("/Badges")
public class BadgeController {
	@Autowired
	BadgeServices BS;
	//Add
		@PostMapping("/addBadge")
		@ResponseBody //trajaa retour
	void AddBadge(@RequestBody Badge badge) {
			try {
				BS.addBadge(badge);
				
			}catch(Exception e){
				System.out.println("An Error Occured While Adding an Badge ");
			}
			
		}
		
		//Update
		@PostMapping("/UpdateBadge")
		@ResponseBody //trajaa retour
	void UpdateBadge(@RequestBody Badge badge) {
			try {
				BS.updateBadge(badge);
			}catch(Exception e){
				System.out.println("An Error Occured While Updating an Badge ");
			}
			
		}
		//Delete
			@PostMapping("/DeleteBadge/{idBadge}")
			@ResponseBody
	void DeleteBadge(@PathVariable("idBadge") int idBadge){
				try{
					BS.deleteBadge(idBadge);
					System.out.println("Badge Deleted");
					}
				catch(Exception e) {
					System.out.println("An Error Occured While Deleting an Badge ");
				}
				}
		//FindAll
		@GetMapping("/Badges")
		@ResponseBody
	List<Badge> Badges(){
			System.out.println(BS.listedesBadges());
			return BS.listedesBadges();
			}
		
		//FindById
		@GetMapping("/FindBadge/{idBadge}")
		@ResponseBody
		Badge FindBadgeById(@PathVariable("idBadge") int idBadge){
			System.out.println(BS.retrieveBadge(idBadge));
				return BS.retrieveBadge(idBadge);
		}
//AffecterBadgeToUser
		@PostMapping("/AffecterBadgeToUser/{badge}/{userid}")
		@ResponseBody
		User FindBadgeById(@PathVariable("badge") int badge,@PathVariable("userid") int userid){
			return BS.AffecterBadgeToUser(badge, userid);
		}
//SortBadgesByIdDesc
		@GetMapping("/SortBadgesByIdDesc")
		@ResponseBody
		List<Badge> SortBadgesByIdDesc(){
			return BS.SortBadgesByIdDesc();
		}
//SortBadgesByIdAsc
		@GetMapping("/SortBadgesByIdAsc")
		@ResponseBody
		List<Badge> SortBadgesByIdAsc(){
			return BS.SortBadgesByIdAsc();
		}
//SortBadgesByTitleAsc
		@GetMapping("/SortBadgesByTitleAsc")
		@ResponseBody
		List<Badge> SortBadgesByTitleAsc(){
			return BS.SortBadgesByTitleAsc();
		}
//SortBadgesByTitleDesc
		@GetMapping("/SortBadgesByTitleDesc")
		@ResponseBody
		List<Badge> SortBadgesByTitleDesc(){
			return BS.SortBadgesByTitleDesc();
		}
//SortBadgesByDescriptionAsc
		@GetMapping("/SortBadgesByDescriptionAsc")
		@ResponseBody
		List<Badge> SortBadgesByDescriptionAsc(){
			return BS.SortBadgesByDescriptionAsc();
		}
//SortBadgesByDescriptionDesc
		@GetMapping("/SortBadgesByDescriptionDesc")
		@ResponseBody
		List<Badge> SortBadgesByDescriptionDesc(){
			return BS.SortBadgesByDescriptionDesc();
		}
//SortBadgesTop10ByOrderByTitleAsc
		@GetMapping("/SortBadgesTop10ByOrderByTitleAsc")
		@ResponseBody
		List<Badge> SortBadgesTop10ByOrderByTitleAsc(){
			return BS.SortBadgesTop10ByOrderByTitleAsc();
		}
//SortBadgesTop10ByOrderByTitleDesc
		@GetMapping("SortBadgesTop10ByOrderByTitleDesc")
		@ResponseBody
		List<Badge> SortBadgesTop10ByOrderByTitleDesc(){
			return BS.SortBadgesTop10ByOrderByTitleDesc();
		}
}

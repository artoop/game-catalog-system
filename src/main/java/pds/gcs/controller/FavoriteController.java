package pds.gcs.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import pds.gcs.authentication.CustomUserDetails;
import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;
import pds.gcs.entity.User;
import pds.gcs.service.GameService;
import pds.gcs.service.UserService;

@Controller
public class FavoriteController {
	
	private UserService userService;
	private GameService gameService;
	
	public FavoriteController(GameService gameService, UserService userService) {
		super();
		this.gameService = gameService;
		this.userService = userService;
	}
	
	//show user favorites list
	 @GetMapping(value = "/favorites")
	 public String showFavorites(@AuthenticationPrincipal CustomUserDetails userDetails, 
			 Model model) {
	     Long id = userDetails.getUserId();
		 model.addAttribute("favorites", gameService.findFavoritesByUserId(id));
		 	 
		 return "favorites";
	  }
	
	 
	 //like game handler
	 @GetMapping(value = "/favorites/like/{id}")
	 public String addFavorite(@AuthenticationPrincipal CustomUserDetails userDetails, 
			 Model model, @PathVariable Long id) {
		 
		 Long userId = userDetails.getUserId();		 
		 User user = userService.findById(userId);
		 List<Resource> userFavorites = gameService.findFavoritesByUserId(userId);
		 
		 if(userFavorites == null) {
			 userFavorites = new ArrayList<Resource>();
		 }
		 
		 boolean alreadyLiked = false;
		 
		 for(int i=0; i<userFavorites.size(); i++) {
			 if(id == userFavorites.get(i).getId()) {
				 alreadyLiked = true;
			 }
		 }
		 
		 if(!alreadyLiked) {
			 userFavorites.add(gameService.getGameById(id));
			 user.setFavorites(userFavorites);
			 userService.saveUser(user);
		 } 
		 
		 return "redirect:/favorites"; 
	 }
	 
	 //dislike game handler
	 @GetMapping(value = "/favorites/dislike/{id}")
	 public String removeFavorite(@AuthenticationPrincipal CustomUserDetails userDetails, 
			 Model model, @PathVariable Long id) {
		 
		 Long userId = userDetails.getUserId();		 
		 User user = userService.findById(userId);
		 List<Resource> userFavorites = gameService.findFavoritesByUserId(userId);
		 
		 if(userFavorites == null) {
			 userFavorites = new ArrayList<Resource>();
		 }

		 int deletedIndex = -1;
		 
		 for(int i=0; i<userFavorites.size(); i++) {
			 if(id == userFavorites.get(i).getId()) {
				 deletedIndex = i;
			 }
		 }
		 
		 if(deletedIndex != -1) {
			 userFavorites.remove(deletedIndex);
			 user.setFavorites(userFavorites);
			 userService.saveUser(user);
		 }
		 
		 return "redirect:/favorites"; 
	 }
	 
	 
}

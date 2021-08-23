package pds.gcs.controller;

import java.util.List;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pds.gcs.authentication.CustomUserDetails;
import pds.gcs.entity.Comment;
import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;
import pds.gcs.service.CommentService;
import pds.gcs.service.GameService;

@Controller
public class GameController {
	
	private GameService gameService;
	private CommentService commentService;
	
	public GameController(GameService gameService, CommentService commentService) {
		super();
		this.gameService = gameService;
		this.commentService = commentService;
	}
	
	//handler method for the games
	@GetMapping("/games")
	public String listGames(Model model) {
		model.addAttribute("games", gameService.getAllGames());
		return "games";
	}	
	
	/*-------------
	 * EDIT AND ADD
	 * ------------
	 */	
	
	//new game handler
	@GetMapping("/games/new")
	public String createGameForm(Model model) {
		Game game = new Game();
		model.addAttribute("game", game);
		return "edit_game";
	}
	
	//update game handler
	@GetMapping("/games/edit/{id}")
	public String editGameForm(@PathVariable Long id, Model model) {
		model.addAttribute("game", gameService.getGameById(id));
		return "edit_game";
	}
	
	@PostMapping("/games")
	public String updateGame(@ModelAttribute("game") Game game) {
		if (game.getId() == null)
			gameService.saveGame(game);
		else {
			Game existingGame = gameService.getGameById(game.getId());
			existingGame.setTitle(game.getTitle());
			existingGame.setPublisher(game.getPublisher());
			existingGame.setImage(game.getImage());
			existingGame.setLaunch(game.getLaunch());
			//save updated game object
			gameService.updateGame(existingGame);
		}
		return "redirect:/games";		
	}
	
	
	//comment posting handler
	@PostMapping("/games/{id}")
	public String postComment(@PathVariable Long id, @ModelAttribute("comment") Comment comment) {
		Game game = gameService.getGameById(id);
		comment.setResource(game);
		
		commentService.postComment(comment);
		return "redirect:/games/"+id;	
	}
	
		
	//show game page handler
	@GetMapping("/games/{id}")
	public String showGameInfo(@AuthenticationPrincipal CustomUserDetails userDetails, 
			@PathVariable Long id, Model model) {
		
		Long userId = userDetails.getUserId();
		List<Resource> favorites = gameService.findFavoritesByUserId(userId);
		boolean liked = false;
		
		for(int i=0; i<favorites.size(); i++) {
			if(id == favorites.get(i).getId())
				liked = true;
		}
		
		model.addAttribute("liked", liked);
		model.addAttribute("game", gameService.getGameById(id));
		model.addAttribute("comments", commentService.findByResourceId(id));		
		model.addAttribute("new_comment", new Comment());
		return "view_game";
	}
	
	
	
	//delete game handler
	@GetMapping("/games/delete/{id}")
	public String deleteGame(@PathVariable Long id) {
		gameService.deleteGameById(id);
		return "redirect:/games";
	}
	
}

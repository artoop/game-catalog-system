package pds.gcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import pds.gcs.entity.Game;
import pds.gcs.service.GameService;

@Controller
public class GameController {
	
	private GameService gameService;

	public GameController(GameService gameService) {
		super();
		this.gameService = gameService;
	}
	
	//handler method for the games list and return mode and view
	@GetMapping("/games")
	public String listGames(Model model) {
		model.addAttribute("games", gameService.getAllGames());
		return "games";
	}
	
	//new game handler
	@GetMapping("/games/new")
	public String createGameForm(Model model) {
		Game game = new Game();
		model.addAttribute("game", game);
		return "add_game";
	}
	
	//submit new game handler
	@PostMapping("/games")
	public String saveGame(@ModelAttribute("game") Game game) {
			gameService.saveGame(game);
			return "redirect:/games";
	}
	
	//update game handler
	@GetMapping("/games/edit/{id}")
	public String editGameForm(@PathVariable Long id, Model model) {
		model.addAttribute("game", gameService.getGameById(id));
		return "edit_game";
	}
	
	@PostMapping("/games/{id}")
	public String updateGame(@PathVariable Long id,
			@ModelAttribute("game") Game game, 
			Model model) {
		
		//get game from db by id
		Game existingGame = gameService.getGameById(id);
		existingGame.setId(game.getId());
		existingGame.setTitle(game.getTitle());
		existingGame.setPublisher(game.getPublisher());
		existingGame.setLaunchDate(game.getLaunchDate());
		
		//save updated game object
		gameService.updateGame(existingGame);
		return "redirect:/games";
		
	}
	
}

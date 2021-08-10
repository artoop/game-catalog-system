package pds.gcs.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
	
}

package pds.gcs.service;

import java.util.List;

import pds.gcs.entity.Game;

public interface GameService {
	List<Game> getAllGames();
	
	Game saveGame(Game game);
	
	Game getGameById(Long id);
	
	Game updateGame(Game game);
}

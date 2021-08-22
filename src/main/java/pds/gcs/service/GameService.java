package pds.gcs.service;

import java.util.List;

import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;

public interface GameService {
	List<Game> getAllGames();
	
	List<Resource> findFavoritesByUserId(Long id);
	
	Game saveGame(Game game);
	
	Game getGameById(Long id);
	
	Game updateGame(Game game);
	
	void deleteGameById(Long id);
}

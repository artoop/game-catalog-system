package pds.gcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;
import pds.gcs.repository.GameRepository;
import pds.gcs.service.GameService;

@Service
public class GameServiceImpl implements GameService {
	
	private GameRepository gameRepository;
	
	
	
	public GameServiceImpl(GameRepository gameRepository) {
		super();
		this.gameRepository = gameRepository;
	}

	@Override
	public List<Game> getAllGames() {
		return gameRepository.findAll();
	}
	
	@Override
	public List<Resource> findFavoritesByUserId(Long id) {
		return gameRepository.findByUsers_Id(id);
	}
	
	@Override
	public Game saveGame(Game game) {
		game.defineNotificationDate();
		return gameRepository.save(game);
	}
	
	@Override
	public Game getGameById(Long id) {
		return (Game)gameRepository.findById(id).get();
	}
	
	@Override
	public Game updateGame(Game game) {
		game.defineNotificationDate();
		return gameRepository.save(game);
	}
	
	@Override
	public void deleteGameById(Long id) {
		gameRepository.deleteById(id);
	}
}

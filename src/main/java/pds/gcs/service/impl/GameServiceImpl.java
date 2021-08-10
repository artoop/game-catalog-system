package pds.gcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pds.gcs.entity.Game;
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
	public Game saveGame(Game game) {
		return gameRepository.save(game);
	}
	
	@Override
	public Game getGameById(Long id) {
		return gameRepository.findById(id).get();
	}
	
	@Override
	public Game updateGame(Game game) {
		return gameRepository.save(game);
	}
}

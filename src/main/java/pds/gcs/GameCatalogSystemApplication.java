package pds.gcs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import pds.gcs.entity.Game;
import pds.gcs.repository.GameRepository;

@SpringBootApplication
public class GameCatalogSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GameCatalogSystemApplication.class, args);
	}
	
	@Autowired
	private GameRepository gameRepository;
	
	@Override
	public void run(String... args) throws Exception {
		
		Game game1 = new Game("Control", "Remedy", "31/07/2019");
		gameRepository.save(game1);
		
		Game game2 = new Game("Max Payne 2", "Remedy", "31/07/2003");
		gameRepository.save(game2);
		
		Game game3 = new Game("Final Fantasy X", "Square", "31/07/2001");
		gameRepository.save(game3);
		
		
	}

}

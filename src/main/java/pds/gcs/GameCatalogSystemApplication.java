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
		
		
	}

}

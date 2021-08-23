package pds.gcs;

import java.util.Calendar;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import pds.gcs.service.NotificationService;


@SpringBootApplication
@EnableScheduling
public class GameCatalogSystemApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(GameCatalogSystemApplication.class, args);
	}
	
	private static Logger logger = LoggerFactory.getLogger(GameCatalogSystemApplication.class);
	@Autowired NotificationService notificationService;
	
	@Scheduled(initialDelay = 1000, fixedRate = 10000)
	public void executeDailyNotifications() {
		notificationService.fetchDailyNotifications();
	}
	
	@Override
	public void run(String... args) throws Exception {		
	}
}

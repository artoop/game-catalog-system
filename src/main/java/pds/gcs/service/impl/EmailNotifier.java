package pds.gcs.service.impl;

import java.util.List;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.stereotype.Service;

import pds.gcs.entity.Game;
import pds.gcs.entity.User;
import pds.gcs.service.EmailService;
import pds.gcs.service.Notifier;

@Service
public class EmailNotifier implements Notifier{
	public EmailNotifier(EmailService emailService) {
		super();
		this.emailService = emailService;
	}

	EmailService emailService;
	
	@Override
	public void notify(User user, List<Game> resources) {
		String email = user.getEmail();
		
		SimpleMailMessage notificationEmail = new SimpleMailMessage();
		notificationEmail.setTo(email);
		notificationEmail.setSubject("New Game Launch!");
		notificationEmail.setText("A new game has launched today!");
		notificationEmail.setFrom("noreply@domain.com");
		
		emailService.sendEmail(notificationEmail);
		
	}
}

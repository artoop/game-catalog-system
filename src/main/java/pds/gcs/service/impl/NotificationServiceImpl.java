package pds.gcs.service.impl;

import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;
import pds.gcs.entity.User;
import pds.gcs.repository.ResourceRepository;
import pds.gcs.repository.UserRepository;
import pds.gcs.service.EmailService;
import pds.gcs.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	ResourceRepository resourceRepository;
	UserRepository userRepository;
	EmailNotifier emailNotifier;
	
	
	private static Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
	
	public NotificationServiceImpl (ResourceRepository resourceRepository, UserRepository userRepository, EmailNotifier emailNotifier) {
		super();
		this.resourceRepository = resourceRepository;
		this.userRepository = userRepository;
		this.emailNotifier = emailNotifier;
	}

	@Transactional
	public void fetchDailyNotifications() {
		//clear previous day notifications
		userRepository.clearNotifications();
		
		//update notifications table (user_id and resource_id)
		userRepository.updateNotifications(LocalDate.now());
		
		//get list of users to be notified
		List<User> users = userRepository.getUsersToNotify();
		
		List<Game> resources;
		
		
		//get games to be notified about
		for(int i=0; i<users.size(); i++) {
			Long id = users.get(i).getId();
			resources = resourceRepository.getResourcesToNotifyAbout(id);
			
			User user = users.get(i);
			
			emailNotifier.notify(user, resources);
			
			
		}
		
	}
	

	
	public void notify (User user, Resource resource) {
		//mandar email pro 
	}
	
	
}

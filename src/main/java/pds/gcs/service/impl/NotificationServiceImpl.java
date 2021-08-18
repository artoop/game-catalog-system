package pds.gcs.service.impl;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import pds.gcs.entity.Resource;
import pds.gcs.entity.User;
import pds.gcs.repository.ResourceRepository;
import pds.gcs.repository.UserRepository;
import pds.gcs.service.NotificationService;

@Service
public class NotificationServiceImpl implements NotificationService {
	
	ResourceRepository resourceRepository;
	UserRepository userRepository;
	
	
	private static Logger logger = LoggerFactory.getLogger(NotificationServiceImpl.class);
	
	public NotificationServiceImpl (ResourceRepository resourceRepository) {
		super();
		this.resourceRepository = resourceRepository;
	}
	public void fetchDailyNotifications() {
		List<Resource> resources = resourceRepository.findByNotificationDate(new Date());
		Resource r;
		List<User> users;
		/*for (int i=0; i<resources.size(); i++) {
			r = resources.get(i);
			//ACHA USUARIOS QUE TEM ESSE RECURSO (jOGO) r NA LISTA DE FAVORITOS
			
			for (int j=0; j<users.size(); j++) {
				notify(users.get(j), r);
			}
			
			
			
			//List<Resource> r = resourceRepository.findByTitle("Rayman");
		}
		if (resources.size() == 0)
			logger.info("Lista vazia");
		else
			logger.info("Tem coisaa");*/
	}
	
	public void notify (User user, Resource resource) {
		//mandar email pro 
	}
	
	
}

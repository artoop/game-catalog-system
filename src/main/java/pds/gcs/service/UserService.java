package pds.gcs.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pds.gcs.entity.User;
import pds.gcs.repository.UserRepository;

@Service("userService")
public class UserService {

	private UserRepository userRepository;
	
    @Autowired
    public UserService(UserRepository userRepository) { 
      this.userRepository = userRepository;
    }
    
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public User findByConfirmationToken(String confirmationToken) {
		return userRepository.findByConfirmationToken(confirmationToken);
	}
	
	public void saveUser(User user) {
		userRepository.save(user);
	}
	
	public User findById(Long id) {
		return userRepository.getById(id);
	}
	
	

}
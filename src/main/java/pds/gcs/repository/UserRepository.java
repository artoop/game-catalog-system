package pds.gcs.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import pds.gcs.entity.User;

@Repository("userRepository")
public interface UserRepository extends CrudRepository<User, Long> {
	User findByEmail(String email);
	User findByConfirmationToken(String confirmationToken);
}

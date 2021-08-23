package pds.gcs.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pds.gcs.entity.User;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<User, Long> {
	User findByEmail(String email);
	User findByConfirmationToken(String confirmationToken);
	
	@Modifying
	@Query(value = "delete from notifications", nativeQuery = true)
	void clearNotifications();
	
	@Modifying
	@Query(value = "insert into notifications "
					+ "select user_liked_resources.user_id, user_liked_resources.resource_id from user "
					+ "right join user_liked_resources "
					+	"on user.id = user_liked_resources.user_id "
					+ "left join games "
					+	"on user_liked_resources.resource_id = games.id "
					+ "where date_format(games.notification_date, '%Y-%m-%d') = :date", nativeQuery = true)
	void updateNotifications(@Param("date") LocalDate date);
	
	@Query(value = "select * from user where user.id "
					+ "in (select notifications.user_id from notifications "
					+ "group by notifications.user_id)", nativeQuery = true)
	public List<User> getUsersToNotify();
	
}

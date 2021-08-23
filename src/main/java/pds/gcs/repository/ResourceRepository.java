package pds.gcs.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{
	
	public List<Resource> findByNotificationDate(Date notificationDate);
	public List<Resource> findByTitle(String title);
	public List<Resource> findByUsers_Id(Long id);
	
	@Query(value = "select games.* from notifications "
					+ "left join games on notifications.resource_id = games.id "
					+ "where notifications.user_id = :id", nativeQuery = true)
	public List<Game> getResourcesToNotifyAbout(@Param("id") Long id);
}

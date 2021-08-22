package pds.gcs.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;

public interface ResourceRepository extends JpaRepository<Resource, Long>{
	
	public List<Resource> findByNotificationDate(Date notificationDate);
	public List<Resource> findByTitle(String title);
	public List<Resource> findByUsers_Id(Long id);
	
}

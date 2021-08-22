package pds.gcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import pds.gcs.entity.Game;
import pds.gcs.entity.Resource;

public interface GameRepository extends JpaRepository<Game, Long> {
	
	public List<Resource> findByUsers_Id(Long id);
	
}

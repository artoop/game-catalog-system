package pds.gcs.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pds.gcs.entity.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}

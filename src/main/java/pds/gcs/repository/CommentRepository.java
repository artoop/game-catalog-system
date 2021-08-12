package pds.gcs.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import pds.gcs.entity.Comment;
import pds.gcs.entity.Resource;

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByResourceId(Long id);
}

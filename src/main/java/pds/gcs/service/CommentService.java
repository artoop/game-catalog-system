package pds.gcs.service;

import java.util.List;

import pds.gcs.entity.Comment;

public interface CommentService {
	
	Comment postComment(Comment comment);
	
	void deleteCommentById(Long id);

	List<Comment> findByResourceId(Long id);

}

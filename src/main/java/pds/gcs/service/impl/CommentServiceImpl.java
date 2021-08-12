package pds.gcs.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import pds.gcs.entity.Comment;
import pds.gcs.entity.Resource;
import pds.gcs.repository.CommentRepository;
import pds.gcs.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
	
	private CommentRepository commentRepository;
		
	public CommentServiceImpl(CommentRepository commentRepository) {
		super();
		this.commentRepository = commentRepository;
	}
	
	@Override
	public List<Comment> findByResourceId(Long id){
		return commentRepository.findByResourceId(id);
	}
	
	@Override
	public Comment postComment(Comment comment) {		
		return commentRepository.save(comment);
	}
	
	@Override
	public void deleteCommentById(Long id) {
		commentRepository.deleteById(id);
	}
	
}

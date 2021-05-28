package be.yorian.budget_backend.service;

import java.util.List;
import java.util.Optional;

import be.yorian.budget_backend.entity.Comment;

public interface CommentService {
	
	public List<Comment> getComments();
	public Optional<Comment> getCommentById(Long comment_id);
	public void saveComment(Comment comment);
	public Comment updateComment(Comment comment);
	public void deleteComment(Long comment_id);
	
}

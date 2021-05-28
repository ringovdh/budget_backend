package be.yorian.budget_backend.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import be.yorian.budget_backend.controller.CommentController;
import be.yorian.budget_backend.entity.Comment;
import be.yorian.budget_backend.service.CommentService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class CommentControllerImpl implements CommentController {

	
    private CommentService commentService;
    
    
    @Autowired
    public CommentControllerImpl(CommentService commentService) {
    	this.commentService = commentService;
    }

    
    @Override
    @GetMapping("/comments")
    public List<Comment> getComments() {
        return commentService.getComments();
    }
    
    @Override
    @GetMapping("/comments/{comment_id}")
    public Optional<Comment> getCommentById(@PathVariable("comment_id") Long comment_id) {
    	return commentService.getCommentById(comment_id);
    }

    @Override
    @PostMapping("/comments")
    public void saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

    @Override
    @PutMapping("/comments")
    public Comment updateComment(@RequestBody Comment comment) {
    	return commentService.updateComment(comment);
    }
    
    @Override
    @DeleteMapping("/comments/{comment_id}")
	public void deleteComment(@PathVariable("comment_id")Long comment_id) {
		commentService.deleteComment(comment_id);	
	}
    
}

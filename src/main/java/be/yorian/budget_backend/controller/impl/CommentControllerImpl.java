package be.yorian.budget_backend.controller.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/comments/get/{comment_id}")
    public Optional<Comment> getCommentById(@PathVariable("comment_id") Long comment_id) {
    	return commentService.getCommentById(comment_id);
    }

    @Override
    @PostMapping("/comments/save")
    public void saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
    }

    @Override
    @PostMapping("/comments/update/{comment_id}")
    public Comment updateComment(@PathVariable("comment_id") Long comment_id, @RequestBody Comment comment) {
    	return commentService.updateComment(comment_id, comment);
    }
    
    @Override
    @DeleteMapping("/comments/delete/{comment_id}")
	public void deleteComment(@PathVariable("comment_id")Long comment_id) {
		commentService.deleteComment(comment_id);	
	}
    
}

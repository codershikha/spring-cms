package in.smartbox.springcms.controller;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.smartbox.springcms.exception.ResourceNotFoundException;
import in.smartbox.springcms.model.Comment;
import in.smartbox.springcms.repository.CommentRepository;
import in.smartbox.springcms.repository.PostRepository;

@RequestMapping("/api/v1")
@RestController
public class CommentController {
	
	
	@Autowired
    CommentRepository commentRepository;
	
	@Autowired
    PostRepository postRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/comments")
	public List<Comment> getAllComments() 
	{
	    return commentRepository.findAll();
    }
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/comments")
	public ResponseEntity<Comment> createPost(@RequestBody Comment comment)
	{
	     commentRepository.save(comment);
	     return null;
	}
	
	@PutMapping("/posts/{postId}/comments/{commentId}")
    public Comment updateComment(@PathVariable (value = "postId") Long postId,
                                 @PathVariable (value = "commentId") Long commentId,
                                 @Valid @RequestBody Comment commentRequest) {
        if(!postRepository.existsById(postId)) {
            throw new ResourceNotFoundException("PostId " + postId + " not found");
        }

        return commentRepository.findById(commentId).map(comment -> {
            comment.setContent(commentRequest.getContent());
            return commentRepository.save(comment);
        }).orElseThrow(() -> new ResourceNotFoundException("CommentId " + commentId + "not found"));
    }
}
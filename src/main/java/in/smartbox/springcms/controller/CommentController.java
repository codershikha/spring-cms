package in.smartbox.springcms.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.smartbox.springcms.model.Comment;
import in.smartbox.springcms.repository.CommentRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

@RequestMapping("/api/v1")
@RestController
public class CommentController {
	
	
	@Autowired
    CommentRepository commentRepository;
	
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
}
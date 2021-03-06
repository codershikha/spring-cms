package in.smartbox.springcms.controller;

import java.util.List;
import java.util.Optional;
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
import in.smartbox.springcms.model.Post;
import in.smartbox.springcms.repository.PostRepository;

@RequestMapping("/api/v1")
@RestController
public class PostController {
	
	@Autowired
    PostRepository postRepository;
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/posts")
	public List<Post> getAllPosts() 
	{
	    return postRepository.findAll();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/posts/{authorId}")
    public Optional<Post> getAllPostsByAuthorId(@PathVariable (value = "authorId") Long authorId) {
		return postRepository.findById(authorId);
    }

	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/posts")
    public ResponseEntity<Post> createPost( @RequestBody Post post) {
         postRepository.save(post);
         return null;
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PutMapping("/posts/{postId}")
    public Post updatePost(@PathVariable Long postId,  @RequestBody Post postRequest) {
        return postRepository.findById(postId).map(post -> {
            post.setTitle(postRequest.getTitle());
           post.setContent(postRequest.getContent());
            return postRepository.save(post);
        }).orElseThrow(() -> new ResourceNotFoundException("PostId " + postId + " not found"));
    }

	
}
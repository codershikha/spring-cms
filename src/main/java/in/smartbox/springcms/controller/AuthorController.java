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
import in.smartbox.springcms.model.Author;
import in.smartbox.springcms.model.Post;
import in.smartbox.springcms.repository.AuthorRepository;
import in.smartbox.springcms.repository.PostRepository;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/v1")
@RestController
public class AuthorController
{
	@Autowired
    AuthorRepository authorRepository;
	
	@Autowired
    PostRepository postRepository;
	
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/authors")
	public List<Author> getAllAuthors() 
	{
	    return authorRepository.findAll();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/authors")
	public ResponseEntity<Author> createPost( @RequestBody Author author)
	{ 
		authorRepository.save(author);
	    return null;
	}
	
}

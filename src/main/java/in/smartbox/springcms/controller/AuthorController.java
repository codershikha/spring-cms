package in.smartbox.springcms.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import in.smartbox.springcms.model.Author;
import in.smartbox.springcms.repository.AuthorRepository;
import org.springframework.web.bind.annotation.CrossOrigin;


@RequestMapping("/api/v1")
@RestController
public class AuthorController
{
	@Autowired
    AuthorRepository authorRepository;
	
	
	@CrossOrigin(origins = "http://localhost:4200")
	@GetMapping("/authors")
	public List<Author> getAllAuthors() 
	{
	    return authorRepository.findAll();
    }
	
	@CrossOrigin(origins = "http://localhost:4200")
	@PostMapping("/authors")
	public ResponseEntity<Author> createPost( @RequestBody Author author)
	{authorRepository.save(author);
	    return null;
	}

}

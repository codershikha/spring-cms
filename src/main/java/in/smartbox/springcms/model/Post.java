package in.smartbox.springcms.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "post")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)

public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "postId", nullable = false, updatable = false)
	private Long id;
	
	//@JsonIgnore
	//@JsonManagedReference
	//@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	private List<Comment> comments;
    
	

	//@JsonManagedReference
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "authorId", nullable = false)
	private Author author;
     
	
	@Size(max = 100)
	@Column(unique = true)
	private String title;
	
	@Column(name = "content", nullable = false, updatable = false)
	private String content;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public List<Comment> getComments() {
		return comments;
	}

	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}

}
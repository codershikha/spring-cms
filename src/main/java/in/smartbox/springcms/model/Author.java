package in.smartbox.springcms.model;


import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
   
    @Entity
    @Table(name="author")
    @JsonTypeInfo(use=JsonTypeInfo.Id.MINIMAL_CLASS, include=JsonTypeInfo.As.PROPERTY)
    @JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
   // @JsonIgnoreProperties("post")
   public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name="authorId", unique=true, nullable=false)
    private Long id;
	
	
	@Column(name="authorName", unique=true, nullable=false)
	private String name;
	
    @Column(name="email", nullable=false)
    private String email;
	

    
    
   //@JsonBackReference
   
   // @JsonManagedReference
    //@JsonIgnore
    @OneToMany( mappedBy = "author",  cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Set<Post> post;
   
	
    
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Set<Post> getPost() {
		return post;
	}

	public void setPost(Set<Post> post) {
		this.post = post;
	}
    
     


}
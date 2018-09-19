package in.smartbox.springcms.model;

import java.util.Date;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
   
    @Entity
    @Table(name="Author")
   public class Author {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="AuthorId", unique=true, nullable=false)
    private Long Id;
	
	
	@Column(name="AuthorName", unique=true, nullable=false)
	private String Name;
	
    @Column(name="Email", nullable=false)
    private String email;
	 
	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;
	

	@JsonIgnore
    @OneToMany( mappedBy = "author",  cascade = CascadeType.ALL,  fetch = FetchType.LAZY)
    private Set<Post> post;
   
	
    
    public long getId() {
        return Id;
    }
 	
    public void setId(long Id) {
        this.Id = Id;
    }
    public String getName() {
        return Name;
    }
 
    public void setName(String Name) {
        this.Name = Name;
    }

    public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }
    
     public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
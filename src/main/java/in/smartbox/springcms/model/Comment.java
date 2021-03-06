package in.smartbox.springcms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "comment")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class)
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(unique=true, nullable=false)
    private Long id;
	
    
    @Column(name="commentContent", nullable=false)
     private String content;
    
   /* @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_At", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;
*/

	@Column(name="userName", unique=true, nullable=false)
	private String name;
	
    

	//@JsonManagedReference
     @ManyToOne
	@JoinColumn(name = "post_id", nullable = false)
    private Post post;
    
    

    public String getContent()
    {
    	return content;
    }
    public void setContent(String content)
    {
    	this.content=content;
    }

    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Post getPost() {
		return post;
	}

	public void setPost(Post post) {
		this.post = post;
	}


    
   /* public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
    */


}
package in.smartbox.springcms.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.data.annotation.CreatedDate;

@Entity
@Table(name = "Comment")
public class Comment {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
    private Long id;
	
    
   
    @Column(name="CommentContent", nullable=false)
     private String content;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "Created_At", nullable = false, updatable = false)
    @CreatedDate
    private Date createdAt;


    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@ManyToOne
    private Post post;
    
    

    public String getContent()
    {
    	return content;
    }
    public void setContent(String content)
    {
    	this.content=content;
    }
    
    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }


}
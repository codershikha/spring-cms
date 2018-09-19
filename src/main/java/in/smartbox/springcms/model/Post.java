package in.smartbox.springcms.model;

import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.Size;
import org.springframework.data.annotation.CreatedDate;
import java.util.*;

@Entity
@Table(name = "Post")
public class Post {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PostId", nullable = false, updatable = false)
	private Long id;

	@Column(name = "Content", nullable = false, updatable = false)
	private String content;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "created_at", nullable = false, updatable = false)
	@CreatedDate
	private Date createdAt;

	@ManyToOne
	private Author author;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
	private List<Comment> comments;

	@Size(max = 100)
	@Column(unique = true)
	private String title;

	public long getId() {
		return id;
	}

	public void setId(long id) {
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

	public void setTitle(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

}
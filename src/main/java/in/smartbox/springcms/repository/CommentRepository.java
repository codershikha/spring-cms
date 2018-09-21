package in.smartbox.springcms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import in.smartbox.springcms.model.Comment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
	Page<Comment> findByPostId(Long postId, Pageable pageable);

}

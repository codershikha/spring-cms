package in.smartbox.springcms.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import in.smartbox.springcms.model.Author;

public interface AuthorRepository extends JpaRepository<Author,Long> {

}

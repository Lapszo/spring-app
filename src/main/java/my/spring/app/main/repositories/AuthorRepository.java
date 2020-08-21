package my.spring.app.main.repositories;

import my.spring.app.main.entities.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}

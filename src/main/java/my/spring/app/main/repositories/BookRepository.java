package my.spring.app.main.repositories;

import my.spring.app.main.entities.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}

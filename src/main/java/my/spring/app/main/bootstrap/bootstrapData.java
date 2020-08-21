package my.spring.app.main.bootstrap;

import my.spring.app.main.entities.Author;
import my.spring.app.main.entities.Book;
import my.spring.app.main.repositories.AuthorRepository;
import my.spring.app.main.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;

    public bootstrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author tom =  new Author("Tom", "Lapszo");
        Book book1 = new Book("The Ring", "124543");
        tom.getBooks().add(book1);
        book1.getAuthors().add(tom);
        authorRepository.save(tom);
        bookRepository.save(book1);

        Author tomsBestFriend =  new Author("Empty", "Void");
        Book tomsBestFriendBook = new Book("The Void", "666");

        tomsBestFriend.getBooks().add(book1);
        tomsBestFriendBook.getAuthors().add(tomsBestFriend);
        authorRepository.save(tomsBestFriend);
        bookRepository.save(tomsBestFriendBook);
        System.out.println("books: " + bookRepository.count());
    }
}

package my.spring.app.main.bootstrap;

import my.spring.app.main.entities.Author;
import my.spring.app.main.entities.Book;
import my.spring.app.main.entities.Publisher;
import my.spring.app.main.repositories.AuthorRepository;
import my.spring.app.main.repositories.BookRepository;
import my.spring.app.main.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class bootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public bootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher publisher = new Publisher("Publisher","Publisher","PublishStreet5","PublishCity","pub-lish");
        publisherRepository.save(publisher);

        Author tom =  new Author("Tom", "Lapszo");
        Book book1 = new Book("The Ring", "124543");
        tom.getBooks().add(book1);
        book1.getAuthors().add(tom);
        book1.setPublisher(publisher);


        authorRepository.save(tom);
        bookRepository.save(book1);

        Author tomsBestFriend =  new Author("Empty", "Void");
        Book tomsBestFriendBook = new Book("The Void", "666");

        tomsBestFriend.getBooks().add(book1);
        tomsBestFriendBook.getAuthors().add(tomsBestFriend);
        tomsBestFriendBook.setPublisher(publisher);


        authorRepository.save(tomsBestFriend);
        bookRepository.save(tomsBestFriendBook);


        publisher.getBooks().add(book1);
        publisher.getBooks().add(tomsBestFriendBook);
        publisherRepository.save(publisher);

        System.out.println("books: " + bookRepository.count());

    }
}

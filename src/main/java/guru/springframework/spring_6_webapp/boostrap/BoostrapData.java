package guru.springframework.spring_6_webapp.boostrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.domain.Publisher;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import guru.springframework.spring_6_webapp.repositories.PublisherRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@AllArgsConstructor
public class BoostrapData implements CommandLineRunner {

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;
    public final PublisherRepository publisherRepository;

    @Override
    public void run(String... args) throws Exception {
        /*-- Initial data --*/
        Author author = Author.builder()
                .firstName("Erick")
                .lastName("Evans")
                .build();

        Book book = Book.builder()
                .title("Domain Driven Design")
                .isbn("123456")
                .build();

        Author authorSaved = authorRepository.save(author);
        Book bookSaved = bookRepository.save(book);

        Author authorTwo = Author.builder()
                .firstName("Rod")
                .lastName("Jhonson")
                .build();

        Book bookTwo = Book.builder()
                .title("J2EE Development without EJB")
                .isbn("54757585")
                .build();

        Author authorTwoSaved = authorRepository.save(authorTwo);
        Book bookTwoSaved = bookRepository.save(bookTwo);

        Publisher publisher = Publisher.builder()
                .publisherName("My Publisher")
                .address("123 Main")
                .build();
        Publisher savedPublisher = publisherRepository.save(publisher);

        bookSaved.setPublisher(savedPublisher);
        bookTwoSaved.setPublisher(savedPublisher);

        bookSaved.getAuthors().add(authorSaved);
        bookTwoSaved.getAuthors().add(authorTwoSaved);

        authorRepository.save(authorSaved);
        authorRepository.save(authorTwoSaved);

        bookRepository.save(bookSaved);
        bookRepository.save(bookTwoSaved);
        
        System.out.println("In Boostrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}

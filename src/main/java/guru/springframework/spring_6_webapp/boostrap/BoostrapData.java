package guru.springframework.spring_6_webapp.boostrap;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.HashSet;

@Component
@AllArgsConstructor
public class BoostrapData implements CommandLineRunner {

    public final AuthorRepository authorRepository;
    public final BookRepository bookRepository;

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
                .firstName("Erick")
                .lastName("Evans")
                .build();

        Book bookTwo = Book.builder()
                .title("J2EE Development without EJB")
                .isbn("54757585")
                .build();

        Author authorTwoSaved = authorRepository.save(authorTwo);
        Book bookTwoSaved = bookRepository.save(bookTwo);

        authorSaved.getBooks().add(bookSaved);
        authorTwoSaved.getBooks().add(bookTwoSaved);

        System.out.println("In Boostrap");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
    }
}

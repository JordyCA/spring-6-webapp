package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Book;
import guru.springframework.spring_6_webapp.repositories.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookServicesImpl implements BookServices {

    private final BookRepository bookRepository;

    @Override
    public Iterable<Book> findAll() {
        return bookRepository.findAll();
    }
}

package guru.springframework.spring_6_webapp.services;

import guru.springframework.spring_6_webapp.domain.Author;
import guru.springframework.spring_6_webapp.repositories.AuthorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthorServicesImpl implements AuthorServices {
    private final AuthorRepository authorRepository;

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}

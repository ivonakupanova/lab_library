package lab.exercise.service.impl;

import lab.exercise.model.Author;
import lab.exercise.repository.AuthorRepository;
import lab.exercise.service.AuthorService;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }
}

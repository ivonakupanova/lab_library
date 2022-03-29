package lab.exercise.service;

import lab.exercise.model.Author;

import java.util.Optional;

public interface AuthorService {
    Optional<Author> findById(Long id);
}
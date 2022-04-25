package lab.exercise.service;

import lab.exercise.model.Author;
import lab.exercise.model.Book;
import lab.exercise.model.Category;
import lab.exercise.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> edit(Long id, BookDto productDto);

    Optional<Book> save(BookDto productDto);

    Optional<Book> save(String name, Category category, Author author, Integer availableCopies);

    void deleteById(Long id);

    void markAsTaken(Long id);
}

package lab.exercise.service;

import lab.exercise.model.Book;
import lab.exercise.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {
    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> edit(Long id, BookDto productDto);

    Optional<Book> save(BookDto productDto);

    void deleteById(Long id);
}

package lab.exercise.service.impl;

import lab.exercise.model.Author;
import lab.exercise.model.Book;
import lab.exercise.model.dto.BookDto;
import lab.exercise.model.exceptions.AuthorNotFoundException;
import lab.exercise.model.exceptions.BookNotFoundException;
import lab.exercise.repository.AuthorRepository;
import lab.exercise.repository.BookRepository;
import lab.exercise.service.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    public List<Book> findAll(){
        return this.bookRepository.findAll();
    }

    public Optional<Book> findById(Long id)
    {
        return bookRepository.findById(id);
    }

    public Optional<Book> edit(Long id, BookDto productDto) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());

        book.setName(productDto.getName());
        book.setCategory(productDto.getCategory());
        book.setAvailableCopies(productDto.getAvailableCopies());

        Author author = this.authorRepository.findById(productDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException());
        book.setAuthor(author);

        this.bookRepository.save(book);
        return Optional.of(book);
    }

    public Optional<Book> save(BookDto bookDto) {
        Author author = this.authorRepository.findById(bookDto.getAuthor())
                .orElseThrow(() -> new AuthorNotFoundException());

        this.bookRepository.deleteByNameAndAuthor(bookDto.getName(), author);
        Book book = new Book(bookDto.getName(), bookDto.getCategory(), author, bookDto.getAvailableCopies());
        this.bookRepository.save(book);
        return Optional.of(book);
    }

    public void deleteById(Long id) {
        this.bookRepository.deleteById(id);
    }

    @Override
    public void markAsTaken(Long id) {
        Book book = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFoundException());
        if (book.getAvailableCopies()-1>=0)
        {
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }
        else book.setAvailableCopies(0);

    }


}

package lab.exercise.repository;

import lab.exercise.model.Author;
import lab.exercise.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {
    void deleteByNameAndAuthor(String name, Author author);
}

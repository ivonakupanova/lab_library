package lab.exercise.web;

import lab.exercise.model.Author;
import lab.exercise.model.Book;
import lab.exercise.service.AuthorService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/authors")
public class AuthorController {

    private final AuthorService authorService;


    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> getAllAuthors() {
        return this.authorService.findAll();
    }
}

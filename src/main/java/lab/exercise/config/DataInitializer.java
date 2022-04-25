package lab.exercise.config;

import lab.exercise.model.Author;
import lab.exercise.model.Category;
import lab.exercise.model.Country;
import lab.exercise.service.AuthorService;
import lab.exercise.service.BookService;
import lab.exercise.service.CountryService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
public class DataInitializer {

    private final BookService bookService;
    private final AuthorService authorService;
    private final CountryService countryService;

    public DataInitializer(BookService bookService, AuthorService authorService, CountryService countryService) {
        this.bookService = bookService;
        this.authorService = authorService;
        this.countryService = countryService;
    }

    @PostConstruct
    public void initData() {
        this.countryService.save("Country1","Continent1");
        this.countryService.save("Country2","Continent2");
        this.countryService.save("Country3","Continent3");
        List<Country> countries = countryService.findAll();

        this.authorService.save("Author1","Author1",countries.get(0));
        this.authorService.save("Author2","Author2",countries.get(1));
        this.authorService.save("Author3","Author3",countries.get(2));
        List<Author> authors = authorService.findAll();

        this.bookService.save("Book1", Category.CLASSICS,authors.get(0),5);
        this.bookService.save("Book2", Category.BIOGRAPHY,authors.get(1),3);
        this.bookService.save("Book33", Category.DRAMA,authors.get(1),0);
        this.bookService.save("Book8", Category.CLASSICS,authors.get(2),4);
        this.bookService.save("Book14", Category.FANTASY,authors.get(2),15);
        this.bookService.save("Book10", Category.NOVEL,authors.get(0),6);


    }
}

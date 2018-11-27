package library.restapi.hyperlinks;

import library.entities.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import library.repositories.jpa.BooksRepositoryJPA;
import java.util.List;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RepositoryRestController
public class RestAPIBooksControllerWithHyperLinks {
    @GetMapping(path="/booksapi/mostexpensive", produces="application/hal+json")
    public ResponseEntity<Resources<BooksResource>> mostExpensiveBooks() {
        PageRequest page = PageRequest.of(0, 3, Sort.by("cost").descending());
        List<Book> books = booksRepositoryJPA.findAll(page).getContent();
        List<BooksResource> booksResources = new BooksResourceAssembler().toResources(books);
        Resources<BooksResource> recentResources = new Resources<BooksResource>(booksResources);
        recentResources.add(linkTo(methodOn(RestAPIBooksControllerWithHyperLinks.class).mostExpensiveBooks()).withRel("mostexpensives"));
        return new ResponseEntity<>(recentResources, HttpStatus.OK);
    }

    private BooksRepositoryJPA booksRepositoryJPA;

    public RestAPIBooksControllerWithHyperLinks(BooksRepositoryJPA booksRepositoryJPA) {
        this.booksRepositoryJPA = booksRepositoryJPA;
    }

    /*
    @GetMapping("/{id}")
    public ResponseEntity<Book> booksById(@PathVariable("id") Long id) {
        Optional<Book> optionalBooks = booksRepositoryJPA.findById(id);
        if (optionalBooks.isPresent()) {
            return new ResponseEntity<>(optionalBooks.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }
    */
}


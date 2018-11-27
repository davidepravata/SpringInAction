package library.restapi;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import library.repositories.jpa.BooksRepositoryJPA;
import library.entities.Books;
import java.util.Optional;

@RestController
@RequestMapping(path="/booksapi",produces="application/json")
@CrossOrigin(origins="*")
public class RestAPIBooksController {

    @GetMapping("/mostexpensive")
    public Iterable<Books> recentBooks() {
        PageRequest page = PageRequest.of(0, 3, Sort.by("cost").descending());
        return booksRepositoryJPA.findAll(page).getContent();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Books> booksById(@PathVariable("id") Long id) {
        Optional<Books> optionalBooks = booksRepositoryJPA.findById(id);
        if (optionalBooks.isPresent()) {
            return new ResponseEntity<>(optionalBooks.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBooks(@PathVariable("id") Long id) {
        Books oldBook = booksRepositoryJPA.findByBookId(id);
        if(oldBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        booksRepositoryJPA.delete(oldBook);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/put/{id}", consumes="application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Books putBooks(@PathVariable("id") Long id, @RequestBody Books putBook) {
        Books oldBook = booksRepositoryJPA.findByBookId(id);
        oldBook.setTitle(putBook.getTitle());
        oldBook.setCost(putBook.getCost());
        oldBook.setIsbn(putBook.getIsbn());
        return booksRepositoryJPA.save(oldBook);
    }

    @PatchMapping(path = "/patch/{id}", consumes="application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Books patchBooks(@PathVariable("id") Long id, @RequestBody Books patchedBook) {
        Books oldBook = booksRepositoryJPA.findByBookId(id);
        if(patchedBook.getTitle() != null) { oldBook.setTitle(patchedBook.getTitle()); }
        if(patchedBook.getCost() != null) { oldBook.setTitle(patchedBook.getCost()); }
        if(patchedBook.getIsbn() != null) { oldBook.setIsbn(patchedBook.getIsbn());}
        return booksRepositoryJPA.save(oldBook);
    }

    private BooksRepositoryJPA booksRepositoryJPA;

    public RestAPIBooksController(BooksRepositoryJPA booksRepositoryJPA) {
        this.booksRepositoryJPA = booksRepositoryJPA;
    }



    @PostMapping(path = "/save", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Books postBooks(@RequestBody Books book) {
        return booksRepositoryJPA.save(book);
    }
}


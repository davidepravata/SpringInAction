package library.restapi;

import library.entities.Book;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import library.repositories.jpa.BooksRepositoryJPA;

import java.util.Optional;

@RestController
@RequestMapping(path="/booksapi",produces="application/json")
@CrossOrigin(origins="*")
public class RestAPIBooksController {

    @GetMapping("/mostexpensive")
    public Iterable<Book> recentBooks() {
        PageRequest page = PageRequest.of(0, 3, Sort.by("cost").descending());
        return booksRepositoryJPA.findAll(page).getContent();
    }



    @GetMapping("/{id}")
    public ResponseEntity<Book> booksById(@PathVariable("id") Long id) {
        Optional<Book> optionalBooks = booksRepositoryJPA.findById(id);
        if (optionalBooks.isPresent()) {
            return new ResponseEntity<>(optionalBooks.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseEntity deleteBooks(@PathVariable("id") Long id) {
        Book oldBook = booksRepositoryJPA.findByBookId(id);
        if(oldBook == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        booksRepositoryJPA.delete(oldBook);
        return new ResponseEntity(HttpStatus.OK);
    }

    @PutMapping(path = "/put/{id}", consumes="application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book putBooks(@PathVariable("id") Long id, @RequestBody Book putBook) {
        Book oldBook = booksRepositoryJPA.findByBookId(id);
        oldBook.setTitle(putBook.getTitle());
        oldBook.setCost(putBook.getCost());
        oldBook.setIsbn(putBook.getIsbn());
        return booksRepositoryJPA.save(oldBook);
    }

    @PatchMapping(path = "/patch/{id}", consumes="application/json")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Book patchBooks(@PathVariable("id") Long id, @RequestBody Book patchedBook) {
        Book oldBook = booksRepositoryJPA.findByBookId(id);
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
    public Book postBooks(@RequestBody Book book) {
        return booksRepositoryJPA.save(book);
    }
}


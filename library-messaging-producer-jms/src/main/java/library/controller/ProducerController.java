package library.controller;

import library.entities.Book;
import library.repositories.jpa.BooksRepositoryJPA;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(path="/messaging",produces="application/json")
@CrossOrigin(origins="*")
public class ProducerController {

    private BooksRepositoryJPA booksRepositoryJPA;

    public ProducerController(BooksRepositoryJPA booksRepositoryJPA) {
        this.booksRepositoryJPA = booksRepositoryJPA;
    }



    @PostMapping(path = "/addmsg", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addMsg(@RequestBody Book book) {
        return booksRepositoryJPA.save(book);
    }
}


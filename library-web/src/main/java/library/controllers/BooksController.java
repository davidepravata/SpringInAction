package library.controllers;

import library.controllers.BooksControllerConfigurations;
import library.entities.Books;
import library.repositories.jpa.BooksRepositoryJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/books")
public class BooksController {
    private BooksControllerConfigurations booksControllerConfigurations;
    private BooksRepositoryJPA booksRepositoryJPA;

    @Autowired
    public BooksController(BooksRepositoryJPA booksRepositoryJPA, BooksControllerConfigurations booksControllerConfigurations) {
        this.booksRepositoryJPA = booksRepositoryJPA;
        this.booksControllerConfigurations = booksControllerConfigurations;
    }

    @GetMapping
    public String retrieveAvailableBooks(Model model) {
        Pageable pageable = PageRequest.of(0, booksControllerConfigurations.getPageSize());
        List<Books> availableBooks = null;
        if(booksControllerConfigurations.isOrderByIdDesc()) {
            availableBooks = booksRepositoryJPA.findBooksOrderByIdDesc(pageable);
        } else {
            availableBooks = booksRepositoryJPA.findBooks(pageable);
        }

        //List<Books> availableBooks = booksRepositoryJDBC.findAllBooks();
        if (availableBooks != null) {
            model.addAttribute("books", availableBooks);
        }
        model.addAttribute("new_book", new Books());
        return "books";
    }



    @PostMapping
    public String addBooks(@Valid @ModelAttribute("new_book") Books book, Errors errors) {
        if(errors.hasErrors()) {
            return "books";
        }
        booksRepositoryJPA.save(book);
        return "redirect:/books";
    }
}

package library.reactivecontrollers;

import library.entities.Book;
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
public class BookControllerReactive {
    private BookControllerConfigurationReactive bookControllerConfigurationReactive;
    private BooksRepositoryJPA booksRepositoryJPA;

    @Autowired
    public BookControllerReactive(BooksRepositoryJPA booksRepositoryJPA, BookControllerConfigurationReactive bookControllerConfigurationReactive) {
        this.booksRepositoryJPA = booksRepositoryJPA;
        this.bookControllerConfigurationReactive = bookControllerConfigurationReactive;
    }

    @GetMapping
    public String retrieveAvailableBooks(Model model) {
        Pageable pageable = PageRequest.of(0, bookControllerConfigurationReactive.getPageSize());
        List<Book> availableBooks = null;
        if(bookControllerConfigurationReactive.isOrderByIdDesc()) {
            availableBooks = booksRepositoryJPA.findBooksOrderByIdDesc(pageable);
        } else {
            availableBooks = booksRepositoryJPA.findBooks(pageable);
        }

        //List<Book> availableBooks = booksRepositoryJDBC.findAllBooks();
        if (availableBooks != null) {
            model.addAttribute("books", availableBooks);
        }
        model.addAttribute("new_book", new Book());
        return "books";
    }



    @PostMapping
    public String addBooks(@Valid @ModelAttribute("new_book") Book book, Errors errors) {
        if(errors.hasErrors()) {
            return "books";
        }
        booksRepositoryJPA.save(book);
        return "redirect:/books";
    }
}

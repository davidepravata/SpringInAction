package library.controllers;

import library.entities.Book;
import library.entities.User;
import library.entities.UserBook;
import library.repositories.jpa.BooksRepositoryJPA;
import library.repositories.jpa.UsersBooksRepositoryJPA;
import library.repositories.jpa.UsersRepositoryJPA;
import library.util.TitlesVsUsername;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/users_books")
public class UserBookController {

    private UsersBooksRepositoryJPA usersBooksRepositoryJPA;
    private BooksRepositoryJPA booksRepositoryJPA;
    private UsersRepositoryJPA usersRepositoryJPA;

    @Autowired
    public UserBookController(UsersBooksRepositoryJPA usersBooksRepositoryJPA, UsersRepositoryJPA usersRepositoryJPA, BooksRepositoryJPA booksRepositoryJPA) {
        this.usersBooksRepositoryJPA = usersBooksRepositoryJPA;
        this.usersRepositoryJPA = usersRepositoryJPA;
        this.booksRepositoryJPA = booksRepositoryJPA;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String retrieveAvailableUsersBooks(Model model) {

        List<UserBook> availableUsersBooks = usersBooksRepositoryJPA.findAllUsersBooks();
        model.addAttribute("users_books",availableUsersBooks);
        List<TitlesVsUsername> titlesVsUsernames = new ArrayList<>();

        for (UserBook userBook : availableUsersBooks) {

            long id_user = userBook.getId_user();
            long id_book = userBook.getId_book();

            User user = usersRepositoryJPA.findUsersById(id_user);
            Book book = booksRepositoryJPA.findByBookId(id_book);
            titlesVsUsernames.add(new TitlesVsUsername(book.getTitle(), user.getUsername()));

        }
        model.addAttribute("titles_usernames", titlesVsUsernames);
        model.addAttribute("books", booksRepositoryJPA.findDistinctBooks());
        model.addAttribute("users", usersRepositoryJPA.findDistinctUsers());
        model.addAttribute("users_books", usersBooksRepositoryJPA.findAllUsersBooksPossibilities());
        return "users_books";
    }

    @RequestMapping(method=RequestMethod.POST)
    public String addUsersBooks(TitlesVsUsername titlesVsUsername) {
        Book book = booksRepositoryJPA.findByBookTitle(titlesVsUsername.getTitle());
        User user = usersRepositoryJPA.findUsersByUsername(titlesVsUsername.getUsername());

        UserBook userBook = new UserBook();
        userBook.setId_book(book.getId());
        userBook.setId_user(user.getId());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        userBook.setTime_purchase(now);
        usersBooksRepositoryJPA.save(userBook);
        return "redirect:/users_books";
    }
}
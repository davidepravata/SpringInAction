package library.controllers;

import library.entities.Books;
import library.entities.Users;
import library.entities.UsersBooks;
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
public class UsersBooksController {

    private UsersBooksRepositoryJPA usersBooksRepositoryJPA;
    private BooksRepositoryJPA booksRepositoryJPA;
    private UsersRepositoryJPA usersRepositoryJPA;

    @Autowired
    public UsersBooksController(UsersBooksRepositoryJPA usersBooksRepositoryJPA, UsersRepositoryJPA usersRepositoryJPA, BooksRepositoryJPA booksRepositoryJPA) {
        this.usersBooksRepositoryJPA = usersBooksRepositoryJPA;
        this.usersRepositoryJPA = usersRepositoryJPA;
        this.booksRepositoryJPA = booksRepositoryJPA;
    }

    @RequestMapping(method=RequestMethod.GET)
    public String retrieveAvailableUsersBooks(Model model) {

        List<UsersBooks> availableUsersBooks = usersBooksRepositoryJPA.findAllUsersBooks();
        model.addAttribute("users_books",availableUsersBooks);
        List<TitlesVsUsername> titlesVsUsernames = new ArrayList<>();

        for (UsersBooks usersBooks : availableUsersBooks) {

            long id_user = usersBooks.getId_user();
            long id_book = usersBooks.getId_book();

            Users user = usersRepositoryJPA.findUsersById(id_user);
            Books book = booksRepositoryJPA.findByBookId(id_book);
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
        Books book = booksRepositoryJPA.findByBookTitle(titlesVsUsername.getTitle());
        Users user = usersRepositoryJPA.findUsersByUsername(titlesVsUsername.getUsername());

        UsersBooks usersBooks = new UsersBooks();
        usersBooks.setId_book(book.getId());
        usersBooks.setId_user(user.getId());
        Timestamp now = new Timestamp(System.currentTimeMillis());
        usersBooks.setTime_purchase(now);
        usersBooksRepositoryJPA.save(usersBooks);
        return "redirect:/users_books";
    }
}
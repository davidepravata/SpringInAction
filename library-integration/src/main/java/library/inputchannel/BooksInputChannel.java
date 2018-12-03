package library.inputchannel;

import library.entities.Book;
import library.repositories.jpa.BooksRepositoryJPA;

import java.util.List;

public class BooksInputChannel implements InputChannel{

    private BooksRepositoryJPA booksRepositoryJPA;

    public BooksInputChannel(BooksRepositoryJPA booksRepositoryJPA) {
        this.booksRepositoryJPA = booksRepositoryJPA;
    }
    @Override
    public List<Book> readInput() {
        List<Book> bookArrayList = booksRepositoryJPA.findAll();
        return bookArrayList;
    }
}

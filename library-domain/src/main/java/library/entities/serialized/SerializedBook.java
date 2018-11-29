package library.entities.serialized;

import library.entities.Book;
import lombok.Data;

import javax.persistence.Entity;
import java.io.Serializable;

@Data
public class SerializedBook implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    private String title;
    private String cost;
    private String isbn;

    public SerializedBook() {

    }

    public SerializedBook(long id, String title, String cost, String isbn) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.isbn = isbn;
    }

    public SerializedBook(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.cost = book.getCost();
        this.isbn = book.getIsbn();
    }

    public Book getBook(SerializedBook serializedBook) {
        Book book = new Book();
        book.setTitle(serializedBook.getTitle());
        book.setId(serializedBook.getId());
        book.setIsbn(serializedBook.getIsbn());
        book.setCost(serializedBook.getCost());
        return book;
    }


}

package library.entities.serialized;

import library.entities.Book;

import java.io.Serializable;

public class SerializedBook implements Serializable {
    private long id;
    private String title;
    private String cost;
    private String isbn;

    public SerializedBook(Book book) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.cost = book.getCost();
        this.isbn = book.getIsbn();
    }


}

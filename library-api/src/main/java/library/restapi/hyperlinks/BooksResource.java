package library.restapi.hyperlinks;

import library.entities.Book;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.core.Relation;


@Relation(value = "book", collectionRelation = "books")
public class BooksResource extends ResourceSupport {
    private String title;
    private String cost;
    private String isbn;

    public BooksResource(Book book) {
        this.title = book.getTitle();
        this.cost = book.getCost();
        this.isbn = book.getIsbn();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}

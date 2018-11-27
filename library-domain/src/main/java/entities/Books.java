package entities;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

/*
create table books(
id bigint(20) NOT NULL AUTO_INCREMENT,
title varchar(255) NOT NULL,
cost decimal(10,2) NOT NULL,
isbn char(13) NOT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY(isbn)
) */
@Entity
public class Books {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="title")
    @NotNull(message = "Invalid empty title")
    private String title;
    @Column(name="cost")
    @Pattern(regexp = "[0-9]+(.[0-9]{1,2})?", message = "Invalid price")
    private String cost;
    @NotNull(message="Invalid empty price")
    @Size(min=13,max=13, message="Size not valid for isbn, must be 13 chars")
    @Column(name="isbn")
    private String isbn;

    public Books(long id, @NotNull(message = "Invalid empty title") String title, @Pattern(regexp = "[0-9]+(.[0-9]{1,2})?", message = "Invalid price") String cost, @NotNull(message = "Invalid empty price") @Size(min = 13, max = 13, message = "Size not valid for isbn, must be 13 chars") String isbn) {
        this.id = id;
        this.title = title;
        this.cost = cost;
        this.isbn = isbn;
    }

    public Books() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    @Override
    public String toString() {
        return "Books{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", cost=" + cost +
                ", isbn='" + isbn + '\'' +
                '}';
    }
}

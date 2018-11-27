package library.repositories;

import library.entities.Book;

import java.util.List;

public interface BooksRepository {
    List<Book> findAllBooks();
    Book save(Book newBook);
}

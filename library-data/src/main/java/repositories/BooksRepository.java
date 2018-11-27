package repositories;

import entities.Books;

import java.util.List;

public interface BooksRepository {
    List<Books> findAllBooks();
    Books save(Books newBook);
}

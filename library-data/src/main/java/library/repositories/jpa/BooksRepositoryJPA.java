package library.repositories.jpa;

import library.entities.Book;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepositoryJPA extends JpaRepository<Book, Long> {
    @Query(value = "SELECT * FROM BOOK", nativeQuery = true)
    List<Book> findBooks(Pageable pageable);
    @Query(value = "SELECT distinct(title) FROM BOOK", nativeQuery = true)
    List<String> findDistinctBooks();
    @Query(value = "SELECT * FROM BOOK WHERE ID=?1", nativeQuery = true)
    Book findByBookId(long id);
    @Query(value = "SELECT * FROM BOOK WHERE TITLE=?1", nativeQuery = true)
    Book findByBookTitle(String bookTitle);
    @Query(value = "SELECT * FROM BOOK ORDER BY ID DESC", nativeQuery = true)
    List<Book> findBooksOrderByIdDesc(Pageable pageable);
}

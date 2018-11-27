package library.repositories.jpa;

import library.entities.Books;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BooksRepositoryJPA extends JpaRepository<Books, Long> {
    @Query(value = "SELECT * FROM BOOKS", nativeQuery = true)
    List<Books> findBooks(Pageable pageable);
    @Query(value = "SELECT distinct(title) FROM BOOKS", nativeQuery = true)
    List<String> findDistinctBooks();
    @Query(value = "SELECT * FROM BOOKS WHERE ID=?1", nativeQuery = true)
    Books findByBookId(long id);
    @Query(value = "SELECT * FROM BOOKS WHERE TITLE=?1", nativeQuery = true)
    Books findByBookTitle(String bookTitle);
    @Query(value = "SELECT * FROM BOOKS ORDER BY ID DESC", nativeQuery = true)
    List<Books> findBooksOrderByIdDesc(Pageable pageable);
}

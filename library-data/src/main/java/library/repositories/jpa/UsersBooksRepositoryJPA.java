package library.repositories.jpa;

import library.entities.UserBook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersBooksRepositoryJPA extends JpaRepository<UserBook, Long> {

    @Query(value = "SELECT * FROM USER_BOOK", nativeQuery = true)
    List<UserBook> findAllUsersBooks();

    @Query(value = "SELECT book.title, user.username FROM user,book", nativeQuery = true)
    List<String[]> findAllUsersBooksPossibilities();
}

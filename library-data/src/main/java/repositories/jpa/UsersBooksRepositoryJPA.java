package repositories.jpa;

import entities.UsersBooks;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersBooksRepositoryJPA extends JpaRepository<UsersBooks, Long> {

    @Query(value = "SELECT * FROM USERS_BOOKS", nativeQuery = true)
    List<UsersBooks> findAllUsersBooks();

    @Query(value = "SELECT books.title, users.username FROM users,books", nativeQuery = true)
    List<String[]> findAllUsersBooksPossibilities();
}

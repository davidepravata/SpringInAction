package library.repositories.jpa;

import library.entities.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UsersRepositoryJPA extends CrudRepository<User, Long> {
    User findUsersById(long id_user);
    List<User> findAll();
    @Query(value = "SELECT distinct(username) FROM USERS", nativeQuery = true)
    List<String> findDistinctUsers();
    User findUsersByUsername(String username);
}

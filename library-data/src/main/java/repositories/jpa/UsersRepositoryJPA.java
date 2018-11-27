package repositories.jpa;

import entities.Users;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import java.util.List;

public interface UsersRepositoryJPA extends CrudRepository<Users, Long> {
    Users findUsersById(long id_user);
    List<Users> findAll();
    @Query(value = "SELECT distinct(username) FROM USERS", nativeQuery = true)
    List<String> findDistinctUsers();
    Users findUsersByUsername(String username);
}

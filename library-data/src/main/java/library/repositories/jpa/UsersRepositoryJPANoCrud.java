package library.repositories.jpa;

import library.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface UsersRepositoryJPANoCrud extends JpaRepository<Users, Long> {

    @Query(value = "SELECT * FROM USERS", nativeQuery = true)
    List<Users> findAllUsers();
    @Query(value = "SELECT distinct(username) FROM USERS", nativeQuery = true)
    List<String> findDistinctUsers();
    @Query(value = "SELECT * FROM USERS WHERE ID=?1", nativeQuery = true)
    Users findByUserId(long id);
    @Query(value = "SELECT * FROM USERS WHERE USERNAME =?1", nativeQuery = true)
    Users findByUserUsername(String userUsername);
}

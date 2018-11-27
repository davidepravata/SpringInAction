import org.springframework.data.repository.CrudRepository;

public interface RegisteredUsersRepository extends CrudRepository<RegisteredUser, Long> {
    RegisteredUser findRegisteredUserByUsername(String username);
}

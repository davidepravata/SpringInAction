package library.repositories.jdbc;

import library.entities.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import library.repositories.BooksRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BooksRepositoryJDBC implements BooksRepository {
    private JdbcTemplate jdbc;

    @Autowired
    public BooksRepositoryJDBC(JdbcTemplate jdbc) { this.jdbc = jdbc; }

    @Override
    public List<Books> findAllBooks() { return jdbc.query("select id, title, cost, isbn from books", this::mapRowToBooks); }

    @Override
    public Books save(Books newBook) {
        jdbc.update("insert into books values(?,?,?,?);", newBook.getId(),newBook.getTitle(), newBook.getCost(), newBook.getIsbn());
        return newBook;
    }

    private Books mapRowToBooks(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String title = rs.getString("title");
        String cost = rs.getString("cost");
        String isbn = rs.getString("isbn");
        return new Books(id,title,cost,isbn);
    }
}

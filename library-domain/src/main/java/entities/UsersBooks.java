package entities;

import javax.persistence.*;
import java.sql.Timestamp;

/*
create table users_books(
    id biglong(20) NOT NULL AUTO_INCREMENT,
    id_user biglong(20) NOT NULL,
    id_book biglong(20) NOT NULL,
    time_purchase timestamp NOT NULL,
    FOREIGN KEY (id_user) REFERENCES users(id),
    FOREIGN KEY (id_book) REFERENCES books(id),
    UNIQUE KEY(id_user, id_book),
    PRIMARY KEY(id)
) */
@Entity
public class UsersBooks {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name="id_user")
    private long id_user;
    @Column(name="id_book")
    private long id_book;
    @Column(name="time_purchase")
    private Timestamp time_purchase;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getId_user() {
        return id_user;
    }

    public void setId_user(long id_user) {
        this.id_user = id_user;
    }

    public long getId_book() {
        return id_book;
    }

    public void setId_book(long id_book) {
        this.id_book = id_book;
    }

    public Timestamp getTime_purchase() {
        return time_purchase;
    }

    public void setTime_purchase(Timestamp time_purchase) {
        this.time_purchase = time_purchase;
    }

    @Override
    public String toString() {
        return "entities.UsersBooks{" +
                "id=" + id +
                ", id_user=" + id_user +
                ", id_book=" + id_book +
                ", time_purchase=" + time_purchase +
                '}';
    }
}

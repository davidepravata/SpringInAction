package library.producer.jms;

import library.entities.Books;

public interface BooksOrderReceiver {
    Books receiveBooksOrder();
}

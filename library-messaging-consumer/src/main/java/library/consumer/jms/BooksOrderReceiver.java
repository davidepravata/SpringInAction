package library.consumer.jms;

import library.entities.Books;

public interface BooksOrderReceiver {
    Books receiveBooksOrder();
}

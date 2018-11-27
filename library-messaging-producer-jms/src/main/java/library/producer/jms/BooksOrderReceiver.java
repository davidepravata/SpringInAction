package library.producer.jms;

import library.entities.Book;

public interface BooksOrderReceiver {
    Book receiveBooksOrder();
}

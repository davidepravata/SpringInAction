package library.consumer.jms;

import library.entities.Book;

public interface BooksOrderReceiver {
    Book receiveBooksOrder();
}

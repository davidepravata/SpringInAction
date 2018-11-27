package library.producer.jms;

import library.entities.Book;

public interface BookOrderReceiver {
    Book receiveBookOrder();
}

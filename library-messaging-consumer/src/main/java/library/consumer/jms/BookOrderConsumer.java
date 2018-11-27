package library.consumer.jms;

import library.entities.Book;

public interface BookOrderConsumer {
    Book receiveBookOrder();
}

package library.consumer;

import library.entities.Book;

public interface BookOrderConsumer {
    Book receiveBookOrder();
}

package library.producer.jms;

import library.entities.Book;

public interface BookOrderProducer {
    void produceBookOrder(Book book);
}

package library.producer.kafka;

import library.entities.Book;

public interface BookOrderProducer {
    void produceBookOrder(Book book);
}

package library.producer.rabbitmq;

import library.entities.Book;

public interface BookOrderProducer {
    void produceBookOrder(Book book);
}

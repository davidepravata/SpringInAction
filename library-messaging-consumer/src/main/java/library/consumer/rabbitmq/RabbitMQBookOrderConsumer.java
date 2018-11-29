package library.consumer.rabbitmq;

import library.consumer.BookOrderConsumer;
import library.entities.Book;
import library.entities.serialized.SerializedBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQBookOrderConsumer implements BookOrderConsumer {
    private RabbitTemplate rabbit;
    private MessageConverter converter;

    @Autowired
    public RabbitMQBookOrderConsumer(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
        this.converter = rabbit.getMessageConverter();
    }

    public Book receiveBookOrder() {
        SerializedBook serializedBook = (SerializedBook) rabbit.receiveAndConvert("library-books-rabbit-queue");
        Book book = serializedBook.getBook(serializedBook);
        log.info("Received rabbitMQ message containing book [" + book + "]");
        return book;
    }
}
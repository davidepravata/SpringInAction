package library.producer.rabbitmq;

import library.entities.Book;
import library.entities.serialized.SerializedBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class RabbitMQBookOrderProducer implements BookOrderProducer {

    private RabbitTemplate rabbit;

    @Autowired
    public RabbitMQBookOrderProducer(RabbitTemplate rabbit) {
        this.rabbit = rabbit;
    }

    public void produceBookOrder(Book book) {
        log.info("Producing message for [" + book + "]");
        rabbit.convertAndSend("library-books-rabbit-queue", new SerializedBook(book));
    }
}

package library.consumer.rabbitmq.listener;

import library.entities.Book;
import library.entities.serialized.SerializedBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConsumerListener {
    //@RabbitListener(queues = "library-books-rabbit-queue")
    public void receiveBookOrder(SerializedBook serializedBook) {
        Book book = serializedBook.getBook(serializedBook);
        log.info("Listener Book received[" + book + "]");
    }
}
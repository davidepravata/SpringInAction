package library.consumer.rabbitmq.listener;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class RabbitMQConsumerListener {
    @RabbitListener(queues = "library-books-rabbit-queue")
    public void receiveBookOrder(Book book) {
        log.info("Listener Book received[" + book + "]");
    }
}
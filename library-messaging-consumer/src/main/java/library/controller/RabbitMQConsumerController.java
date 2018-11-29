package library.controller;

import library.consumer.jms.JmsBookOrderConsumer;
import library.consumer.rabbitmq.RabbitMQBookOrderConsumer;
import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(path="/messaging",produces="application/json")
@RestController
@CrossOrigin(origins="*")
public class RabbitMQConsumerController {

    private RabbitMQBookOrderConsumer rabbitMQBookOrderConsumer;

    public RabbitMQConsumerController(RabbitMQBookOrderConsumer rabbitMQBookOrderConsumer) {
        this.rabbitMQBookOrderConsumer = rabbitMQBookOrderConsumer;
    }

    @GetMapping(path = "/receiverabbitmsg")
    @ResponseStatus(HttpStatus.OK)
    public Book receiveMsg() {
        log.info("Invoking rabbitMQ to verify if message has been received");
        Book book = (Book) rabbitMQBookOrderConsumer.receiveBookOrder();
        return book;
    }


}

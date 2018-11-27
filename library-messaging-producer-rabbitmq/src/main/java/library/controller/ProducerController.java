package library.controller;

import library.entities.Book;
import library.producer.rabbitmq.RabbitMQBookOrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/messaging",produces="application/json")
@CrossOrigin(origins="*")
public class ProducerController {

    private RabbitMQBookOrderProducer rabbitMQBookOrderProducer;

    public ProducerController(RabbitMQBookOrderProducer rabbitMQBookOrderProducer) {
        this.rabbitMQBookOrderProducer = rabbitMQBookOrderProducer;
    }

    @PostMapping(path = "/addmsg", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addMsg(@RequestBody Book book) {
        rabbitMQBookOrderProducer.produceBookOrder(book);
        log.info("Message added");
        return book;
    }
}


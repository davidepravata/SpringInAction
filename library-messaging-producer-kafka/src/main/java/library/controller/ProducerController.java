package library.controller;

import library.entities.Book;
import library.producer.kafka.KafkaBookOrderProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(path="/messaging",produces="application/json")
@CrossOrigin(origins="*")
public class ProducerController {

    private KafkaBookOrderProducer kafkaBookOrderProducer;

    public ProducerController(KafkaBookOrderProducer kafkaBookOrderProducer) {
        this.kafkaBookOrderProducer = kafkaBookOrderProducer;
    }

    @PostMapping(path = "/addmsg", consumes="application/json")
    public Book addMsg(@RequestBody Book book) {
        log.info("Received request to add message");
        kafkaBookOrderProducer.produceBookOrder(book);
        log.info("Message added");
        return book;
    }
}


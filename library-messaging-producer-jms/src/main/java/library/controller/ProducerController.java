package library.controller;

import library.entities.Book;
import library.producer.jms.JmsBookOrderProducer;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path="/messaging",produces="application/json")
@CrossOrigin(origins="*")
public class ProducerController {

    private JmsBookOrderProducer jmsBookOrderProducer;

    public ProducerController(JmsBookOrderProducer jmsBookOrderProducer) {
        this.jmsBookOrderProducer = jmsBookOrderProducer;
    }

    @PostMapping(path = "/addmsg", consumes="application/json")
    @ResponseStatus(HttpStatus.CREATED)
    public Book addMsg(@RequestBody Book book) {
        jmsBookOrderProducer.produceBookOrder(book);
        return book;
    }
}


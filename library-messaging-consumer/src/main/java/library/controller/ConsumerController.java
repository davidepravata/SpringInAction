package library.controller;

import library.consumer.jms.JmsBookOrderConsumer;
import library.entities.Book;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RequestMapping(path="/messaging",produces="application/json")
@CrossOrigin(origins="*")
public class ConsumerController {

    private JmsBookOrderConsumer jmsBookOrderConsumer;

    public ConsumerController(JmsBookOrderConsumer jmsBookOrderConsumer) {
        this.jmsBookOrderConsumer = jmsBookOrderConsumer;
    }

    @GetMapping(path = "/receivemsg")
    @ResponseStatus(HttpStatus.OK)
    public Book addMsg(@RequestBody Book book) {

        jmsBookOrderConsumer.receiveBookOrder();
        return book;
    }
}

package library.controller;

import library.consumer.jms.JmsBookOrderConsumer;
import library.consumer.jms.listener.JmsConsumerListener;
import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping(path="/messaging",produces="application/json")
@RestController
@CrossOrigin(origins="*")
public class JmsConsumerController {

    private JmsBookOrderConsumer jmsBookOrderConsumer;

    public JmsConsumerController(JmsBookOrderConsumer jmsBookOrderConsumer) {
        this.jmsBookOrderConsumer = jmsBookOrderConsumer;
    }

    @GetMapping(path = "/receivejmsmsg")
    @ResponseStatus(HttpStatus.OK)
    public Book receiveMsg() {
        log.info("Invoking jms to verify if message has been received");
        Book book = (Book)jmsBookOrderConsumer.receiveBookOrder();
        return book;
    }


}

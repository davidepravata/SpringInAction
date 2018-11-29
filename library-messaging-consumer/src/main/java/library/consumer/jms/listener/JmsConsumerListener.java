package library.consumer.jms.listener;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JmsConsumerListener {
    //@JmsListener(destination = "library-books-artemis-queue")
    public void receiveBookOrder(Book book) {
        log.info("Listener Book received[" + book + "]");
    }

}

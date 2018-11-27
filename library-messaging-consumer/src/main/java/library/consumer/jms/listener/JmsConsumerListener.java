package library.consumer.jms.listener;

import library.consumer.jms.BookOrderConsumer;
import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.jms.DefaultJmsListenerContainerFactoryConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.stereotype.Component;

import javax.jms.ConnectionFactory;

@Slf4j
@Component
public class JmsConsumerListener {
    @JmsListener(destination = "library-books-queue")
    public void receiveBookOrder(Book book) {
        log.info("Listener Book received[" + book + "]");
    }

}

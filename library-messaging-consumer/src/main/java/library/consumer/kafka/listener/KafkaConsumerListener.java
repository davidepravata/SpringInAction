package library.consumer.kafka.listener;

import library.entities.Book;
import library.entities.serialized.SerializedBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaConsumerListener {
    @KafkaListener(topics = "library-books-kafka-topic")
    public void receiveBookOrder(SerializedBook serializedBook) {
        Book book = serializedBook.getBook(serializedBook);
        log.info("Listener Book received[" + book + "]");
    }

}

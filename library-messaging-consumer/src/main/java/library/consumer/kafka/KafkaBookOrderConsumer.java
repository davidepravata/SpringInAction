package library.consumer.kafka;

import library.consumer.BookOrderConsumer;
import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class KafkaBookOrderConsumer implements BookOrderConsumer {

  private JmsTemplate jms;

  public KafkaBookOrderConsumer(JmsTemplate jms) {
    this.jms = jms;
  }
  
  @Override
  public Book receiveBookOrder() {
    log.info("Message Received on JMS");
    Book receivedBook=(Book) jms.receiveAndConvert("library-books-kafka-topic");
    log.info("Book Received[" + receivedBook + "]");
    return receivedBook;
  }
  
}

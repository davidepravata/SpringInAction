package library.consumer.jms;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Slf4j
//@Profile("library.consumer.jms-template")
@Component//("templateBooksOrderReceiver")
public class JmsBookOrderConsumer implements BookOrderConsumer {

  private JmsTemplate jms;

  public JmsBookOrderConsumer(JmsTemplate jms) {
    this.jms = jms;
  }
  
  @Override
  public Book receiveBookOrder() {
    log.info("Message Received on JMS");
    Book receivedBook=(Book) jms.receiveAndConvert("library-books-queue");
    log.info("Book Received[" + receivedBook + "]");
    return receivedBook;
  }
  
}

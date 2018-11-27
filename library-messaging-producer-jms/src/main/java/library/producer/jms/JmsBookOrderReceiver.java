package library.producer.jms;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Profile("library.consumer.jms-template")
@Component("templateBooksOrderReceiver")
public class JmsBookOrderReceiver implements BookOrderReceiver {

  private JmsTemplate jms;

  public JmsBookOrderReceiver(JmsTemplate jms) {
    this.jms = jms;
  }
  
  @Override
  public Book receiveBookOrder() {
    log.info("Message Received on JMS");

    return (Book) jms.receiveAndConvert("library.books.queue");
  }
  
}

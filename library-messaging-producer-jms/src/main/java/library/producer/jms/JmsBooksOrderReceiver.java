package library.producer.jms;

import library.entities.Books;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;


@Slf4j
@Profile("library.consumer.jms-template")
@Component("templateBooksOrderReceiver")
public class JmsBooksOrderReceiver implements BooksOrderReceiver {

  private JmsTemplate jms;

  public JmsBooksOrderReceiver(JmsTemplate jms) {
    this.jms = jms;
  }
  
  @Override
  public Books receiveBooksOrder() {
    log.info("Message Received on JMS");

    return (Books) jms.receiveAndConvert("library.books.queue");
  }
  
}

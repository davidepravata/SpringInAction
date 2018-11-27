package library.consumer.jms;

import library.entities.Book;
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
  public Book receiveBooksOrder() {
    log.info("Message Received on JMS");
    return (Book) jms.receiveAndConvert("library.books.queue");
  }
  
}

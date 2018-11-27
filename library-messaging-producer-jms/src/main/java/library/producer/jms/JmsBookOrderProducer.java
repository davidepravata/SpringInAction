package library.producer.jms;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;


@Slf4j
//@Profile("library.consumer.jms-template")
@Component//("templateBooksOrderReceiver")
public class JmsBookOrderProducer implements BookOrderProducer {

  private JmsTemplate jms;

  public JmsBookOrderProducer(JmsTemplate jms) {
    this.jms = jms;
  }
  
  @Override
  public void produceBookOrder(Book book) {
    log.info("Going to produce message on JMS");
    jms.convertAndSend(book);
  }
  
}

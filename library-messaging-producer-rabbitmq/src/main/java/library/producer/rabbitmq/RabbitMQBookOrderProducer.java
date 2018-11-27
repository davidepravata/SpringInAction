package library.producer.rabbitmq;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
//@Profile("library.consumer.jms-template")
@Component//("templateBooksOrderReceiver")
public class RabbitMQBookOrderProducer implements BookOrderProducer {

//  private JmsTemplate jms;

//  public RabbitMQBookOrderProducer(JmsTemplate jms) {
//    this.jms = jms;
//}
  
  @Override
  public void produceBookOrder(Book book) {
    log.info("Going to produce message on JMS");
    //   jms.convertAndSend("library-books-queue",book);
    log.info("All seems ok");
  }
  
}

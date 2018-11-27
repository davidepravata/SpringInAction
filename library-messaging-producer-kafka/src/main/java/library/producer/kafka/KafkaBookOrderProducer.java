package library.producer.kafka;

import library.entities.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
//@Profile("library.consumer.jms-template")
@Component//("templateBooksOrderReceiver")
public class KafkaBookOrderProducer implements BookOrderProducer {

//  private JmsTemplate jms;

//  public KafkaBookOrderProducer(JmsTemplate jms) {
//    this.jms = jms;
//  }
  
  @Override
  public void produceBookOrder(Book book) {
    log.info("Going to produce message on JMS");
    //   jms.convertAndSend("library-books-queue",book);
    log.info("All seems ok");
  }
  
}

package library.producer.kafka;

import library.entities.Book;
import library.entities.serialized.SerializedBook;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Service
public class KafkaBookOrderProducer implements BookOrderProducer {

    private KafkaTemplate<String, SerializedBook> kafkaTemplate;

    @Autowired
    public KafkaBookOrderProducer(KafkaTemplate<String, SerializedBook> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @Override
    public void produceBookOrder(Book book) {
        kafkaTemplate.send("library-books-kafka-topic", new SerializedBook(book));
    }
}
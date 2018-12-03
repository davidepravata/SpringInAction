package library.inputchannel;

import library.entities.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@MessagingGateway(defaultRequestChannel="books")
@Service
public interface InputChannel {

    List<Book> readInput();

}
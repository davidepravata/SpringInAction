package library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class LibraryConsumerApp implements WebMvcConfigurer {

	public static void main(String[] args) {
		SpringApplication.run(LibraryConsumerApp.class, args);
	}

}

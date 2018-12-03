package library.integration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.MessageChannels;
import org.springframework.integration.file.dsl.Files;
import org.springframework.integration.file.support.FileExistsMode;

import java.io.File;

@Configuration
public class BooksIntegrationConfig {
    @Bean
    public IntegrationFlow getIntegrationFlow() {
        return IntegrationFlows
                .from(MessageChannels.direct("books"))
                .handle(Files
                    .outboundAdapter(new File("C://Users/david/Desktop/test2"))
                    .fileExistsMode(FileExistsMode.APPEND)
                    .appendNewLine(true))
                .get();
    }
}

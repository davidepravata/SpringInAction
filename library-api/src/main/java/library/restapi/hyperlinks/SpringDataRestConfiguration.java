package library.restapi.hyperlinks;

import library.entities.Book;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;


@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public ResourceProcessor<PagedResources<Resource<Book>>>
    BooksProcessor(EntityLinks links) {

        return new ResourceProcessor<PagedResources<Resource<Book>>>() {
            @Override
            public PagedResources<Resource<Book>> process(PagedResources<Resource<Book>> resource) {
                resource.add(links.linkFor(Book.class).slash("booksapi").slash("mostexpensive").withRel("mostexpensive"));
                return resource;
            }
        };
    }

}

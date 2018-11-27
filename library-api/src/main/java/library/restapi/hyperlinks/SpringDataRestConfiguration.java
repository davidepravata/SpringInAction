package library.restapi.hyperlinks;

import library.entities.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.PagedResources;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.ResourceProcessor;


@Configuration
public class SpringDataRestConfiguration {

    @Bean
    public ResourceProcessor<PagedResources<Resource<Books>>>
    BooksProcessor(EntityLinks links) {

        return new ResourceProcessor<PagedResources<Resource<Books>>>() {
            @Override
            public PagedResources<Resource<Books>> process(PagedResources<Resource<Books>> resource) {
                resource.add(links.linkFor(Books.class).slash("booksapi").slash("mostexpensive").withRel("mostexpensive"));
                return resource;
            }
        };
    }

}

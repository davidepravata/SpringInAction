package library.restapi.hyperlinks;

import library.entities.Book;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BooksResourceAssembler extends ResourceAssemblerSupport<Book, BooksResource> {

    public BooksResourceAssembler() {
        super(RestAPIBooksControllerWithHyperLinks.class, BooksResource.class);
    }

    @Override
    protected BooksResource instantiateResource(Book book) {
        return new BooksResource(book);
    }

    @Override
    public BooksResource toResource(Book book) {
        return createResourceWithId(book.getId(), book);
    }

}

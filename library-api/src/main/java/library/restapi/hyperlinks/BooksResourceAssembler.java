package library.restapi.hyperlinks;

import library.entities.Books;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class BooksResourceAssembler extends ResourceAssemblerSupport<Books, BooksResource> {

    public BooksResourceAssembler() {
        super(RestAPIBooksControllerWithHyperLinks.class, BooksResource.class);
    }

    @Override
    protected BooksResource instantiateResource(Books book) {
        return new BooksResource(book);
    }

    @Override
    public BooksResource toResource(Books book) {
        return createResourceWithId(book.getId(), book);
    }

}

package library.restapi.hyperlinks;

import org.springframework.hateoas.Resources;

import java.util.List;

public class BooksResources extends Resources<BooksResource> {
  public BooksResources(List<BooksResource> booksResources) {
    super(booksResources);
  }
}
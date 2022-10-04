package igoraguiar.com.github.Bookstore.repository;

import igoraguiar.com.github.Bookstore.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}

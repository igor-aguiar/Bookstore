package igoraguiar.com.github.Bookstore.repository;

import igoraguiar.com.github.Bookstore.model.Author;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

}

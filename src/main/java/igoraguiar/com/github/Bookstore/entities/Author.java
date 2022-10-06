package igoraguiar.com.github.Bookstore.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "author", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> books = new ArrayList<>();

    public Author() {
    }

    public Author(String name, List<Book> books) {
        this.name = name;
        this.books = books;
    }

    public Author(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }

    public void setBooks(Book book) {
        book.setAuthor(this);
        this.books.add(book);
    }

    @Override
    public String toString() {
        authorBooks();
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public void authorBooks(){
        if (books.isEmpty()){
            System.out.println("No books registered of this author");
        } else {
            StringBuilder sb = new StringBuilder();
            books.forEach(book -> sb.append(book).append("\n"));
            System.out.println(sb.toString());
        }
    }
}

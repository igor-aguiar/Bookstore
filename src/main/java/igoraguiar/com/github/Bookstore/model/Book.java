package igoraguiar.com.github.Bookstore.model;

import javax.persistence.*;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private Integer numberOfPages;

    @ManyToOne
    private Author author;

    public Book() {
    }

    public Book(String bookName, Integer numberOfPages) {
        this.numberOfPages = numberOfPages;
        this.title = bookName;
    }

    public Book(String title, Integer numberOfPages, Author author) {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.author = author;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(int numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", numberOfPages=" + numberOfPages +
                '}';
    }
}

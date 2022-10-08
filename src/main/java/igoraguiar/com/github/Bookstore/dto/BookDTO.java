package igoraguiar.com.github.Bookstore.dto;

import igoraguiar.com.github.Bookstore.model.Book;

public class BookDTO {
    private String bookTitle;
    private String numberOfPages;

    public BookDTO() {
    }

    public BookDTO(String bookTitle, String numberOfPages) {
        this.bookTitle = bookTitle;
        this.numberOfPages = numberOfPages;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getNumberOfPages() {
        return numberOfPages;
    }

    public void setNumberOfPages(String numberOfPages) {
        this.numberOfPages = numberOfPages;
    }

    public Book toBook(){
        return new Book(this.bookTitle, Integer.parseInt(this.numberOfPages));
    }
}

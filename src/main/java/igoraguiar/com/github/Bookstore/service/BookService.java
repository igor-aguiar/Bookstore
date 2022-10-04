package igoraguiar.com.github.Bookstore.service;

import igoraguiar.com.github.Bookstore.entities.Book;
import igoraguiar.com.github.Bookstore.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class BookService {
    private final BookRepository bookRepository;
    private Boolean system = true;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void start(Scanner sc){
        while(system){

            System.out.println("Select your operation: ");
            System.out.println("0 - exit");
            System.out.println("1 - Insert new book");
            System.out.println("2 - Update book");
            int opt = sc.nextInt();
            switch (opt) {
                case 1 -> {
                    insert(sc);
                    break;
                }
                case 2 -> {
                    update(sc);
                    break;
                }
                default -> {
                    System.out.println("Exiting system");
                    system = false;
                    break;
                }
            }
        }
    }
    public void insert(Scanner sc){
        System.out.println("Name of the book: ");
        String bookName = sc.next();
        System.out.println("Number of pages: ");
        int numberOfPages = sc.nextInt();

        Book book = new Book(bookName, numberOfPages);
        bookRepository.save(book);

        System.out.println("Book saved into database");
    }

    public void update(Scanner sc){
        bookRepository.findAll().forEach(System.out::println);

        System.out.println("insert the book id you want to change data: ");
        int bookId = sc.nextInt();
        Book book = bookRepository.findById(bookId).get();

        System.out.println("Insert what data you want to change, Title or Number of Pages [1/2]: ");
        String opt = sc.next();
        if (Integer.parseInt(opt) == 1){
            System.out.println("Insert new title: ");
            book.setTitle(sc.next());
        } else if (Integer.parseInt(opt) == 2){
            System.out.println("Insert new number of pages: ");
            int newNumberOfPages = sc.nextInt();
            book.setNumberOfPages(newNumberOfPages);
        }

        bookRepository.save(book);
    }
}

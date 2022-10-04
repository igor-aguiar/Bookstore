package igoraguiar.com.github.Bookstore;

import igoraguiar.com.github.Bookstore.entities.Book;
import igoraguiar.com.github.Bookstore.repository.BookRepository;
import igoraguiar.com.github.Bookstore.service.BookService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class BookstoreApplication implements CommandLineRunner {
	private final BookService bookService;
	private boolean system = true;

	public BookstoreApplication(BookService bookService) {
		this.bookService = bookService;
	}

	public static void main(String[] args) {
		SpringApplication.run(BookstoreApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		int option;
		while(system){
			System.out.println("Select the option: ");
			System.out.println("0 - Exit");
			System.out.println("1 - Book");
			System.out.println();
			option = sc.nextInt();

			switch (option) {
				case 1 -> {
					bookService.start(sc);
					break;
				}
				case 2 -> {
					break;
				}
				default -> {
					system = false;
					break;
				}
			}
		}
	}
}

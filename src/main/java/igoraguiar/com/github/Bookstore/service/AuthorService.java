package igoraguiar.com.github.Bookstore.service;

import igoraguiar.com.github.Bookstore.model.Author;
import igoraguiar.com.github.Bookstore.repository.AuthorRepository;
import org.springframework.stereotype.Service;

import java.util.Scanner;

@Service
public class AuthorService {
    private Boolean system = true;

    private AuthorRepository authorRepository;

    public AuthorService(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    public void initialize(Scanner sc){
        while (system){
            System.out.println("Select what operation you want: ");
            System.out.println("0 - Exit");
            System.out.println("1 - Create Author");
            System.out.println("2 - Edit Author");
            System.out.println("3 - Visualize Author");
            System.out.println("4 - Delete Author");
            int opt = sc.nextInt();
            switch(opt){
                case 1 -> {
                    create(sc);
                }
                case 2 -> {
                    edit(sc);
                }
                case 3 -> {
                    visualize(sc);
                }
                case 4 -> {
                    delete(sc);
                }
                default -> {
                    System.out.println("Exiting Authors");
                    system = false;
                    break;
                }
            }
        }
    }

    private void delete(Scanner sc) {
        visualize(sc);
        System.out.println("Select the id of the Author you want to delete: ");
        int authorId = sc.nextInt();
        authorRepository.deleteById(authorId);
    }

    private void visualize(Scanner sc) {
        authorRepository.findAll().forEach(System.out::println);
    }

    private void edit(Scanner sc) {
        visualize(sc);
        System.out.println("Select the id of the Author you want to delete: ");
        int authorId = sc.nextInt();
        Author author = authorRepository.findById(authorId).get();
        System.out.println("Type the author new name: ");
        String newName = sc.next();
        author.setName(newName);
        authorRepository.save(author);
    }

    private void create(Scanner sc) {
        System.out.println("Author name: ");
        String name = sc.next();
        authorRepository.save(new Author(name));
    }
}

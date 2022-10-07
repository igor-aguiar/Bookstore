package igoraguiar.com.github.Bookstore.controller;

import igoraguiar.com.github.Bookstore.model.Book;
import igoraguiar.com.github.Bookstore.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class FirstController {
    private final BookRepository bookRepository;

    public FirstController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/book/record")
    public ModelAndView recordBook(Model model){
        List<Book> books = (List<Book>) bookRepository.findAll();
        ModelAndView mv = new ModelAndView("produto/recordBook");
        mv.addObject("books", books);
        return mv;
    }
}

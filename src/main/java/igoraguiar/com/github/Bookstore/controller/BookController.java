package igoraguiar.com.github.Bookstore.controller;

import igoraguiar.com.github.Bookstore.dto.BookDTO;
import igoraguiar.com.github.Bookstore.model.Book;
import igoraguiar.com.github.Bookstore.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("book")
public class BookController {
    @Autowired
    BookRepository bookRepository;

    @GetMapping("form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("produto/register");
        return mv;
    }

    @PostMapping("register")
    public ModelAndView register(BookDTO bookDto){
        Book book = bookDto.toBook();
        bookRepository.save(book);
        ModelAndView mv = new ModelAndView("produto/showBooks");
        return mv;
    }
}

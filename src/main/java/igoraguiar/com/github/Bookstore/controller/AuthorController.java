package igoraguiar.com.github.Bookstore.controller;

import igoraguiar.com.github.Bookstore.dto.AuthorDTO;
import igoraguiar.com.github.Bookstore.model.Author;
import igoraguiar.com.github.Bookstore.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("author")
public class AuthorController {

    AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @GetMapping("list")
    public ModelAndView list(){
        ModelAndView mv = new ModelAndView("author/list");
        mv.addObject("authors", authorRepository.findAll());
        return mv;
    }

    @GetMapping("form")
    public ModelAndView form(){
        ModelAndView mv = new ModelAndView("author/register");
        return mv;
    }

    @PostMapping("register")
    public ModelAndView register(AuthorDTO authorDTO){
        Author author = authorDTO.toAuthor();
        authorRepository.save(author);
        ModelAndView mv = new ModelAndView("author/list");
        mv.addObject("authors",authorRepository.findAll());
        return mv;
    }
}

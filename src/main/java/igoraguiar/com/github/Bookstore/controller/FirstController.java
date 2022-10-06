package igoraguiar.com.github.Bookstore.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hello")
    public String hello(){
        return "hello";
    }

    @GetMapping("/book/record")
    public String recordBook(){
        return "produto/recordBook";
    }
}

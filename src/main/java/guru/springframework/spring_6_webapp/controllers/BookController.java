package guru.springframework.spring_6_webapp.controllers;

import guru.springframework.spring_6_webapp.services.BookServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class BookController {
    private final BookServices bookServices;

    @RequestMapping("/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookServices.findAll());
        return "books";
    }
}

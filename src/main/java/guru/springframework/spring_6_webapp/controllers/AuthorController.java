package guru.springframework.spring_6_webapp.controllers;

import guru.springframework.spring_6_webapp.services.AuthorServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@AllArgsConstructor
public class AuthorController {
    private final AuthorServices authorServices;

    @RequestMapping("/authors")
    public String getAuthors(Model model) {
        model.addAttribute("authors", authorServices.findAll());
        return "authors";
    }
}

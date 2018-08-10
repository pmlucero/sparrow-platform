package ar.com.zumma.sparrowplatform.controller;

import ar.com.zumma.sparrowplatform.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/users")
@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"","/index", "/index.html"})
    public String listOf(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }
}

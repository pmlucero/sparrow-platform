package ar.com.zumma.sparrowplatform.controller.in;

import ar.com.zumma.sparrowplatform.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping({"/users","/users/index", "/users/index.html"})
    public String listOf(Model model) {
        model.addAttribute("users", userService.findAll());
        return "users/index";
    }
}

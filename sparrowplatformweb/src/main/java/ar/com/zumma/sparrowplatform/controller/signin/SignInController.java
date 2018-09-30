package ar.com.zumma.sparrowplatform.controller.signin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SignInController {

    @RequestMapping("/sign-in")
    public String getSignIn(Model model){
        return "authentication/signin";
    }

}

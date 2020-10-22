package uhk.fim.toolsrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class MembershipController {

    @GetMapping("/login")
    public String login(){
        return "login";
    }
    @GetMapping("/logout")
    public String logout(){
        return null;
    }
    @GetMapping("/register")
    public String register(){
        return null;
    }

}

package uhk.fim.toolsrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @GetMapping("")
    @ResponseBody
    public String index(){
        return "Hello from Home Page bro!";
    }

}

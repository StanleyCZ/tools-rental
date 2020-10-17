package uhk.fim.toolsrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.ServletRequest;

@Controller
public class HomeController {

    @GetMapping("")
    @ResponseBody
    public String index(){
        return "Hello from Home Page bro!";
    }

    @GetMapping("/test")
    @ResponseBody
    public String test(ServletRequest req){
        return "Test method" + req.getRemoteHost();
    }



}

package uhk.fim.toolsrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import uhk.fim.toolsrental.models.dto.RegistrationDto;
import uhk.fim.toolsrental.services.UserService;

import javax.validation.Valid;


@Controller
public class MembershipController {


    private UserService userService;

    public MembershipController(UserService userService){
        this.userService = userService;
    }


    @GetMapping("/login")
    public String login(){
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model){

        RegistrationDto registrationDto = new RegistrationDto();
        model.addAttribute("user", registrationDto);

        return "registration";
    }
    @PostMapping("/register")
    public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid RegistrationDto regDto){

        userService.registerNewUser(regDto);

        return new ModelAndView("index");

    }

}

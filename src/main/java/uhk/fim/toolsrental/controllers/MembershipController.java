package uhk.fim.toolsrental.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
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
    public String registerUserAccount(
                    @ModelAttribute("user") @Valid RegistrationDto regDto,
                    BindingResult res,
                    RedirectAttributes ras){

        if(res.hasErrors()){
            return "registration";
        }
        userService.registerNewUser(regDto);

        return "redirect:/index";

    }

}

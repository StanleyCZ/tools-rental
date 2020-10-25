package uhk.fim.toolsrental.services;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import uhk.fim.toolsrental.models.User;
import uhk.fim.toolsrental.models.dto.RegistrationDto;


public interface IUserService extends UserDetailsService {

    User registerNewUser(RegistrationDto registrationDto);

}

package uhk.fim.toolsrental.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import uhk.fim.toolsrental.models.Role;
import uhk.fim.toolsrental.models.User;
import uhk.fim.toolsrental.models.dto.RegistrationDto;
import uhk.fim.toolsrental.repos.UserRepository;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Collectors;

@Service
public class UserService implements IUserService {

    @Autowired
    private BCryptPasswordEncoder pwdEncoder;
    private UserRepository userRepo;


    public UserService(UserRepository userRepo){
        super();
        this.userRepo = userRepo;
    }

    @Override
    public User registerNewUser(RegistrationDto registrationDto) {
        User user = new User(
                registrationDto.getFirstName(),
                registrationDto.getLastName(),
                registrationDto.getEmail(),
                pwdEncoder.encode(registrationDto.getPassword()),
                registrationDto.getPhoneNumber(), Arrays.asList(new Role(registrationDto.getRole())));

        return userRepo.save(user);
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User dbUser = userRepo.findByEmail(s);

        if(dbUser == null)
            throw new UsernameNotFoundException("User with given email does not exists");

        org.springframework.security.core.userdetails.User u = new org.springframework.security.core.userdetails.User(
                dbUser.getEmail(),
                dbUser.getPassword(),
                mapRolesToAuthorities(dbUser.getRoles()));
        return u;
    }
    private Collection<? extends GrantedAuthority> mapRolesToAuthorities(Collection<Role> roles){
        return roles.stream().map(role ->
                new SimpleGrantedAuthority(
                        role.getName())).collect(Collectors.toList());
    }
}

package uhk.fim.toolsrental;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.models.Role;
import uhk.fim.toolsrental.models.User;
import uhk.fim.toolsrental.models.dto.RegistrationDto;
import uhk.fim.toolsrental.repos.CategoryRepository;
import uhk.fim.toolsrental.repos.RoleRepository;
import uhk.fim.toolsrental.services.UserService;

import javax.persistence.EntityManager;
import java.util.Optional;


@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

    @Test
    public void empty(){

    }

    @Autowired
    private CategoryRepository categoryRepo;
    @Autowired
    private RoleRepository roleRepo;
    @Autowired
    private UserService userService;


    /*@Test
    public void insertRoles() {
        Role adminRole = new Role();
        adminRole.setName("ROLE_ADMIN");
        roleRepo.save(adminRole);
        Role userRole = new Role();
        userRole.setName("ROLE_USER");
        roleRepo.save(userRole);
        Role emplRole = new Role();
        emplRole.setName("ROLE_EMPL");
        roleRepo.save(emplRole);
    }*/
    /*@Test
    public void insertUsers(){
        RegistrationDto adminDto = new RegistrationDto();
        adminDto.setFirstName("Vašík");
        adminDto.setLastName("Pašík");
        adminDto.setEmail("admin@email.cz");
        adminDto.setPassword("admin123");
        userService.registerNewUser(adminDto);

        RegistrationDto emplDto = new RegistrationDto();
        emplDto.setFirstName("Hugo");
        emplDto.setLastName("Vyhňoucal");
        emplDto.setEmail("empl@email.cz");
        emplDto.setPassword("empl123");
        userService.registerNewUser(emplDto);

        RegistrationDto userDto = new RegistrationDto();
        userDto.setFirstName("Venca");
        userDto.setLastName("Vemtočert");
        userDto.setEmail("user@email.cz");
        userDto.setPassword("user123");
        userService.registerNewUser(userDto);


    }*/

}

package uhk.fim.toolsrental;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import uhk.fim.toolsrental.models.Role;

import java.util.Optional;


//@RunWith(SpringRunner.class)
@SpringBootTest
public class RepositoryTests {

    @Test
    public void empty(){

    }
    /*
    @Autowired
    private IRoleRepository roleRepo;


    @Test
    public void insertNewRoleToDatabase() {

        Role testRole = new Role("TESTER-3");
        testRole.setDescription("Toto je pouze testovací role");
        Role savedRole = roleRepo.save(testRole);

        Optional<Role> dbRole = roleRepo.findById(savedRole.getId());

        dbRole.get().setDescription("Popis, ktery by mel zmenit updatetime..");
        savedRole = roleRepo.save(dbRole.get());

        Assert.assertNotNull(savedRole.getId());
    }
*/
}

package uhk.fim.toolsrental.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uhk.fim.toolsrental.models.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {

    User findByEmail(String email);

}

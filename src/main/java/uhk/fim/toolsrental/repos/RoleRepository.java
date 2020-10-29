package uhk.fim.toolsrental.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uhk.fim.toolsrental.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}

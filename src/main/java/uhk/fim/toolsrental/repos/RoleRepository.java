package uhk.fim.toolsrental.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import uhk.fim.toolsrental.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {

    @Query("SELECT r from Role r where r.name = :name")
    Role findByName(@Param("name") String roleName);

}

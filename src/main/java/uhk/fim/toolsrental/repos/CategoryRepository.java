package uhk.fim.toolsrental.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uhk.fim.toolsrental.models.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {


}

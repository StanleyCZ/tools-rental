package uhk.fim.toolsrental.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uhk.fim.toolsrental.models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

}

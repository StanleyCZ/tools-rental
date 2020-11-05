package uhk.fim.toolsrental.services;

import org.springframework.stereotype.Service;
import uhk.fim.toolsrental.models.Product;
import uhk.fim.toolsrental.repos.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;

    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }


    public Product saveProduct(Product p){
        //TODO
        return null;
    }

}

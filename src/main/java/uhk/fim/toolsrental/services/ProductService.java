package uhk.fim.toolsrental.services;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.models.Product;
import uhk.fim.toolsrental.repos.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepo;
    private CategoryService categoryService;

    public ProductService(ProductRepository productRepo){
        this.productRepo = productRepo;
    }

    public List<Product> getAll(){
        return productRepo.findAll();
    }


    public Product saveProduct(Product p){

        Product product = new Product(
                p.getName(),
                p.getCost(),
                p.getTotalAmount()
        );
        product.setPicture(p.getPicture());
        product.setCategory(p.getCategory());
        product.setDescription(p.getDescription());
        //product.setFreeAmount(p.getTotalAmount());

        return productRepo.save(product);
    }

}

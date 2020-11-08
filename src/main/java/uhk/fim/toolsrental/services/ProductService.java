package uhk.fim.toolsrental.services;

import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.models.Product;
import uhk.fim.toolsrental.repos.ProductRepository;
import uhk.fim.toolsrental.utils.AppHelper;

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

    public Product getById(Long id){return  productRepo.getOne(id);}

    public Product saveProduct(Product p){

        //pokud produkt neexistuje v db
        if(p.getId() == null){
            //nastav product code
            p.setCode(AppHelper.generateProductCode());
            //nastav dostupne mnozstvi stejne jako je celkovy pocet produktu
            p.setFreeAmount(p.getTotalAmount());
        }
        return  productRepo.save(p);
    }

}

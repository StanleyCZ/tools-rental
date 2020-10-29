package uhk.fim.toolsrental.services;

import org.springframework.stereotype.Service;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.repos.CategoryRepository;
import java.util.List;


@Service
public class CategoryService {

    private final CategoryRepository categoryRepo;

    public CategoryService(CategoryRepository categoryRepository){
        this.categoryRepo = categoryRepository;
    }

    public List<Category> getAllCategories(){
        return categoryRepo.findAll();
    }

    public Category save(Category category){

        return categoryRepo.save(category);
    }
    public Category getById(Long id){
        return categoryRepo.getOne(id);
    }


}

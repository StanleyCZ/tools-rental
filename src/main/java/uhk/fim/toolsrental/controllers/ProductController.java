package uhk.fim.toolsrental.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.models.Product;
import uhk.fim.toolsrental.services.CategoryService;

import java.util.List;

@Controller
@RequestMapping(value = "/product")
public class ProductController {

    private final CategoryService catService;

    public ProductController(CategoryService categoryService){
        this.catService = categoryService;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/new")
    public String newProduct(Model model){

        Product product = new Product();
        List<Category> categories = catService.getAllCategories();
        model.addAttribute("product",product);
        model.addAttribute("categories",categories);

        return "newProduct";
    }

}

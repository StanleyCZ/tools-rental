package uhk.fim.toolsrental.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.models.Product;
import uhk.fim.toolsrental.services.CategoryService;
import uhk.fim.toolsrental.services.FileService;
import uhk.fim.toolsrental.services.ProductService;
import uhk.fim.toolsrental.utils.AppHelper;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Controller
public class ProductController {

    private final CategoryService catService;
    private final ProductService productService;

    public ProductController(CategoryService categoryService, ProductService productService){
        this.catService = categoryService;
        this.productService = productService;
    }

    //@PreAuthorize("hasAnyAuthority('ADMIN','EMPL')")
    @GetMapping("/admin/products")
    public String adminProductList(Model model){

        List<Product> products = productService.getAll();
        model.addAttribute("products",products);
        return "admin/listProducts";
    }

    //@PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("admin/product/new")
    public String newProductForm(Model model){
        Product product = new Product();
        model.addAttribute("product",product);
        model.addAttribute("categories",getCategorySelectList());
        return "admin/newProduct";
    }
    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("admin/product/save")
    public String saveProductForm(@Valid @ModelAttribute("product") Product product,
                                  BindingResult binding,
                                  @RequestParam("productImage") MultipartFile file) throws IOException {
        if(binding.hasErrors())
            return "admin/newProduct";

        Product savedProduct = productService.saveProduct(product);
        if(!file.isEmpty()){
            String filePath = FileService.saveProductImage(file,savedProduct);
            savedProduct.setImage(filePath);
            productService.saveProduct(savedProduct);
        }

        return "redirect:/admin/product/"+savedProduct.getId();
    }

    //@PreAuthorize("hasAnyAuthority('ADMIN','EMPL')")
    @GetMapping("/admin/product/{id}")
    public String getAdminProductDetail(@PathVariable(name = "id") long id, Model model){
        Product p = productService.getById(id);
        model.addAttribute("product",p);
        model.addAttribute("categories",getCategorySelectList());

        return "admin/detailProduct";
    }

    private Map<Long,String> getCategorySelectList(){
        return catService.getAllCategories().stream().collect(Collectors.toMap(Category::getId,Category::getName));
    }

}

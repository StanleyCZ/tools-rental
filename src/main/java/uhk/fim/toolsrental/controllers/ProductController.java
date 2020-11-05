package uhk.fim.toolsrental.controllers;


import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.models.Product;
import uhk.fim.toolsrental.services.CategoryService;
import uhk.fim.toolsrental.services.ProductService;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
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
        product.setCost(500.f);
        Map<Long,String> categorySelectList = catService.getAllCategories()
                .stream()
                .collect(Collectors.toMap(Category::getId,Category::getName));
        model.addAttribute("product",product);
        model.addAttribute("categories",categorySelectList);
        return "admin/newProduct";
    }
    //@PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("admin/product/save")
    public String saveProductForm(@Valid @ModelAttribute("product") Product product,
                                  BindingResult bres,
                                  @RequestParam("productImage") MultipartFile file) throws IOException {
        /*if(bres.hasErrors())
            return "admin/newProduct";
*/
        //TODO setCategory aby to nebralo konstnti
        product.setCategory(catService.getById(1L));
        String filename = StringUtils.cleanPath(file.getOriginalFilename());
        product.setPicture(filename);
        Product savedProduct = productService.saveProduct(product);
        String uploadDir = "./product-files/" + savedProduct.getId();
        Path uploadPath = Paths.get(uploadDir);

        if (!Files.exists(uploadPath)) {
            Files.createDirectories(uploadPath);
        }

        try (InputStream inputStream = file.getInputStream()) {
            Path filePath = uploadPath.resolve(filename);
            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            throw new IOException("Nelze ulozit soubor: " + filename);
        }


        /*
         * TODO
         * Uložit produkt (vytvořit metodu v ProductService)
         * ** Nejspíš to bude chtít ještě vytáhnout z db zvolenou kategorii podle ID
         * ** a přiřadit jí tomu produktu, než se uloží do db
         * Pokud je nahraný obrázek, uložit ho do nějaké foldery
         *
         * */
        //TODO vytvořit pohled detailProduct
        //return "redirect:/admin/product/detail/"; //TODO + id nově vytvořeného produktu

        return "admin/newProduct";
    }

}

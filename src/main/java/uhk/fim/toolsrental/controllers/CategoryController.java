package uhk.fim.toolsrental.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import uhk.fim.toolsrental.models.Category;
import uhk.fim.toolsrental.services.CategoryService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class CategoryController {

    private final CategoryService catService;

    public CategoryController(CategoryService cs){
        this.catService = cs;
    }

    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("admin/category/new")
    public String newCategory(Model model){
        Category category = new Category();
        model.addAttribute("category",category);
        return "admin/newCategory";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping("/admin/category/save")
    public String saveCategory(@Valid @ModelAttribute("category") Category category, BindingResult br){

        if(br.hasErrors()){
            if(category.getId() == null)
                return "admin/newCategory";
            return "admin/detailCategory";
        }
        Category savedCategory = catService.save(category);
        return "redirect:/admin/category/detail/" + savedCategory.getId();
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/admin//category/detail/{id}")
    public String detail(@PathVariable(name = "id") long id, Model model){

        /*Optional<Category> oc = catService.getById(id);
        if(!oc.isPresent()){
            return "redirect:/404";
        }*/
        Category c = catService.getById(id);//oc.get();
        model.addAttribute("category",c);
        return "admin/detailCategory";
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @GetMapping("admin/categories")
    public String listOfCategories(Model model){
        List<Category> categories = catService.getAllCategories();
        model.addAttribute("categories",categories);
        return "admin/listCategories";
    }
}

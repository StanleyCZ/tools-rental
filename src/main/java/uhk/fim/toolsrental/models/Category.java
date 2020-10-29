package uhk.fim.toolsrental.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Collection;
import java.util.List;

@Entity
public class Category extends ContentBase{
    @NotBlank(message = "Název kategorie musí být vyplněn")
    private String name;

    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> products;


    public Category(){

    }

    public Category(@NotBlank String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

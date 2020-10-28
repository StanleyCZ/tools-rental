package uhk.fim.toolsrental.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Category extends MyContentBase{
    @NotBlank
    private String name;

    private String description;

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
}

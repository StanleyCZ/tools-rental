package uhk.fim.toolsrental.models;

import javax.persistence.Entity;
import javax.validation.constraints.NotBlank;

@Entity
public class Role extends ContentBase {

    @NotBlank
    private String name;
    private String description;


    public Role(){

    }
    public Role(String name){
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

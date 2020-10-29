package uhk.fim.toolsrental.models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Set;

@Entity
public class Role extends ContentBase {

    @NotBlank
    private String name;
    private String description;
    private static String ADMIN ="ADMIN";
    private static String ZAMESTNANEC ="EMPL";
    private static String ZAKAZNIK ="USER";

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

    public static String getADMIN() {
        return ADMIN;
    }

    public static String getZAMESTNANEC() {
        return ZAMESTNANEC;
    }

    public static String getZAKAZNIK() {
        return ZAKAZNIK;
    }
}


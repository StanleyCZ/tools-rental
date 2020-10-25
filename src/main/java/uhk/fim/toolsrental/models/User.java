package uhk.fim.toolsrental.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import java.util.Collection;
import java.util.Set;


@Entity(name = "AppUser")
@Table(name = "AppUser", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class User extends ContentBase {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @ManyToMany(targetEntity = Role.class, fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(
            name = "UserRoles",
            joinColumns = @JoinColumn(name = "UserId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "RoleId", referencedColumnName = "id") )
    private Collection<Role> roles;

    @Size(min = 6)
    @NotBlank
    private String password;

    public User(){

    }
    public User(String firstName, String lastName, String email,@Size(min = 6) @NotBlank String password, String phone, Collection<Role> roles) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.roles = roles;

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Role> getRoles() {
        return roles;
    }

    public void setRoles(Collection<Role> roles) {
        this.roles = roles;
    }

}

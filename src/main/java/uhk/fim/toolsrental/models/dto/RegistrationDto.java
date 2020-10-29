package uhk.fim.toolsrental.models.dto;

import uhk.fim.toolsrental.utils.PasswordMatches;
import uhk.fim.toolsrental.utils.ValidEmail;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@PasswordMatches
public class RegistrationDto {

    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    @ValidEmail
    private String email;

    private String phoneNumber;

    @Size(min = 6, message = "Heslo musí mít alespoň 6 znaků")
    private String password;
    @NotBlank
    private String confirmPassword;

    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }




}

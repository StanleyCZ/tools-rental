package uhk.fim.toolsrental.models;

import org.springframework.beans.factory.annotation.Value;
import uhk.fim.toolsrental.utils.AppHelper;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product extends ContentBase {

    @NotBlank
    private String name;
    private String code;
    private String description;
    @NotNull
    private float price;
    private float depositPrice;
    @NotNull
    private int totalAmount;
    @NotNull
    private int freeAmount;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getDepositPrice() {
        return depositPrice;
    }

    public void setDepositPrice(float depositPrice) {
        this.depositPrice = depositPrice;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public int getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(int freeAmount) {
        this.freeAmount = freeAmount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    private String image;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idCategory",referencedColumnName = "id", nullable = false)
    private Category category;

    public Product() {
    }

    @Transient
    public String getImageUrl(){
        if(image != null && !image.isEmpty())
            return image.substring(1);
        return "/img/empty.jpg";
    }

}

package uhk.fim.toolsrental.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Entity
public class Product extends ContentBase {



    @NotBlank
    private String name;

    @NotNull
    private Float cost;

    private String picture;
    private String description;

    @NotNull
    private int totalAmount;
    private int freeAmount;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "idCategory",referencedColumnName = "id", nullable = false)
    private Category category;

    public Product() {
    }

    public Product(@NotBlank String name, @NotBlank Float cost, @NotBlank int totalAmount) {
        this.cost = cost;
        this.totalAmount = totalAmount;
        this.name = name;
    }

    public Float getCost() {
        return cost;
    }

    public void setCost(Float cost) {
        this.cost = cost;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int maxPieces) {
        this.totalAmount = maxPieces;
    }

    public int getFreeAmount() {
        return freeAmount;
    }

    public void setFreeAmount(int availeblePieces) {
        this.freeAmount = availeblePieces;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}

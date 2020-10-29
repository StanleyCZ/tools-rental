package uhk.fim.toolsrental.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Product extends ContentBase {
    @NotBlank
    private Float cost;

    private String picture;
    private String description;

    @NotBlank
    private int totalAmount;
    private int freeAmount;

    @NotBlank
    @ManyToOne
    @JoinColumn(name = "idCategory",referencedColumnName = "id", nullable = false)
    private Category category;

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

    public Product() {
    }

    public Product(@NotBlank String name, @NotBlank Float cost, @NotBlank int totalAmount) {
        this.cost = cost;
        this.totalAmount = totalAmount;
    }
}

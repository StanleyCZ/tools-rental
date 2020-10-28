package uhk.fim.toolsrental.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;

@Entity
public class Product extends MyContentBase {
    @NotBlank
    private Float cost;

    private String picture;
    private String description;
    @NotBlank
    private int maxPieces;
    private int availeblePieces;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idCategory",referencedColumnName = "id")
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

    public int getMaxPieces() {
        return maxPieces;
    }

    public void setMaxPieces(int maxPieces) {
        this.maxPieces = maxPieces;
    }

    public int getAvaileblePieces() {
        return availeblePieces;
    }

    public void setAvaileblePieces(int availeblePieces) {
        this.availeblePieces = availeblePieces;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Product() {
    }

    public Product(@NotBlank Float cost, @NotBlank int maxPieces) {
        this.cost = cost;
        this.maxPieces = maxPieces;
    }
}

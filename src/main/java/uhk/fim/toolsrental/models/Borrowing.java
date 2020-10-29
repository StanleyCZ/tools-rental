package uhk.fim.toolsrental.models;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
public class Borrowing extends ContentBase {
    @NotBlank
    private Date sinceDate;

    private Date toDate;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idProduct",referencedColumnName = "id")
    private Product product;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idEmployee",referencedColumnName = "id")
    private User UserEmployee;

    @NotBlank
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idClient",referencedColumnName = "id")
    private User UserClient;

    @NotBlank
    private int amount;

    public Borrowing(@NotBlank Date sinceDate, @NotBlank Product product, @NotBlank int amount) {
        this.sinceDate = sinceDate;
        this.product = product;
        this.amount = amount;
    }

    public Date getSinceDate() {
        return sinceDate;
    }

    public void setSinceDate(Date sinceDate) {
        this.sinceDate = sinceDate;
    }

    public Date getToDate() {
        return toDate;
    }

    public void setToDate(Date toDate) {
        this.toDate = toDate;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Borrowing() {
    }
}

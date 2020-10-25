package uhk.fim.toolsrental.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class ContentBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private Date creationDate;
    private Date lastUpdate;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    @PrePersist
    protected void onCreate(){
        creationDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        lastUpdate = new Date();
    }

    public Date getCreationDate() {
        return creationDate;
    }
    public Date getLastUpdate() {
        return lastUpdate;
    }

}

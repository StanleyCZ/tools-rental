package uhk.fim.toolsrental.models;


import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class ContentBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private Date creationDate;
    private Date lastUpdate;

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public void setLastUpdate(Date lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    @Id
    public String getId() {
        return id;
    }

    public void setId(String id) {
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

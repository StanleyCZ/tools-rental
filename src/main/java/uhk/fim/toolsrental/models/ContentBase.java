package uhk.fim.toolsrental.models;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;


@MappedSuperclass
public abstract class ContentBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date createdDate;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private Date lastUpdateDate;

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public void setLastUpdateDate(Date lastUpdateDate) {
        this.lastUpdateDate = lastUpdateDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }


    @PrePersist
    protected void onCreate(){
        createdDate = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        lastUpdateDate = new Date();
    }

    public Date getCreatedDate() {
        return createdDate;
    }
    public Date getLastUpdateDate() {
        return lastUpdateDate;
    }

}

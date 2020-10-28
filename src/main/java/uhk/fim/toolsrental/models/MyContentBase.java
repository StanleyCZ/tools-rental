package uhk.fim.toolsrental.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@MappedSuperclass
public abstract class MyContentBase {

       @Id
       @GeneratedValue(strategy = GenerationType.IDENTITY)
       private Long id;



       public Long getId() {
           return id;
       }

       public void setId(final Long id) {
           this.id = id;
       }

}

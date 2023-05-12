package dalmin.domain;

import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "MyOrder_table")
@Data
public class MyOrder {

    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private Long itemId;
    private Long price;
    private String status;
}

package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderPaid extends AbstractEvent {

    private Long id;
    private Long customerId;
    private Long itemId;
    private Integer price;
    private String status;
    private String address;

    public OrderPaid(Order aggregate) {
        super(aggregate);
    }

    public OrderPaid() {
        super();
    }
}

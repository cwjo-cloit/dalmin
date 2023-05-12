package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderRejected extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long itemId;
    private Long status;
    private String address;

    public OrderRejected(StoreOrder aggregate) {
        super(aggregate);
    }

    public OrderRejected() {
        super();
    }
}

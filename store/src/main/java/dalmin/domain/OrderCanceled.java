package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class OrderCanceled extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long itemId;
    private Long status;
    private String address;

    public OrderCanceled(StoreOrder aggregate) {
        super(aggregate);
    }

    public OrderCanceled() {
        super();
    }
}

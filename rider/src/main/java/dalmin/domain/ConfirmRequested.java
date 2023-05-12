package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class ConfirmRequested extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long itemId;
    private Long customerId;
    private Long status;

    public ConfirmRequested(Delivery aggregate) {
        super(aggregate);
    }

    public ConfirmRequested() {
        super();
    }
}

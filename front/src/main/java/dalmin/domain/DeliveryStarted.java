package dalmin.domain;

import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.Data;

@Data
public class DeliveryStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long itemId;
    private Long customerId;
    private Long status;
}

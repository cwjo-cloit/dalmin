package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FoodStarted extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long itemId;
    private Long status;
    private String address;

    public FoodStarted(StoreOrder aggregate) {
        super(aggregate);
    }

    public FoodStarted() {
        super();
    }
}

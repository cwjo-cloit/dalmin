package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class FoodFinished extends AbstractEvent {

    private Long id;
    private Long orderId;
    private Long storeId;
    private Long itemId;
    private Long status;
    private String address;

    public FoodFinished(StoreOrder aggregate) {
        super(aggregate);
    }

    public FoodFinished() {
        super();
    }
}

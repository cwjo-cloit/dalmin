package dalmin.domain;

import dalmin.domain.*;
import dalmin.infra.AbstractEvent;
import java.util.*;
import lombok.*;

@Data
@ToString
public class PayUpdated extends AbstractEvent {

    private Long id;

    public PayUpdated(Payment aggregate) {
        super(aggregate);
    }

    public PayUpdated() {
        super();
    }
}

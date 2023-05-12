package dalmin.domain;

import dalmin.StoreApplication;
import dalmin.domain.FoodFinished;
import dalmin.domain.FoodStarted;
import dalmin.domain.OrderAccepted;
import dalmin.domain.OrderCanceled;
import dalmin.domain.OrderRejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "StoreOrder_table")
@Data
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderId;

    private Long storeId;

    private Long itemId;

    private Long status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        FoodStarted foodStarted = new FoodStarted(this);
        foodStarted.publishAfterCommit();

        FoodFinished foodFinished = new FoodFinished(this);
        foodFinished.publishAfterCommit();

        OrderAccepted orderAccepted = new OrderAccepted(this);
        orderAccepted.publishAfterCommit();

        OrderCanceled orderCanceled = new OrderCanceled(this);
        orderCanceled.publishAfterCommit();
    }

    public static StoreOrderRepository repository() {
        StoreOrderRepository storeOrderRepository = StoreApplication.applicationContext.getBean(
            StoreOrderRepository.class
        );
        return storeOrderRepository;
    }

    public static void orderPlaced(OrderPlaced orderPlaced) {
        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderPlaced.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);


         });
        */

    }

    public static void orderCanceled(OrderCancled orderCancled) {
        /** Example 1:  new item 
        StoreOrder storeOrder = new StoreOrder();
        repository().save(storeOrder);

        OrderCanceled orderCanceled = new OrderCanceled(storeOrder);
        orderCanceled.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCancled.get???()).ifPresent(storeOrder->{
            
            storeOrder // do something
            repository().save(storeOrder);

            OrderCanceled orderCanceled = new OrderCanceled(storeOrder);
            orderCanceled.publishAfterCommit();

         });
        */

    }
}

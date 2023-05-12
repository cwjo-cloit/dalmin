package dalmin.domain;

import dalmin.FrontApplication;
import dalmin.domain.OrderCancled;
import dalmin.domain.OrderCompleted;
import dalmin.domain.OrderPaid;
import dalmin.domain.OrderPlaced;
import dalmin.domain.OrderRejected;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Order_table")
@Data
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long customerId;

    private Long itemId;

    private Integer price;

    private String status;

    private String address;

    @PostPersist
    public void onPostPersist() {
        OrderPlaced orderPlaced = new OrderPlaced(this);
        orderPlaced.publishAfterCommit();

        OrderPaid orderPaid = new OrderPaid(this);
        orderPaid.publishAfterCommit();

        OrderCancled orderCancled = new OrderCancled(this);
        orderCancled.publishAfterCommit();

        OrderRejected orderRejected = new OrderRejected(this);
        orderRejected.publishAfterCommit();

        OrderCompleted orderCompleted = new OrderCompleted(this);
        orderCompleted.publishAfterCommit();
    }

    @PreUpdate
    public void onPreUpdate() {}

    public static OrderRepository repository() {
        OrderRepository orderRepository = FrontApplication.applicationContext.getBean(
            OrderRepository.class
        );
        return orderRepository;
    }

    public static void orderHandler(OrderRejected orderRejected) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderCompleted orderCompleted = new OrderCompleted(order);
        orderCompleted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderCompleted orderCompleted = new OrderCompleted(order);
            orderCompleted.publishAfterCommit();
            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

    }

    public static void orderHandler(OrderAccepted orderAccepted) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderCompleted orderCompleted = new OrderCompleted(order);
        orderCompleted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderAccepted.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderCompleted orderCompleted = new OrderCompleted(order);
            orderCompleted.publishAfterCommit();
            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

    }

    public static void orderHandler(OrderCanceled orderCanceled) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderCompleted orderCompleted = new OrderCompleted(order);
        orderCompleted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(orderCanceled.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderCompleted orderCompleted = new OrderCompleted(order);
            orderCompleted.publishAfterCommit();
            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

    }

    public static void orderHandler(ConfirmRequested confirmRequested) {
        /** Example 1:  new item 
        Order order = new Order();
        repository().save(order);

        OrderCompleted orderCompleted = new OrderCompleted(order);
        orderCompleted.publishAfterCommit();
        OrderRejected orderRejected = new OrderRejected(order);
        orderRejected.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(confirmRequested.get???()).ifPresent(order->{
            
            order // do something
            repository().save(order);

            OrderCompleted orderCompleted = new OrderCompleted(order);
            orderCompleted.publishAfterCommit();
            OrderRejected orderRejected = new OrderRejected(order);
            orderRejected.publishAfterCommit();

         });
        */

    }
}

package dalmin.domain;

import dalmin.FrontApplication;
import dalmin.domain.PayUpdated;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Payment_table")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long orderid;

    private Long customerId;

    private Integer price;

    private Integer status;

    @PostPersist
    public void onPostPersist() {
        PayUpdated payUpdated = new PayUpdated(this);
        payUpdated.publishAfterCommit();
    }

    public static PaymentRepository repository() {
        PaymentRepository paymentRepository = FrontApplication.applicationContext.getBean(
            PaymentRepository.class
        );
        return paymentRepository;
    }

    public static void paymentHandler(OrderRejected orderRejected) {
        /** Example 1:  new item 
        Payment payment = new Payment();
        repository().save(payment);

        */

        /** Example 2:  finding and process
        
        repository().findById(orderRejected.get???()).ifPresent(payment->{
            
            payment // do something
            repository().save(payment);


         });
        */

    }
}

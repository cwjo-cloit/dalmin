package dalmin.infra;

import dalmin.domain.*;
import dalmin.config.kafka.KafkaProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Service
public class MyOrderViewHandler {

    @Autowired
    private MyOrderRepository myOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderPlaced_then_CREATE_1 (@Payload OrderPlaced orderPlaced) {
        try {

            if (!orderPlaced.validate()) return;

            // view 객체 생성
            MyOrder myOrder = new MyOrder();
            // view 객체에 이벤트의 Value 를 set 함
            myOrder.setId(orderPlaced.getId());
            myOrder.setItemId(orderPlaced.getItemId());
            myOrder.setPrice(orderPlaced.getPrice());
            myOrder.setStatus(주문요청);
            // view 레파지 토리에 save
            myOrderRepository.save(myOrder);

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderAccepted_then_UPDATE_1(@Payload OrderAccepted orderAccepted) {
        try {
            if (!orderAccepted.validate()) return;
                // view 객체 조회
            Optional<MyOrder> myOrderOptional = myOrderRepository.findById(orderAccepted.getOrderId());

            if( myOrderOptional.isPresent()) {
                 MyOrder myOrder = myOrderOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myOrder.setStatus(주문접수);    
                // view 레파지 토리에 save
                 myOrderRepository.save(myOrder);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderRejected_then_UPDATE_2(@Payload OrderRejected orderRejected) {
        try {
            if (!orderRejected.validate()) return;
                // view 객체 조회
            Optional<MyOrder> myOrderOptional = myOrderRepository.findById(orderRejected.getOrderId());

            if( myOrderOptional.isPresent()) {
                 MyOrder myOrder = myOrderOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myOrder.setStatus(주문거절);    
                // view 레파지 토리에 save
                 myOrderRepository.save(myOrder);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @StreamListener(KafkaProcessor.INPUT)
    public void whenDeliveryStarted_then_UPDATE_3(@Payload DeliveryStarted deliveryStarted) {
        try {
            if (!deliveryStarted.validate()) return;
                // view 객체 조회
            Optional<MyOrder> myOrderOptional = myOrderRepository.findById(deliveryStarted.getOrderId());

            if( myOrderOptional.isPresent()) {
                 MyOrder myOrder = myOrderOptional.get();
            // view 객체에 이벤트의 eventDirectValue 를 set 함
                myOrder.setStatus(배달 시작);    
                // view 레파지 토리에 save
                 myOrderRepository.save(myOrder);
                }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @StreamListener(KafkaProcessor.INPUT)
    public void whenOrderCancled_then_DELETE_1(@Payload OrderCancled orderCancled) {
        try {
            if (!orderCancled.validate()) return;
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}


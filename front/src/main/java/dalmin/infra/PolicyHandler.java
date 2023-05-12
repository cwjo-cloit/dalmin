package dalmin.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import dalmin.config.kafka.KafkaProcessor;
import dalmin.domain.*;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class PolicyHandler {

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    PaymentRepository paymentRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderRejected'"
    )
    public void wheneverOrderRejected_OrderHandler(
        @Payload OrderRejected orderRejected
    ) {
        OrderRejected event = orderRejected;
        System.out.println(
            "\n\n##### listener OrderHandler : " + orderRejected + "\n\n"
        );

        // Comments //
        //주문 상태를 업데이트
        // 주문상태가 업데이트 되는 상황
        // 1. 주문 거절
        // 2. 주문 승인
        // 3. 요리 시작
        // 4. 요리 완료
        // 5. 배송 시작
        // 6. 배송 완료
        //

        // Sample Logic //
        Order.orderHandler(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderAccepted'"
    )
    public void wheneverOrderAccepted_OrderHandler(
        @Payload OrderAccepted orderAccepted
    ) {
        OrderAccepted event = orderAccepted;
        System.out.println(
            "\n\n##### listener OrderHandler : " + orderAccepted + "\n\n"
        );

        // Comments //
        //주문 상태를 업데이트
        // 주문상태가 업데이트 되는 상황
        // 1. 주문 거절
        // 2. 주문 승인
        // 3. 요리 시작
        // 4. 요리 완료
        // 5. 배송 시작
        // 6. 배송 완료
        //

        // Sample Logic //
        Order.orderHandler(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCanceled'"
    )
    public void wheneverOrderCanceled_OrderHandler(
        @Payload OrderCanceled orderCanceled
    ) {
        OrderCanceled event = orderCanceled;
        System.out.println(
            "\n\n##### listener OrderHandler : " + orderCanceled + "\n\n"
        );

        // Comments //
        //주문 상태를 업데이트
        // 주문상태가 업데이트 되는 상황
        // 1. 주문 거절
        // 2. 주문 승인
        // 3. 요리 시작
        // 4. 요리 완료
        // 5. 배송 시작
        // 6. 배송 완료
        //

        // Sample Logic //
        Order.orderHandler(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='ConfirmRequested'"
    )
    public void wheneverConfirmRequested_OrderHandler(
        @Payload ConfirmRequested confirmRequested
    ) {
        ConfirmRequested event = confirmRequested;
        System.out.println(
            "\n\n##### listener OrderHandler : " + confirmRequested + "\n\n"
        );

        // Comments //
        //주문 상태를 업데이트
        // 주문상태가 업데이트 되는 상황
        // 1. 주문 거절
        // 2. 주문 승인
        // 3. 요리 시작
        // 4. 요리 완료
        // 5. 배송 시작
        // 6. 배송 완료
        //

        // Sample Logic //
        Order.orderHandler(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderRejected'"
    )
    public void wheneverOrderRejected_PaymentHandler(
        @Payload OrderRejected orderRejected
    ) {
        OrderRejected event = orderRejected;
        System.out.println(
            "\n\n##### listener PaymentHandler : " + orderRejected + "\n\n"
        );

        // Sample Logic //
        Payment.paymentHandler(event);
    }
}

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
    StoreOrderRepository storeOrderRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderPlaced'"
    )
    public void wheneverOrderPlaced_OrderPlaced(
        @Payload OrderPlaced orderPlaced
    ) {
        OrderPlaced event = orderPlaced;
        System.out.println(
            "\n\n##### listener OrderPlaced : " + orderPlaced + "\n\n"
        );

        // Comments //
        //주문에 대한 결재가 완료 되면 주문 정보는 해당 스토어로 전달
        //
        //

        // Sample Logic //
        StoreOrder.orderPlaced(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCancled'"
    )
    public void wheneverOrderCancled_OrderCanceled(
        @Payload OrderCancled orderCancled
    ) {
        OrderCancled event = orderCancled;
        System.out.println(
            "\n\n##### listener OrderCanceled : " + orderCancled + "\n\n"
        );

        // Comments //
        //주문했던 음식을 취소함
        //
        // 요리가 시작된 경우 취소 불가
        //

        // Sample Logic //
        StoreOrder.orderCanceled(event);
    }
}

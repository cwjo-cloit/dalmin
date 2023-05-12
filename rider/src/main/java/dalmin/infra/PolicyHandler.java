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
    DeliveryRepository deliveryRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='FoodFinished'"
    )
    public void wheneverFoodFinished_DeliveryPlace(
        @Payload FoodFinished foodFinished
    ) {
        FoodFinished event = foodFinished;
        System.out.println(
            "\n\n##### listener DeliveryPlace : " + foodFinished + "\n\n"
        );

        // Comments //
        //조리가 완료된 제품이 배달목록에 생성됨
        //
        //

        // Sample Logic //
        Delivery.deliveryPlace(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='OrderCompleted'"
    )
    public void wheneverOrderCompleted_DeliveryHandler(
        @Payload OrderCompleted orderCompleted
    ) {
        OrderCompleted event = orderCompleted;
        System.out.println(
            "\n\n##### listener DeliveryHandler : " + orderCompleted + "\n\n"
        );

        // Comments //
        //배달 상태를 업데이트
        //
        //

        // Sample Logic //
        Delivery.deliveryHandler(event);
    }
}

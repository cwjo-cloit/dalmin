package dalmin.common;

import dalmin.KakaoTalkApplication;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { KakaoTalkApplication.class })
public class CucumberSpingConfiguration {}

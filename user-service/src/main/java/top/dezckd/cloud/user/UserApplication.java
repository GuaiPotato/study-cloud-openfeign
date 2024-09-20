package top.dezckd.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.dezckd.cloud.user.client.OrderServiceClient;
import top.dezckd.common.handler.FeignConfig;
import top.dezckd.common.mybatis.MyBatisConfig;
import top.dezckd.common.properties.JwtProperties;
import top.dezckd.common.properties.SsyProperties;

@SpringBootApplication
@EnableFeignClients(clients = {OrderServiceClient.class})
@Import({MyBatisConfig.class, FeignConfig.class })
@EnableConfigurationProperties({SsyProperties.class, JwtProperties.class})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}

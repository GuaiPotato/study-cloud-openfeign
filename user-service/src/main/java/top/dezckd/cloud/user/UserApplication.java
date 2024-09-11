package top.dezckd.cloud.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import top.dezckd.cloud.user.client.OrderServiceClient;

@SpringBootApplication
@EnableFeignClients(clients = {OrderServiceClient.class})
public class UserApplication {

    public static void main(String[] args) {
        SpringApplication.run(UserApplication.class, args);
    }

}

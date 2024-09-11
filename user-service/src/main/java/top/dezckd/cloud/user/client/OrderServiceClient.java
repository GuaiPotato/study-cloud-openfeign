package top.dezckd.cloud.user.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import top.dezckd.cloud.user.pojo.dto.OrderResponse;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description OrderServiceClient
 */
@Component
@FeignClient(value = "order-service", url = "http://127.0.0.1:8020")
public interface OrderServiceClient {

    @GetMapping("/orders/{orderId}")
    OrderResponse getOrderById(@PathVariable("orderId") Long orderId);
}

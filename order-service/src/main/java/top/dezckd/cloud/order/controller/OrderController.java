package top.dezckd.cloud.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dezckd.cloud.order.pojo.dto.OrderResponse;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description OrderController
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @GetMapping("/{orderId}")
    public OrderResponse getOrderById(@PathVariable("orderId") Integer orderId) {
        OrderResponse order = new OrderResponse(orderId, "测试订单", 2, 200.0);
        return order;
    }
}


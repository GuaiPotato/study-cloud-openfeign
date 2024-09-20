package top.dezckd.cloud.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dezckd.cloud.user.client.OrderServiceClient;
import top.dezckd.cloud.user.entity.dto.OrderResponse;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description UserService
 */
@Service
public class UserService {

    @Autowired
    private OrderServiceClient orderServiceClient;

    public OrderResponse fetchUserOrder(Long orderId) {
        OrderResponse order = orderServiceClient.getOrderById(orderId);
        return order;
    }
}


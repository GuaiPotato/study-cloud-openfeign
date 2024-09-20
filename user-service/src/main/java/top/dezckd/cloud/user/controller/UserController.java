package top.dezckd.cloud.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import top.dezckd.cloud.user.entity.dto.OrderResponse;
import top.dezckd.cloud.user.service.UserService;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description UserController
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/orders/{orderId}")
    public OrderResponse getOrderByUser(@PathVariable("orderId") Long orderId) {
        return userService.fetchUserOrder(orderId);
    }
}

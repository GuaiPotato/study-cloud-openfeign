package top.dezckd.cloud.order.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import top.dezckd.api.facade.OrderFacade;
import top.dezckd.api.pojo.dto.OrderDTO;
import top.dezckd.api.pojo.query.OrderCreateQuery;
import top.dezckd.cloud.order.entity.Order;
import top.dezckd.cloud.order.entity.dto.OrderResponse;
import top.dezckd.cloud.order.mapping.OrderMapping;
import top.dezckd.cloud.order.service.OrderService;

import java.util.List;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description OrderController
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class OrderController implements OrderFacade {
    private final OrderService orderService;

    private final OrderMapping orderMapping;

    private final HttpServletRequest request;

    @Override
    public OrderDTO order(@RequestBody OrderCreateQuery orderCreateQuery) {
        String uid = request.getHeader("uid");
        String username = request.getHeader("username");
        log.info("用户 [{}, {}] 正在下单：{}", uid, username, orderCreateQuery);
        return orderService.createOrder(orderCreateQuery);
    }

    @Override
    public List<OrderDTO> orders(@PathVariable("uid") Integer uid) {
        LambdaQueryWrapper<Order> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Order::getUid, uid);
        IPage<Order> page = orderService.page(new Page<>(2, 3), queryWrapper);
        return orderMapping.convertTo(page.getRecords());
    }

}


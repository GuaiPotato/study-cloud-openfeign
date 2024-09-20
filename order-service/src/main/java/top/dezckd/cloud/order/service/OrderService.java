package top.dezckd.cloud.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dezckd.api.pojo.dto.OrderDTO;
import top.dezckd.api.pojo.query.OrderCreateQuery;
import top.dezckd.cloud.order.entity.Order;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @description OrderService
 **/
public interface OrderService extends IService<Order> {
    /**
     * 下单
     * @param orderCreateQuery
     * @return
     */
    OrderDTO createOrder(OrderCreateQuery orderCreateQuery);
}

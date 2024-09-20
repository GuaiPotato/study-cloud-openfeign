package top.dezckd.cloud.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import top.dezckd.api.pojo.dto.OrderDTO;
import top.dezckd.api.pojo.dto.ProductDTO;
import top.dezckd.api.pojo.query.OrderCreateQuery;
import top.dezckd.common.properties.SsyProperties;
import top.dezckd.cloud.order.entity.Order;
import top.dezckd.cloud.order.mapper.OrderMapper;
import top.dezckd.cloud.order.mapping.OrderMapping;
import top.dezckd.cloud.order.service.OrderService;

import java.util.Objects;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description 抽象产品服务
 */
@Slf4j
public abstract class AbstractOrderService extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Resource
    private SsyProperties ssyProperties;

    @Resource
    private OrderMapping orderMapping;

    @Override
    public OrderDTO createOrder(OrderCreateQuery orderCreateQuery) {
        log.info("调用商品服务查询商品信息");
        int productId = orderCreateQuery.getProductId();
        ProductDTO productDTO = queryProductInfo(productId);
        if (Objects.isNull(productDTO)) {
            throw new RuntimeException("商品不存在");
        }
        if (productDTO.getId() == -1) {
            OrderDTO orderDTO = new OrderDTO();
            orderDTO.setProductId(productId);
            orderDTO.setDesc("下单失败");
            return orderDTO;
        }
        // 构建订单
        Order order = buildOrder(productDTO, orderCreateQuery);
        // 保存订单
        this.save(order);
        // 减库存
        this.deduct(orderCreateQuery);
        // 映射返回订单
        OrderDTO orderDTO = orderMapping.convertTo(order);
        orderDTO.setSite(ssyProperties.getSite());
        orderDTO.setDesc(productDTO.getProductDesc());
        return orderDTO;
    }

    /**
     * 获取产品信息（由不同服务继承实现）
     *
     * @param productId 产品id
     * @return ProductDTO
     */
    protected abstract ProductDTO queryProductInfo(int productId);

    /**
     * 减库存
     *
     * @param orderCreateQuery 查询参数
     */
    protected abstract void deduct(OrderCreateQuery orderCreateQuery);


    /**
     * 构建订单
     *
     * @param productDTO       产品dto
     * @param orderCreateQuery 订单创建参数
     * @return Order
     */
    private Order buildOrder(ProductDTO productDTO, OrderCreateQuery orderCreateQuery) {
        Order order = new Order();
        order.setUid(1);
        // 从配置中心读取
        order.setUsername(ssyProperties.getUsername() + ":" + ssyProperties.getSecretKey());
        order.setProductId(productDTO.getId());
        order.setProductName(productDTO.getProductName());
        order.setPrice(productDTO.getPrice());
        order.setCount(orderCreateQuery.getCount());
        order.setStatus(0);
        return order;
    }
}

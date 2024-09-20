package top.dezckd.cloud.order.entity.dto;

import lombok.Data;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description OrderResponse
 */
@Data
public class OrderResponse {

    private Integer orderId;
    private String productName;
    private Integer quantity;
    private Double totalPrice;

    public OrderResponse(Integer orderId, String productName, Integer quantity, Double totalPrice) {
        this.orderId = orderId;
        this.productName = productName;
        this.quantity = quantity;
        this.totalPrice = totalPrice;
    }
}

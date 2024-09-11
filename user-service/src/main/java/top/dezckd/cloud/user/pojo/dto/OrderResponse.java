package top.dezckd.cloud.user.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description OrderResponse
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderResponse {

    private Long orderId;
    private String productName;
    private Integer quantity;
    private Double totalPrice;
}

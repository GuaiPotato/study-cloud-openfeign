package top.dezckd.cloud.product.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductDTO
 */
@TableName("t_product")
@Data
public class Product {

    @TableId(type = IdType.AUTO)
    private Integer id;

    private String productName;

    private String productDesc;

    private Double price;

    private Integer count;

    private String specification;

}

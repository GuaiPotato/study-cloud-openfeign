package top.dezckd.cloud.product.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import top.dezckd.cloud.product.entity.Product;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductMapper
 */
public interface ProductMapper extends BaseMapper<Product> {

    /**
     * 减对应产品库存
     *
     * @param productId 产品id
     * @param count     数量
     * @return int
     */
    int deduct(@Param("id") Integer productId, @Param("count") Integer count);

}

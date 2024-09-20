package top.dezckd.cloud.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import top.dezckd.api.pojo.query.ProductStockDeductQuery;
import top.dezckd.cloud.product.entity.Product;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductService
 */
public interface ProductService extends IService<Product> {

    /**
     * 减库存
     *
     * @param productStockDeductQuery 查询参数
     * @return int
     */
    int deduct(ProductStockDeductQuery productStockDeductQuery);

}

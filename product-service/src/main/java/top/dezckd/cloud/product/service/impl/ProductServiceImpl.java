package top.dezckd.cloud.product.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import top.dezckd.api.pojo.query.ProductStockDeductQuery;
import top.dezckd.cloud.product.entity.Product;
import top.dezckd.cloud.product.mapper.ProductMapper;
import top.dezckd.cloud.product.service.ProductService;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductServiceImpl
 */
@RequiredArgsConstructor
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    private final ProductMapper productMapper;

    @Override
    public int deduct(@RequestBody ProductStockDeductQuery productStockDeductQuery) {
        return productMapper.deduct(productStockDeductQuery.getProductId(),
                productStockDeductQuery.getCount());
    }

}

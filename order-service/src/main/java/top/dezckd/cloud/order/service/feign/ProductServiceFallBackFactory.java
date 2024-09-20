package top.dezckd.cloud.order.service.feign;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import top.dezckd.api.pojo.dto.ProductDTO;
import top.dezckd.api.pojo.query.ProductStockDeductQuery;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductServiceFallBackFactory
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class ProductServiceFallBackFactory implements FallbackFactory<ProductService> {

    @Override
    public ProductService create(Throwable throwable) {
        log.error("调用商品服务异常：", throwable);
        return new ProductService() {
            @Override
            public ProductDTO queryProductInfo(Integer productId) {
                ProductDTO productDTO = new ProductDTO();
                productDTO.setId(-1);
                return productDTO;
            }

            @Override
            public boolean deductStock(ProductStockDeductQuery productStockDeductQuery) {
                return false;
            }
        };
    }
}

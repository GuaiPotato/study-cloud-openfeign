package top.dezckd.cloud.product.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dezckd.api.facade.ProductFacade;
import top.dezckd.api.pojo.dto.ProductDTO;
import top.dezckd.api.pojo.query.ProductStockDeductQuery;
import top.dezckd.cloud.product.entity.Product;
import top.dezckd.cloud.product.mapping.ProductMapping;
import top.dezckd.cloud.product.service.ProductService;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductController
 */
@RequiredArgsConstructor
@RestController
@Slf4j
public class ProductController implements ProductFacade {

    private final ProductService productService;

    private final ProductMapping productMapping;

    private final HttpServletRequest request;

    private final Environment env;

    @Override
    public ProductDTO queryProductInfo(@PathVariable("id") Integer productId) {
        String uid = request.getHeader("uid");
        String username = request.getHeader("username");
        log.info("用户 [{}, {}] 正在查询产品信息：{}", uid, username, productId);
        Product product = productService.getById(productId);
        // 负载均衡测试
        //product.setProductDesc(product.getProductDesc() + "@" + env.getProperty("server.port"));
        return productMapping.convertTo(product);
    }

    @Override
    public boolean deductStock(@RequestBody ProductStockDeductQuery productStockDeductQuery) {
        log.info("正在更新商品库存：{}", productStockDeductQuery);
        int successCount = productService.deduct(productStockDeductQuery);
        log.info("更新商品 ID[{}] 库存影响行数：{}", productStockDeductQuery.getProductId(), successCount);
        return successCount == 1;
    }

}

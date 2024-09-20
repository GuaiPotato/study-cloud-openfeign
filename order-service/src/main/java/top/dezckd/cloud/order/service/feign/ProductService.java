package top.dezckd.cloud.order.service.feign;

import org.springframework.cloud.openfeign.FeignClient;
import top.dezckd.api.facade.ProductFacade;
import top.dezckd.common.constants.ServiceConsts;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductService
 */
@FeignClient(value = ServiceConsts.PRODUCT_SERVICE, fallbackFactory = ProductServiceFallBackFactory.class)
public interface ProductService extends ProductFacade {

}

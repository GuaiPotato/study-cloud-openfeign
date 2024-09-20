package top.dezckd.cloud.product.mapping;

import org.mapstruct.Mapper;
import top.dezckd.api.pojo.dto.ProductDTO;
import top.dezckd.cloud.product.entity.Product;
import top.dezckd.common.handler.BaseMapping;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description ProductMapping
 */
@Mapper(componentModel = "spring")
public interface ProductMapping extends BaseMapping<Product, ProductDTO> {

}

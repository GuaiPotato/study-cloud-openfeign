package top.dezckd.cloud.order.mapping;

import org.mapstruct.Mapper;
import top.dezckd.api.pojo.dto.OrderDTO;
import top.dezckd.cloud.order.entity.Order;
import top.dezckd.common.constants.DateConsts;
import top.dezckd.common.handler.BaseMapping;

import java.time.format.DateTimeFormatter;

/**
 * @Author DEZ
 * @Date 2024/9/20
 * @Description OrderMapping
 */
@Mapper(componentModel = "spring")
public interface OrderMapping extends BaseMapping<Order, OrderDTO> {

    @Override
    default void afterConvertTo(Order src, OrderDTO dest) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern(DateConsts.YYYY_MM_DD_HH_MM_SS);
        dest.setCreateTime(src.getCreateTime().format(dateTimeFormatter));
        dest.setUpdateTime(src.getUpdateTime().format(dateTimeFormatter));
    }

}

package top.dezckd.cloud.product;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Import;
import top.dezckd.common.handler.FeignConfig;
import top.dezckd.common.mybatis.MyBatisConfig;
import top.dezckd.common.properties.SsyProperties;

/**
 * @Author DEZ
 * @Date 2024/9/11
 * @Description ProductApplication
 */
@SpringBootApplication
@EnableFeignClients
@EnableConfigurationProperties({SsyProperties.class})
@Import({MyBatisConfig.class, FeignConfig.class})
@MapperScan(basePackages = {"top.dezckd.cloud.product.mapper"})
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class, args);
    }
}

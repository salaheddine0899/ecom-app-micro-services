package ma.xelops.billingservice.feign;

import ma.xelops.billingservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping(name = "/api/products/{id}")
    ProductDto getProductById(@PathVariable String id);
    @GetMapping(name = "/api/products")
    List<ProductDto> getProducts();
}

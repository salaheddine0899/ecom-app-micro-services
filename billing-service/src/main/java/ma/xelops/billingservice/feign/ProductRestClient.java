package ma.xelops.billingservice.feign;

import ma.xelops.billingservice.dto.ProductDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {
    @GetMapping("/api/products/{id}")
    ProductDto getProductById(@PathVariable String id);
    @GetMapping("/api/products")
    PagedModel<ProductDto> getAllProducts();
}

package ma.xelops.billingservice.feign;

import ma.xelops.billingservice.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "customer-service")
public interface CustomerRestClient {
    @GetMapping("/api/customers/{id}")
    CustomerDto getCustomerById(@PathVariable Integer id);
    @GetMapping("/api/customers")
    PagedModel<CustomerDto> getAllCustomers();
}

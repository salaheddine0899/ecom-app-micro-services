package ma.xelops.billingservice.service;

import lombok.RequiredArgsConstructor;
import ma.xelops.billingservice.dto.BillDto;
import ma.xelops.billingservice.dto.CustomerDto;
import ma.xelops.billingservice.dto.ProductDto;
import ma.xelops.billingservice.entities.Bill;
import ma.xelops.billingservice.feign.CustomerRestClient;
import ma.xelops.billingservice.feign.ProductRestClient;
import ma.xelops.billingservice.mapper.BillMapper;
import ma.xelops.billingservice.repositories.BillRepository;
import ma.xelops.billingservice.repositories.ProductItemRepository;
import org.springframework.hateoas.PagedModel;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
@RequiredArgsConstructor
public class BillService {
    private final BillRepository billRepository;
    private final ProductItemRepository productItemRepository;
    private final ProductRestClient productRestClient;
    private final CustomerRestClient customerRestClient;
    private final BillMapper billMapper;

    public BillDto getBillById(Integer id) {
        Bill bill = billRepository.findById(id).orElseThrow(()-> new RuntimeException("Bill not found"));
        BillDto billDto = billMapper.mapBillToBillDto(bill);
        CustomerDto customer = customerRestClient.getCustomerById(bill.getCustomerId());
        billDto.setCustomer(customer);
        Collection<ProductDto> products = productRestClient.getAllProducts().getContent();
        billDto.getProductItems().forEach(productItem -> {
            products.forEach(product -> {
                if (product.getId().equals(productItem.getProductId())) {
                    productItem.setProduct(product);
                }
            });

        });
        return billDto;
    }
}

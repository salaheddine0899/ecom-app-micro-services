package ma.xelops.billingservice;

import ma.xelops.billingservice.dto.CustomerDto;
import ma.xelops.billingservice.dto.ProductDto;
import ma.xelops.billingservice.entities.Bill;
import ma.xelops.billingservice.entities.ProductItem;
import ma.xelops.billingservice.feign.CustomerRestClient;
import ma.xelops.billingservice.feign.ProductRestClient;
import ma.xelops.billingservice.repositories.BillRepository;
import ma.xelops.billingservice.repositories.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Collection;
import java.util.Date;
import java.util.Random;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                                        ProductItemRepository productItemRepository,
                                        ProductRestClient productRestClient,
                                        CustomerRestClient customerRestClient){
        return args -> {
            Collection<ProductDto> products = productRestClient.getProducts().getContent();
            Collection<CustomerDto> customers = customerRestClient.getAllCustomers().getContent();

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date()).customerId(customer.getId()).build();
                billRepository.save(bill);
                products.forEach( product ->
                    productItemRepository.save(ProductItem.builder().bill(bill).
                            productId(product.getId()).quantity(new Random().nextInt(10)+1)
                            .unitPrice(product.getPrice()).build())
                );
            });

        };
    }
}

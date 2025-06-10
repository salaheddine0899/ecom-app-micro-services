package ma.xelops.inventoryservice;

import ma.xelops.inventoryservice.entities.Product;
import ma.xelops.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(ProductRepository productRepository) {
        return args -> {
            productRepository.saveAll(List.of(
                    Product.builder().id(UUID.randomUUID().toString())
                            .name("Printer")
                            .price(1000.)
                            .quantity(10).build(),
                    Product.builder().id(UUID.randomUUID().toString())
                            .name("Iphone")
                            .price(8000.)
                            .quantity(6).build(),
                    Product.builder().id(UUID.randomUUID().toString())
                            .name("Dell laltitude i7")
                            .price(16000.)
                            .quantity(3).build()
            ));
            productRepository.findAll().forEach(product -> {
                System.out.println("###########################");
                System.out.println(product.getId());
                System.out.println(product.getName());
                System.out.println(product.getPrice());
                System.out.println(product.getQuantity());
                System.out.println("###########################");
            });
        };
    }

}

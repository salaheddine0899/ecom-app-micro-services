package ma.xelops.customerservice;

import ma.xelops.customerservice.entities.Customer;
import ma.xelops.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner init(CustomerRepository customerRepository) {
		return args -> {
			customerRepository.saveAll(List.of(Customer.builder().name("Tamega").mail("tamega.canadien@gmail.com").build(),
					Customer.builder().name("Abdellah").mail("Abdellah@gmail.com").build(),
					Customer.builder().name("Canadien").mail("canadien.loud@gmail.com").build()
					));
			customerRepository.findAll().forEach(customer -> {
				System.out.println("###########################");
				System.out.println(customer.getId());
				System.out.println(customer.getName());
				System.out.println(customer.getMail());
				System.out.println("###########################");
			});
		};
	}

}

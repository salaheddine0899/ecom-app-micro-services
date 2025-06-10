package ma.xelops.customerservice.entities.projections;

import ma.xelops.customerservice.entities.Customer;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "all", types = Customer.class)
public interface CustomerProjection {
    String getName();
    String getMail();
}

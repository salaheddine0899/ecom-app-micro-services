package ma.xelops.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.xelops.billingservice.dto.CustomerDto;

import java.util.Date;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class Bill {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date billingDate;
    private Integer customerId;
    @OneToMany(mappedBy = "bill")
    private List<ProductItem> productItems;
    @Transient
    private CustomerDto customer;
}

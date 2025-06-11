package ma.xelops.billingservice.entities;

import jakarta.persistence.*;
import lombok.*;
import ma.xelops.billingservice.dto.ProductDto;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String productId;
    @ManyToOne
    private Bill bill;
    private Integer quantity;
    private Double unitPrice;
    @Transient
    private ProductDto product;
}

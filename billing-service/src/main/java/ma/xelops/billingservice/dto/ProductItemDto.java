package ma.xelops.billingservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductItemDto {

    private Integer id;
    private String productId;
    private Integer quantity;
    private Double unitPrice;
    private ProductDto product;
}

package ma.xelops.billingservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ProductDto {
    private String id;
    private String name;
    private Double price;
    private Integer quantity;
}

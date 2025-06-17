package ma.xelops.billingservice.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class BillDto {

    private Integer id;
    private Date billingDate;
    private CustomerDto customer;
    private List<ProductItemDto> productItems;
}

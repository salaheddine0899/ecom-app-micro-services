package ma.xelops.billingservice.dto;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class CustomerDto {
    private Integer id;
    private String name;
    private String mail;
}

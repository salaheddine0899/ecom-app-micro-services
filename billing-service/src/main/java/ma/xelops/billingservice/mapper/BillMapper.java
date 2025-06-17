package ma.xelops.billingservice.mapper;

import ma.xelops.billingservice.dto.BillDto;
import ma.xelops.billingservice.entities.Bill;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring", uses = {ProductItemMapper.class})
public interface BillMapper {

    BillDto mapBillToBillDto(Bill bill);
}

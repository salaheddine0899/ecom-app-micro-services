package ma.xelops.billingservice.mapper;

import ma.xelops.billingservice.dto.ProductItemDto;
import ma.xelops.billingservice.entities.ProductItem;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductItemMapper {

    ProductItemDto mapProductItemToProductItemDto(ProductItem productItem);
}

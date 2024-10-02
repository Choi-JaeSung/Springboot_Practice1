package practice.sky.aroundhub.data.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import practice.sky.aroundhub.data.dto.ProductDto;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "product")
public class ProductEntity
{
    @Id
    String productId;
    String productName;
    Integer productPrice;
    Integer productStock;


    public ProductDto toDto()
    {
        return ProductDto.builder()
                         .productId(productId)
                         .productName(productName)
                         .productPrice(productPrice)
                         .productStock(productStock)
                         .build();
    }
}

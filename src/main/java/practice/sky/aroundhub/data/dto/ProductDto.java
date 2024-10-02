package practice.sky.aroundhub.data.dto;

import lombok.*;
import practice.sky.aroundhub.data.entity.ProductEntity;


@Data
//@NoArgsConstructor
@AllArgsConstructor
//@ToString
@Builder
public class ProductDto {
    private String productId;
    private String productName;
    private int productPrice;
    private int productStock;


    public ProductEntity toEntity() {
        return ProductEntity.builder()
                .productId(productId)
                .productName(productName)
                .productPrice(productPrice)
                .productStock(productStock)
                .build();
    }
}

/*
- @Data : get method + set method + NoArgsConstructor + ToString + equals + hashcode 자동 작성
  >> @Data 사용하면 포함되는 @Getter, @Setter, @NoArgsConstructor, @ToString 은 필요 없어 보임 (본 영상에서는 다 적혀있음)

- @Builder : ~ + Builder 라는 내부에 Class 생성 -> set(Builder 에 대한) + NoArgsConstructor + AllArgsConstructor + build + toString(~ + Builder 문구가 추가)
  >> build method 를 위한 기능인 것 같은데 @Data + @AllArgsConstructor 와 유사해 보여서 정확하게 어떠한 목적을 위한 것인지 모르겠음
 */
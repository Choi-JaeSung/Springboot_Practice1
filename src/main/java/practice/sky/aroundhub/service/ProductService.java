package practice.sky.aroundhub.service;

import practice.sky.aroundhub.data.dto.ProductDto;

public interface ProductService
{
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    ProductDto getProduct(String productId);
}

/*
- Use cuppling : Interface + InterfaceImpl 로 분리하여 작성하는 방식
  >> 개발의 변동이 있을 시 Interface 에 연결 해놓기 때문에 동작 구조는 변경하지 않고 Impl 부분만 변동한 형식에 맞게 변경만 하면 된다 (유지보수에 도움)
     >> (ex: MariaDB 쓰다가 PostSQL... 로 바꿀 때)
 */
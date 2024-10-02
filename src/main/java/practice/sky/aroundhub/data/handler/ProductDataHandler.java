package practice.sky.aroundhub.data.handler;

import practice.sky.aroundhub.data.entity.ProductEntity;


public interface ProductDataHandler
{
    ProductEntity saveProductEntity(String productId, String productName, int productPrice, int productStock);
    ProductEntity getProductEntity(String productId);
}

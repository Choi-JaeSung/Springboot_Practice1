package practice.sky.aroundhub.data.dao;

import practice.sky.aroundhub.data.entity.ProductEntity;

public interface ProductDAO
{
    ProductEntity saveProduct(ProductEntity productEntity);
    ProductEntity getProduct(String productId);
}

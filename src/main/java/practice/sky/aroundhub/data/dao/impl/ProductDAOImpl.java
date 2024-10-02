package practice.sky.aroundhub.data.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import practice.sky.aroundhub.data.dao.ProductDAO;
import practice.sky.aroundhub.data.entity.ProductEntity;
import practice.sky.aroundhub.data.repository.ProductRepository;

@Service
public class ProductDAOImpl implements ProductDAO
{
    ProductRepository productRepository;


    @Autowired
    public ProductDAOImpl(ProductRepository productRepository)
    {
        this.productRepository = productRepository;
    }


    @Override
    public ProductEntity saveProduct(ProductEntity productEntity)
    {
        productRepository.save(productEntity);
        return productEntity;
    }


    @Override
    public ProductEntity getProduct(String productId)
    {
        ProductEntity productEntity = productRepository.getById(productId);
        return productEntity;
    }
}

/*
- @Autowired : Springboot 에서 여러 곳에 사용되는 Repository 를 미리 Bean (선언)하여 여러 곳에서 사용가능
 */
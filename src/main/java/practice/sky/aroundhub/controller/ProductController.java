package practice.sky.aroundhub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.sky.aroundhub.data.dto.ProductDto;
import practice.sky.aroundhub.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class ProductController
{
    private ProductService productService;


    @Autowired
    public ProductController(ProductService productService)
    {
        this.productService = productService;
    }


    // http://localhost:8080/api/v1/product-api/product/{productId}
    @GetMapping(value = "/product/{productId}")
    public ProductDto getProduct(@PathVariable String productId)
    {
        return productService.getProduct(productId);
    }


    // http://localhost:8080/api/v1/product-api/product
    @PostMapping(value = "/product")
    public ProductDto createProduct(@RequestBody ProductDto productDto)
    {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }


    // http://localhost:8080/api/v1/product-api/product/{productId}
    @DeleteMapping(value = "/product/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId)
    {
        return null;
    }
}

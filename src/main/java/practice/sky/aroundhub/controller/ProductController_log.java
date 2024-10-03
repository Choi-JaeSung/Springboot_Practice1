package practice.sky.aroundhub.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import practice.sky.aroundhub.data.dto.ProductDto;
import practice.sky.aroundhub.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class ProductController_log
{
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController_log.class);

    private ProductService productService;


    @Autowired
    public ProductController_log(ProductService productService)
    {
        this.productService = productService;
    }


    // http://localhost:8080/api/v1/product-api/product-log/{productId}
    @GetMapping(value = "/product-log/{productId}")
    public ProductDto getProduct(@PathVariable String productId)
    {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController_log] perform {} of Around Hub API", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info("[ProductController_log] Response :: productId = {}, productName = {}, productPrice = {} productStock = {}, Response Time = {}ms",
                      productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(), (System.currentTimeMillis() - startTime));
        return productService.getProduct(productId);
    }


    // http://localhost:8080/api/v1/product-api/product-log
    @PostMapping(value = "/product-log")
    public ProductDto createProduct(@RequestBody ProductDto productDto)
    {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        return productService.saveProduct(productId, productName, productPrice, productStock);
    }


    // http://localhost:8080/api/v1/product-api/product-log/{productId}
    @DeleteMapping(value = "/produc-log/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId)
    {
        return null;
    }
}

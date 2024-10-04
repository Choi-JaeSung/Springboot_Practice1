package practice.sky.aroundhub.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.sky.aroundhub.common.Constants;
import practice.sky.aroundhub.common.exception.AroundHubException;
import practice.sky.aroundhub.data.dto.ProductDto;
import practice.sky.aroundhub.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class ProductController_exception
{
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController_validation.class);
    private ProductService productService;


    @Autowired
    public ProductController_exception(ProductService productService)
    {
        this.productService = productService;
    }


    // http://localhost:8080/api/v1/product-api/product-exception/{productId}
    @GetMapping(value = "/product-exception/{productId}")
    public ProductDto getProduct(@PathVariable String productId)
    {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController_validation] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info("[ProductController_validation] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(), (System.currentTimeMillis() - startTime));

        return productService.getProduct(productId);
    }


    // http://localhost:8080/api/v1/product-api/product-exception
    @PostMapping(value = "/product-exception")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto)   // @Valid : ProductDto 에서 설정한 @NotNull, @Min, @Max, ... 의 형식으로 검증 선언
    {
        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock());

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }


    // http://localhost:8080/api/v1/product-api/product-exception/{productId}
    @DeleteMapping(value = "/product-exception/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId)
    {
        return null;
    }


    // http://localhost:8080/api/v1/product-api/product-exception/exception
    @PostMapping(value = "/product-exception/exception")
    public void exceptionTest() throws AroundHubException
    {
        throw new AroundHubException(Constants.ExceptionClass.PRODUCT, HttpStatus.FORBIDDEN, "의도한 에러가 발생했습니다.");
    }
}

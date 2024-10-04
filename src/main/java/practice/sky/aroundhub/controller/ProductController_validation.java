package practice.sky.aroundhub.controller;

import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import practice.sky.aroundhub.data.dto.ProductDto;
import practice.sky.aroundhub.service.ProductService;

@RestController
@RequestMapping(value = "/api/v1/product-api")
public class ProductController_validation
{
    private final Logger LOGGER = LoggerFactory.getLogger(ProductController_validation.class);
    private ProductService productService;


    @Autowired
    public ProductController_validation(ProductService productService)
    {
        this.productService = productService;
    }


    // http://localhost:8080/api/v1/product-api/product-validation/{productId}
    @GetMapping(value = "/product-validation/{productId}")
    public ProductDto getProduct(@PathVariable String productId)
    {
        long startTime = System.currentTimeMillis();
        LOGGER.info("[ProductController_validation] perform {} of Around Hub API.", "getProduct");

        ProductDto productDto = productService.getProduct(productId);

        LOGGER.info("[ProductController_validation] Response :: productId = {}, productName = {}, productPrice = {}, productStock = {}, Response Time = {}ms",
                      productDto.getProductId(), productDto.getProductName(), productDto.getProductPrice(), productDto.getProductStock(), (System.currentTimeMillis() - startTime));

        return productService.getProduct(productId);
    }


    // http://localhost:8080/api/v1/product-api/product-validation
    @PostMapping(value = "/product-validation")
    public ResponseEntity<ProductDto> createProduct(@Valid @RequestBody ProductDto productDto)   // @Valid : ProductDto 에서 설정한 @NotNull, @Min, @Max, ... 의 형식으로 검증 선언
    {
//        // Validation Code Example   >> @Valid 를 사용 X or @Valid 가 못 잡는 경우를 보완하기 위해 하드 코딩 하는 경우도 많음 -> 다른 Controller 의 method 에서도 필요하기 때문에 반복 된 코드가 여러 개 생겨서 코드가 복잡해짐
//        if (productDto.getProductId().equals("") || productDto.getProductId().isEmpty())
//        {
//            LOGGER.error("[createProduct] failed Response :: productId is Empty");
//
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(productDto);
//        }

        String productId = productDto.getProductId();
        String productName = productDto.getProductName();
        int productPrice = productDto.getProductPrice();
        int productStock = productDto.getProductStock();

        ProductDto response = productService.saveProduct(productId, productName, productPrice, productStock);

        LOGGER.info("[createProduct] Response >> productId : {}, productName : {}, productPrice : {}, productStock : {}",
                response.getProductId(), response.getProductName(), response.getProductPrice(), response.getProductStock());

        return  ResponseEntity.status(HttpStatus.OK).body(response);
    }


    // http://localhost:8080/api/v1/product-api/product-validation/{productId}
    @DeleteMapping(value = "/product-validation/{productId}")
    public ProductDto deleteProduct(@PathVariable String productId)
    {
        return null;
    }
}

/*
- @Valid : 검증 선언
  >> 하드 코딩 보다 @Valid 와 같은 annotation 을 활용하여 코드 복잡성을 낮추고 가독성도 높이자
 */
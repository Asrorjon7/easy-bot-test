package com.test.easybot.controller;

import com.test.easybot.dto.ProductDTO;
import com.test.easybot.entity.ProductTypeEnum;
import com.test.easybot.entity.Product;
import com.test.easybot.repository.ProductRepository;
import com.test.easybot.service.ProductExtraServiceImpl;
import com.test.easybot.service.ProductServiceImpl;
import com.test.easybot.util.ProductRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@Tag(name = "ProductController", description = "zer")
@RequiredArgsConstructor
@RequestMapping("/api/products")
public class ProductController {
    private final ProductServiceImpl productServiceImpl;
    private final ProductExtraServiceImpl productExtraService;
    private final ProductRepository productRepository;

    @Operation(summary = "Добавляет информацию к продукту")
    @PostMapping("/add")
    public ProductDTO addProduct(@Valid @RequestBody ProductRequest productRequest) {
        productExtraService.addDetail(productRequest.getProductExtraDetails());
        return productServiceImpl.addProduct(
                Product.builder()
                        .serialNumber(productRequest.getSerialNumber())
                        .manufacturer(productRequest.getManufacturer())
                        .price(productRequest.getPrice())
                        .quantity(productRequest.getQuantity())
                        .productType(productRequest.getProductType())
                        .productExtra(productRequest.getProductExtraDetails())
                        .build());
    }
    @Operation(summary = "Изменяет информацию о продукте")
    @PutMapping("/update")
    public ProductDTO updateProduct(@Valid @RequestBody ProductRequest productRequest) {
        return productServiceImpl.addProduct(
                Product.builder()
                        .id(productRequest.getId())
                        .serialNumber(productRequest.getSerialNumber())
                        .manufacturer(productRequest.getManufacturer())
                        .price(productRequest.getPrice())
                        .quantity(productRequest.getQuantity())
                        .productType(productRequest.getProductType())
                        .productExtra(productRequest.getProductExtraDetails())
                        .build());
    }
    @Operation(summary = "Показывает все продукты")
    @GetMapping("/all")
    public List<ProductDTO> getAll() {
        return productServiceImpl.getAllProducts();
    }
    @Operation(summary = "Отображает продукты по типу продукта Enum : PC,LAPTOP,MONITOR,HARD_DRIVE,")
    @GetMapping("/{typeEnum}")
    public List<ProductDTO> getByCategory(@Valid @PathVariable("typeEnum") String category) {

        return productServiceImpl.getProductsByProductType(ProductTypeEnum.valueOf(category));
    }

    @Operation(summary = "Отображает информацию по идентификатору продукта")
    @GetMapping("/product/{id}")
    private ProductDTO getProductById(@PathVariable("id") Long id) {
        if (!productServiceImpl.getProductById(id).isPresent()) {
            return null;
        }
        return productServiceImpl.getProductById(id).get();
    }
}

package com.test.easybot.service.impl;

import com.test.easybot.dto.ProductDTO;
import com.test.easybot.entity.ProductTypeEnum;
import com.test.easybot.entity.Product;
import java.util.List;
import java.util.Optional;

public interface ProductService {
    ProductDTO addProduct(Product product);

    List<ProductDTO> getAllProducts();

    List<ProductDTO> getProductsByProductType(ProductTypeEnum productTypeEnum);

    public Optional<ProductDTO> getProductById(Long id);
}

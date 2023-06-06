package com.test.easybot.service;

import com.test.easybot.dto.ProductDTO;
import com.test.easybot.entity.ProductTypeEnum;
import com.test.easybot.entity.Product;
import com.test.easybot.mappers.ProductMapper;
import com.test.easybot.repository.ProductRepository;
import com.test.easybot.service.impl.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductDTO addProduct(Product product) {

        return ProductMapper.mapToProductDTO(productRepository.save(product));
    }

    @Override
    public List<ProductDTO> getAllProducts() {
        return ProductMapper.mapToProductDTO(productRepository.findAll());
    }

    @Override
    public List<ProductDTO> getProductsByProductType(ProductTypeEnum productTypeEnum) {
        return ProductMapper.mapToProductDTO(productRepository.findByProductType(productTypeEnum));
    }
    @Override
    public Optional<ProductDTO> getProductById(Long id) {
        var getProductById = productRepository.findById(id);
        return getProductById.map(ProductMapper::mapToProductDTO);
    }


}

package com.test.easybot.mappers;
import com.test.easybot.dto.ProductDTO;
import com.test.easybot.entity.Product;
import java.util.List;

public class ProductMapper {
    public static ProductDTO mapToProductDTO(Product product) {
          return ProductDTO.builder()
                .id(product.getId())
                .serialNumber(product.getSerialNumber())
                .manufacturer(product.getManufacturer())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .productType(product.getProductType().getName())
                .productExtraDTOList(ProductExtraMapper.mapToExtraProductDTO(product.getProductExtra()))
                .build();
    }
    public static List<ProductDTO>mapToProductDTO(List<Product> product) {
         return product.stream().map(ProductMapper::mapToProductDTO).toList();
    }
}

package com.test.easybot.repository;

import com.test.easybot.entity.ProductTypeEnum;
import com.test.easybot.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findByProductType(ProductTypeEnum productTypeEnum);
    Optional<Product> findById(Long id);
}

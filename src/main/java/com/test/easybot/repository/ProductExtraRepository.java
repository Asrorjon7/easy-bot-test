package com.test.easybot.repository;

import com.test.easybot.entity.ProductExtraDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductExtraRepository extends JpaRepository<ProductExtraDetails,Long> {

}

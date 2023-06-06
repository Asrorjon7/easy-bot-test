package com.test.easybot.service;

import com.test.easybot.entity.ProductExtraDetails;
import com.test.easybot.repository.ProductExtraRepository;
import com.test.easybot.service.impl.ProductExtraService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductExtraServiceImpl implements ProductExtraService {

    private final ProductExtraRepository productExtraRepository;



    @Override
    public List<ProductExtraDetails> addDetail(List<ProductExtraDetails> productExtraDetails) {
        return  productExtraRepository.saveAll(productExtraDetails);
    }
}

package com.test.easybot.mappers;



import com.test.easybot.dto.ProductExtraDTO;
import com.test.easybot.entity.ProductExtraDetails;

import java.util.List;


public class ProductExtraMapper {

    public static List<ProductExtraDTO> mapToExtraProductDTO(List<ProductExtraDetails> productExtraDetails) {
        return productExtraDetails.stream().map(extraDetail -> ProductExtraDTO.builder()
                .id(extraDetail.getId())
                .detailName(extraDetail.getDetailName())
                .detailValue(extraDetail.getDetailValue())
                .build()).toList();

    }

}

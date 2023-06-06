package com.test.easybot.util;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Schema(name = "Product Extra Details", description = "Отправить в Product API")
public class ProductExtraRequest {
    @Schema(name = "detailName", required = true, allowableValues = "form-factor")
    private String detailName;
    @Schema(name = "detailValue", required = true, allowableValues = "Desktop")
    private String detailValue;
}

package com.test.easybot.util;

import com.test.easybot.entity.ProductTypeEnum;
import com.test.easybot.entity.ProductExtraDetails;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Schema(name = "Product Request", description = "Отправить в Product API")

public class ProductRequest {
    private Long id;
    @NotNull(message = "Enter Serial Number")
    @Schema(name = "serialNumber", required = true, allowableValues = "xxxx")
    private String serialNumber;
    @NotNull(message = "Enter Manufacturer")
    @Schema(name = "manufacturer", required = true, allowableValues = "Easy bot")
    private String manufacturer;
    @NotNull(message = "Enter Price")
    @Schema(name = "price", required = true, allowableValues = "1000")
    private double price;
    @NotNull(message = "Enter Quantity")
    @Schema(name = "quantity", required = true, allowableValues = "1000")
    private int quantity;
    @NotNull(message = "Enter Product Type: PC,LAPTOP,HARD_DRIVE,MONITOR")
    @Schema(name = "productType", required = true, allowableValues = "LAPTOP")
    private ProductTypeEnum productType;
     private List<ProductExtraDetails> productExtraDetails;
}

package com.test.easybot.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;
@Entity
@Data
@AllArgsConstructor
@RequiredArgsConstructor
@Builder
@Table(name = "product_extra")
public class ProductExtraDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Schema(hidden = true)
    private Integer id;

    @Schema(name = "detailName", required = true, allowableValues = "form-factor")
    @Column(name = "detailName")
    private String detailName;
    @Schema(name = "detailValue", required = true, allowableValues = "Desktop")
    @Column(name = "detailValue")
    private String detailValue;

}

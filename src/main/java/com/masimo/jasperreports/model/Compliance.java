package com.masimo.jasperreports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Compliance {
    private String catogeryType;
    private float catogeryValue;
}

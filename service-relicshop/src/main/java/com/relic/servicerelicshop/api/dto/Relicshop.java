package com.relic.servicerelicshop.api.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Relicshop {
    private String relic_name;
    private long goldPrice;
    private long platinumPrice;
    private String buff;
    private String description;
}

package com.worldline.interview;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public enum FuelType {
  PETROL("PETROL", BigDecimal.valueOf(9)),
  DIESEL("DIESEL", BigDecimal.valueOf(12)),
  WOOD("WOOD", BigDecimal.valueOf(4.35)),
  COAL("COAL", BigDecimal.valueOf(5.65));

  private final String name;
  private BigDecimal cost;
}

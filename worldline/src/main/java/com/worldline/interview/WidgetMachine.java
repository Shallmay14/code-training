package com.worldline.interview;

import com.worldline.interview.engine.WidgetEngine;

import java.math.BigDecimal;

public class WidgetMachine {
  private WidgetEngine engine;

  public WidgetMachine(WidgetEngine engine) {
    this.engine = engine;
  }

  public BigDecimal produceWidgets(int quantity) {
    engine.start();
    BigDecimal cost = BigDecimal.ZERO.stripTrailingZeros();

    if (engine.isRunning()) {
      cost = produce(quantity);
    }

    engine.stop();

    return cost;
  }

  private BigDecimal produce(int quantity) {
    int batch = 0;
    int batchCount = 0;
    FuelType fuelType = engine.getFuelType();
    BigDecimal costPerBatch = fuelType.getCost();

    while (batch < quantity) {
      batch = batch + engine.getBatchSize();
      batchCount++;
    }

    return BigDecimal.valueOf(batchCount).multiply(costPerBatch);
  }
}

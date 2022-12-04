package com.worldline.interview.engine;

import com.worldline.interview.FuelType;

import java.util.Arrays;
import java.util.List;

public class InternalCombustionEngine extends WidgetEngine {

  private List<FuelType> availableFuelType = Arrays.asList(FuelType.PETROL, FuelType.DIESEL);

  public InternalCombustionEngine(FuelType requiredFuelType) {
    super(requiredFuelType);
    batchSize = 8;

    if (!availableFuelType.contains(requiredFuelType)) {
      throw new IllegalArgumentException(
          this.getClass().getSimpleName() + " cannot be fueled with " + requiredFuelType.getName() + ".");
    }
  }
}

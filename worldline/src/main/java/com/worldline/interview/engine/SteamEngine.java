package com.worldline.interview.engine;

import com.worldline.interview.FuelType;

import java.util.Arrays;
import java.util.List;

public class SteamEngine extends WidgetEngine {

  private List<FuelType> availableFuelType = Arrays.asList(FuelType.WOOD, FuelType.COAL);

  public SteamEngine(FuelType requiredFuelType) {
    super(requiredFuelType);
    batchSize = 2;

    if (!availableFuelType.contains(requiredFuelType)) {
      throw new IllegalArgumentException(
          this.getClass().getSimpleName() + " cannot be fueled with " + requiredFuelType.getName() + ".");
    }
  }
}

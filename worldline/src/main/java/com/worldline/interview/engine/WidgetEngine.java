package com.worldline.interview.engine;

import com.worldline.interview.FuelType;
import lombok.Data;

@Data
public class WidgetEngine {

  protected int batchSize;
  protected FuelType requiredFuelType;
  protected FuelType fuelType;
  protected int fuelLevel;
  protected boolean running;

  protected WidgetEngine(FuelType requiredFuelType) {
    this.requiredFuelType = requiredFuelType;
    running = false;
    fuelLevel = 0;
  }

  public void start() {
    if (fuelLevel > 0 && requiredFuelType.equals(fuelType)) {
      running = true;
    } else {
      throw new IllegalStateException("Not able to start engine.");
    }
  }

  public void stop() {
    running = false;
  }

  public int fill(FuelType fuelType, int fuelLevel) {
    if (!requiredFuelType.equals(fuelType)) {
      throw new IllegalArgumentException(
          this.getClass().getSimpleName() + " cannot be fueled with " + fuelType.getName() + ".");
    }

    this.fuelType = fuelType;

    if (fuelLevel >= 0 && fuelLevel <= 100) {
      this.fuelLevel = fuelLevel;
    } else if (fuelLevel > 100) {
      this.fuelLevel = 100;
      return fuelLevel - 100;
    } else {
      this.fuelLevel = 0;
    }

    return 0;
  }
}

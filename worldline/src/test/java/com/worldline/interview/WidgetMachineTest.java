package com.worldline.interview;

import com.worldline.interview.engine.SteamEngine;
import com.worldline.interview.engine.WidgetEngine;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

public class WidgetMachineTest {
  private WidgetEngine engine;

  @ParameterizedTest
  @EnumSource(
      value = FuelType.class,
      names = {"PETROL", "DIESEL"})
  void givenWrongFuelType_thenIllegalArgumentException(FuelType requiredFuelType) {
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> {
          engine = new SteamEngine(requiredFuelType);
        });
    assertTrue(thrown.getMessage().contains(requiredFuelType.getName()));
  }

  @ParameterizedTest
  @EnumSource(
      value = FuelType.class,
      names = {"WOOD", "COAL"})
  void givenNoFuel_whenProduce_thenIllegalStateException(FuelType fuelType) {
    engine = new SteamEngine(fuelType);
    WidgetMachine machine = new WidgetMachine(engine);
    IllegalStateException thrown =
        assertThrows(
            IllegalStateException.class,
            () -> {
              machine.produceWidgets(100);
            });
    assertEquals("Not able to start engine.", thrown.getMessage());
  }

  @Test
  void givenNegativeQuantity_whenProduce_thenIllegalArgumentException() {
    engine = new SteamEngine(FuelType.WOOD);
    WidgetMachine machine = new WidgetMachine(engine);
    IllegalArgumentException thrown = assertThrows(
        IllegalArgumentException.class,
        () -> {
          machine.produceWidgets(-1);
        });
    assertEquals("Quantity needs to be 0 and above.", thrown.getMessage());
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 99, 100, 10000})
  void givenWood_whenProduce_thenReturnsTheCost(int quantity) {
    givenFuel_whenProduce_thenReturnsTheCost(FuelType.WOOD, quantity);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 99, 100, 10000})
  void givenCoal_whenProduce_thenReturnsTheCost(int quantity) {
    givenFuel_whenProduce_thenReturnsTheCost(FuelType.COAL, quantity);
  }

  private void givenFuel_whenProduce_thenReturnsTheCost(FuelType fuelType, int quantity) {
    engine = new SteamEngine(fuelType);
    WidgetMachine machine = new WidgetMachine(engine);
    machine.fill(100);
    int batchCount = quantity / engine.getBatchSize();
    if (quantity % engine.getBatchSize() > 0) batchCount++;
    assertEquals(
        BigDecimal.valueOf(batchCount).multiply(fuelType.getCost()),
        machine.produceWidgets(quantity));
  }
}

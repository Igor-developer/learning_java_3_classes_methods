package com.company;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Car {

    private String model;
    private int consumption;
    private float currentTankVolume;
    private float tankVolume;

    public Car(String model, int consumption, float current_tank_volume, float tank_volume) {
        this.model = model;
        this.consumption = consumption;
        this.currentTankVolume = current_tank_volume;
        this.tankVolume = tank_volume;
    }

    public void fueling(float fuel_volume) {
        if (fuel_volume < 0) {
            System.out.println("Введено отрицательное значение. " +
                    "Вы хотите слить бензин из бака? " +
                    "Это запрещено!");
            return;
        }

        if (fuel_volume + currentTankVolume > tankVolume) {
            currentTankVolume = tankVolume;
        } else {
            currentTankVolume += fuel_volume;
        }
    }

    public void trip(double distance) {
        if (distance < 0) {
            System.out.println("Введено отрицательное значение для дистанции поездки!");
            return;
        } else {
            System.out.print("Автомобиль " + getModel() + " выехал на расстояние " + distance + " км");
        }

        double possibility_distance = currentTankVolume / consumption * 100;

        if (distance < possibility_distance) {
            currentTankVolume -= (float) (distance * consumption / 100);
            System.out.println(
                    " и успешно добрался до пункта назначения; остаток бензина на конец поездки - "
                            + getCurrentTankVolume() + " л.");
        } else {
            currentTankVolume = 0F;
            System.out.println(
                    ", но топливо в баке закончилось уже через "
                            + new BigDecimal(possibility_distance).setScale(2, RoundingMode.HALF_UP).doubleValue()
                            + " км.");
        }
    }

    public String getModel() {

        return model;
    }

    public int getConsumption() {

        return consumption;
    }

    public float getCurrentTankVolume() {

        return new BigDecimal(currentTankVolume).setScale(2, RoundingMode.HALF_UP).floatValue();
    }

    public float getTankVolume() {

        return new BigDecimal(tankVolume).setScale(2, RoundingMode.HALF_UP).floatValue();
    }
}
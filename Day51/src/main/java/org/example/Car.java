package org.example;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionMap;

public class MapClassEx {
    private static final AionMap<Integer, car> cars = new AionMap();

@Callable
    public static void addCar(String make, String model,String color)
    {
        car newCar = new car();
        newCar.make = make;
        newCar.model = model;
        newCar.color = color;
        cars.put(cars.size(), newCar);
    }
    @Callable
    public static AionMap getCar(int id) {
        return cars.get(id);
    }

    @Callable
    public static String carToFrontend(int id) {
        return "Make: " + cars.get(id).make + " | Model: " + cars.get(id).model + " | Color: " + cars.get(id).color;
    }

}



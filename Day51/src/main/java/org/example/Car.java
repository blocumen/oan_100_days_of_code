package org.example;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionMap;

public class Car {
    private static final AionMap<Integer,Car> cars = new AionMap();
    private String make,model,color;

@Callable
    public static void addCar(String make, String model,String color)
    {
        Car newCar = new Car();
        newCar.make = make;
        newCar.model = model;
        newCar.color = color;
        cars.put(cars.size(), newCar);
    }

    @Callable
    public static String carToFrontend(int id) {
        return "Make: " + cars.get(id).make + " | Model: " + cars.get(id).model + " | Color: " + cars.get(id).color;
    }

}



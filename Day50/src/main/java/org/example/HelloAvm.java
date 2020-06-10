package org.example;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;


public class HelloAvm
{
    private static String myStr = "Hello AVM";
    private static AionList<String> carList = new AionList<>();
    private static AionList<String> carListCopy = new AionList<>();
    private static AionList<String> carSubList = new AionList<>();
    @Callable
    public static void addCar(String newCarBrand) {
        carList.add(newCarBrand);
    }
    @Callable
    public static void removeCar(String carBrand) {
        carList.remove(carBrand);
    }
    @Callable
    public static void clearCarSet() {
        carList.clear();
    }
    @Callable
    public static boolean checkCar(String carBrand) {
        return carList.contains(carBrand);
    }
    @Callable
    public static boolean carListIsEmpty() {
        return carListCopy.isEmpty() ? true: false;
    }


    @Callable
    public static void sayHello() {
        Blockchain.println("Hello Avm");
    }

    @Callable
    public static String greet(String name) {
        return "Hello " + name;
    }

    @Callable
    public static String getString() {
        Blockchain.println("Current string is " + myStr);
        return myStr;
    }

    @Callable
    public static void setString(String newStr) {
        myStr = newStr;
        Blockchain.println("New string is " + myStr);
    }

}

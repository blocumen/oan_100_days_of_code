package org.example;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;

public class GetSet
{

    // Create an empty address variable
    private static Address owner;
    private static String myStr = "Hello AVM";

//    @Initializable
//    private static String myStr;
//    private static String myStr = "String is not set yet";

    static {
        // Set the owner of this contract as the address that deployed it. This cannot be altered.
        owner = Blockchain.getCaller();
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
        onlyOwner();
        validateDifferenceInRemainingEnergy ();
        myStr = newStr;
        Blockchain.println("New string is " + myStr);
    }

    @Callable
    public static void multiplyBy10 (int newInt) {
        Blockchain.println("Multiplied by 10: " + newInt*10);
    }

    @Callable
    public static String setPrintReturnEventCaller () {
        Address eventCaller = Blockchain.getCaller();
        Blockchain.println("Event caller: "+ eventCaller.toString());
        return eventCaller.toString();
    }

    // Check if the current caller of a function matches the owner address.
    private static void onlyOwner () {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }

    public static void validateDifferenceInRemainingEnergy () {

        long remainingEnergy = Blockchain.getRemainingEnergy();

        Blockchain.println("initial energy:" + remainingEnergy);

        int a = 100;
        int b = 20;
        int sum = a + b;

        Blockchain.println("remaining energy:" + Blockchain.getRemainingEnergy());
    }

}

package org.example;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import avm.Address;

public class ClassBlockchain
{
    private static String myStr = "Hello AVM";
    private static Address owner;

    static { owner = Blockchain.getCaller();}

    @Callable
    public static String getString() {
        //Blockchain.println("owner " + owner);
        Blockchain.println("caller  "+Blockchain.getCaller());
        return myStr;
    }

    @Callable
    public static void setString(String newStr) {
        onlyOwner();
        myStr = newStr;
        Blockchain.println("New string is " + myStr);
    }
    private  static void onlyOwner()
    {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }
    @Callable
    public static void differenceInenergy()
    {
        long remainingEnergy = Blockchain.getRemainingEnergy();
        Blockchain.println("Initial Energy "+ remainingEnergy);
        int a =10;
        int b=20;
        int sum = a+b;
        Blockchain.println("Remaining Energy"+Blockchain.getRemainingEnergy());

    }

}

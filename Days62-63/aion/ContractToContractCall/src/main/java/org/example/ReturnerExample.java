package org.example;
import avm.Address;
import avm.Blockchain;
import org.example.avm.tooling.abi.Callable;
import org.example.avm.userlib.abi.ABIDecoder;

public class ReturnerExample {
    @Callable
    public static String getString(int index) {
        String[] myStr = { "Hello AVM!", "AVM is great" };
        return myStr[index];
    }
}
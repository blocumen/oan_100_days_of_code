package aion.contracts;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
//Write a method which would multiple a number by 10 and return the value.
public class Day47 {
    @Callable
    public static int multipleOf10(int num){
        Blockchain.print("The Number is " + num);
        return (num * 10);
    }
}

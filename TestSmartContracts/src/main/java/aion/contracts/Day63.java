package aion.contracts;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.abi.ABIDecoder;

public class Day63 {
    //String variable to store string from deployment arguments
    private static String deployedString;
    //Integer variable to store int from deployment argument
    private static int deployedInteger;

    static {
        ABIDecoder decoder = new ABIDecoder(Blockchain.getData());
        deployedInteger = decoder.decodeOneInteger();
        deployedString = decoder.decodeOneString();
    }

    @Callable
    public static int getDeployedInteger(){
        return deployedInteger;
    }

    @Callable
    public static String getDeployedString(){
        return deployedString;
    }
}

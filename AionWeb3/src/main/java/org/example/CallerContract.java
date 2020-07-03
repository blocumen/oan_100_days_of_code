package org.example;
import avm.Address;
import avm.Blockchain;
import avm.Result;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.abi.ABIDecoder;
import org.aion.avm.userlib.abi.ABIEncoder;
import org.aion.avm.userlib.abi.ABIStreamingEncoder;

import java.math.BigInteger;

public class CallerContract {
    public static int count=0;
    private static Address returnerContractAddress;

    static {
        ABIDecoder decoder = new ABIDecoder(Blockchain.getData());
        returnerContractAddress = decoder.decodeOneAddress();
        //Set the contract address that you want to call
    }

/*    @Callable
    public static Address getReturnerContractAddress() {
        return returnerContractAddress;
    }*/

    @Callable
    public static String getCallerAddress() {
        ABIStreamingEncoder encoder = new ABIStreamingEncoder();
        byte[] data = encoder.encodeOneString("getString")
                .toBytes();
        //.encodeOneInteger()
        Result getString = Blockchain.call(returnerContractAddress, BigInteger.ZERO, data, Blockchain.getRemainingEnergy());
        ABIDecoder decoder = new ABIDecoder(getString.getReturnData());
        String myString = decoder.decodeOneString();
        return myString;

    }
    @Callable
    public static int incrementCount() {

        Blockchain.require(Blockchain.getCaller().equals(getCallerAddress()));
        count++;
        return count;

    }
}
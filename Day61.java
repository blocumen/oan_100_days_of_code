package org.example;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionMap;
import org.aion.avm.userlib.abi.ABIDecoder;

public class Day61
{
    private static Address owner, eventCaller;
    private static String myStr;
    private static final int myInt;
//    private static final int[][] myTwoDIntArray;

    static {
        ABIDecoder decoder = new ABIDecoder(Blockchain.getData());
        myStr = decoder.decodeOneString();
        myInt = decoder.decodeOneInteger();

        Blockchain.println("staticStr "+myStr);
        Blockchain.println("staticInt "+myInt);

//        myTwoDIntArray = decoder.decodeOne2DIntegerArray();

        owner = Blockchain.getCaller();
        eventCaller = Blockchain.getCaller();
    }

    private static AionMap<Integer, Address> addressMap = new AionMap();


    @Callable
    public static void addAddressesToTheMap () {
        addressMap.put (addressMap.size(), owner);
        addressMap.put (addressMap.size(), eventCaller);
    }

    @Callable
    public static void AssignTokens(int number, String str) {

        Blockchain.println("Print number "+number);
        Blockchain.println("Print string "+str);

    }
}

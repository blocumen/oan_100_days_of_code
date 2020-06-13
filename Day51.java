package org.example;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionMap;

public class Day51
{
    private static Address owner, eventCaller;

    static {
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
    public static void AssignTokens(int number) {

        if (addressMap.containsKey(number) == true ) {
            //revert
            Blockchain.println("Doing Nothing "+addressMap.size());
        } else {
            addressMap.put (number, new Address(new byte[32]));
            Blockchain.println("Insert new pair "+addressMap.size());
        }
    }


}

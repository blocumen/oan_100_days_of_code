package org.example;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionMap;

public class TokenAssignment {

    public static AionMap<Address , Integer> balances = new AionMap();

    @Callable
    public static void assignToken(Address address,int token)
    {
        if(!balances.containsKey(address))
            balances.put(address,token);
        else
            Blockchain.print("Address already assigned value" +address);
    }
    @Callable
    public static int getBlances(Address address)
    {
        Blockchain.println("Balance of address" +address+" - "+ balances.get(address));
        return balances.get(address);

    }

}

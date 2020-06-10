package org.example;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import avm.Address;
import org.aion.avm.userlib.AionList;

public class ListAssignment {

    public static AionList  listOfAddress = new AionList();

    @Callable
    public static void setListOfAddress(Address address)
    {
        if(!listOfAddress.contains(address))
            listOfAddress.add(address);
        else
            Blockchain.print("Address already in the list"+address);

    }
    @Callable
    public static void removefromlist(Address address)
    {
        listOfAddress.remove(address);
    }

    @Callable
    public static int listcount()
    {
        return listOfAddress.size();

    }
}

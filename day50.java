package org.example;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;

public class UserLibPackage
{
    private static Address owner, eventCaller;

    static {
        owner = Blockchain.getCaller();
        eventCaller = Blockchain.getCaller();
    }

    private static AionList<Address> addressList = new AionList<>();

    @Callable
    public static void addNewPublicAddressesToTheList () {
        addressList.add(owner);
        addressList.add(eventCaller);
    }

    @Callable
    public static void checkAndRemoveAddress () {
        Blockchain.println("Number of element: "+ addressList.size());

        if(addressList.contains(owner) == true) {
            addressList.remove(addressList.indexOf(owner));
        }
        Blockchain.println("Number of element: "+ addressList.size());
    }

}

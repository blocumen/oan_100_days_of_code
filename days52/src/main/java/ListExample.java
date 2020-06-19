package org.aion;
import avm.Blockchain;
import avm.Address;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;

public class ListExample
    private static AionList<String> addressList = new AionList<>();

    @Callable
    public static void addAddress(Address newAddress) {
        addressList.add(newAddress.toString());
    }

    @Callable
    public static int getSize() {
        return(addressList.size());

    }
    @Callable
    public static String removeAddress(Address address) {
        if (addressList.contains(address.toString())) {
            addressList.remove(address.toString());
            return ("address removed :"+ address.toString());
        }
        else
        {
            return("address not found in the list");
        }
    }








}
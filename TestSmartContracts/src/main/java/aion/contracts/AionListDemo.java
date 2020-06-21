//Create a contract which has two methods to add new public addresses to the list, check if the address exists and remove from the list. Also, it gives the total count of addresses in the list.
package aion.contracts;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;

import java.util.ListIterator;

public class AionListDemo {
    private static AionList<Address> contractAddressList = new AionList<>();
    private static ListIterator<Address> addressIterator = contractAddressList.listIterator();


    //function to add a particular address
    @Callable
    public static boolean addAddress(Address newAdd){
        if(contractAddressList.contains(newAdd)){
         return false;
        }else {
            contractAddressList.add(newAdd);
            return true;
        }
    }

    //Function to remove a particular address
    @Callable
    public static boolean removeAddress(Address rmAdd){
        if(contractAddressList.contains(rmAdd)){// Removes only of list contains the address, return false if it doesn't
            contractAddressList.remove(rmAdd);
            return true;
        }else {
            return false;
        }
    }

  @Callable
    public static void displayList(){
        String topic = "Address:";
        while (addressIterator.hasNext()){
            Blockchain.println("This is th address contained in the List:");
            Blockchain.println("Address : "+addressIterator.next().toString());
        }
  }
}


//
// a0b296a3a88d693ef735407cbc2fd29a50b8ff2cb1432a11a3668eb1e366080e	..
// a0da241d264c5849589b92e4e8e9f5a9d939d4e936fb291736e0298f4d2fa202	..
// a03aa55fece390d2789ae2aed01206b340e70c8007d4098a89457d101b207376	..
// a04967045eaa81396c5d3dc26eeab6154a370fed155bc95a443e56b9803029eb	..
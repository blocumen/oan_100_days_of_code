//All Blockchain classes methods demo
package aion.contracts;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;

public class BlockchainDemo {
    // Blockchain print statement
    private static String myStr;

    @Callable
    public static void setMsg(String name) {
        myStr =name;
        Blockchain.println("Good Morning " + myStr);
    }

    //caller() method
    @Callable
    public static String getContractCaller(){
        Address eventCaller = Blockchain.getCaller();
        Blockchain.println("Event Caller : " + eventCaller.toString());
        return eventCaller.toString();
    }

    //Blockchain.require()
    private static Address owner; //Address of the owner
    static {
    // Set the owner of this contract as the address that deployed it. This cannot be altered.
        owner = Blockchain.getCaller();
    }
    @Callable
    public static void setString(String newStr) {
        onlyOwner();
        myStr = newStr;
        Blockchain.println("New String Value " + myStr);
        Blockchain.println("owner data/address " + owner);
    }
    // Check if the current caller of a function matches the owner address.
    private static void onlyOwner() {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }

    //Blockchain.getRemainingEnergy();
    @Callable
    public static void validateDifferenceInRemainingEnergry() {
        long remainingEnergy = Blockchain.getRemainingEnergy();
        Blockchain.println("Initial Energy" + remainingEnergy);
        int a = 100;
        int b = 20;
        int sum = a + b;
        Blockchain.println("Remaining Energy"+Blockchain.getRemainingEnergy());
    }


}

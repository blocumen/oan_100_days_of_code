package aion.contracts;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
//Create a smart contract class. Add an initializable variable called status and provide a getter method which returns the value set during initialization.
public class Day46 {
    private static String status = "This is the current status";

    @Callable
    public static String getStatus() {
        Blockchain.println("Current status is " + status);
        return status;
    }
//a0b296a3a88d693ef735407cbc2fd29a50b8ff2cb1432a11a3668eb1e366080e
}

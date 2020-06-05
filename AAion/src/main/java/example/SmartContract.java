package example;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;


public class SmartContract {

    @Initializable
    private static String status;
    @Callable
    public static String getStr() {
        Blockchain.println(status);
        return status;
    }
    @Callable
    public static void setStr(String newStr) {
        status = newStr;
        Blockchain.println(status);
    }

   /* @Callable
    public static void setMsg(String name) {
        Blockchain.println("Good Morning " + name);
    }
    @Callable
    public static String setString(String newStr) {
        Address eventCaller = Blockchain.getCaller();
        Blockchain.println( "Event caller : ",eventCaller.toString());
        return eventCaller.toString();
    }*/

}

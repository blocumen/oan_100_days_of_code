package org.example;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
//import avm.Address;
public class BlockchainClassEx
{
    private static String myStr = "Hello AVM";
    //private static Address owner;
   /* static {
        owner = Blockchain.getCaller();
    } */
    @Callable
    private static String getString()
    {
        Blockchain.println("Mystring "+myStr);
        return myStr;
    }
    @Callable
    private static void setString(String newstr)
    {
      //  onlyOwner();
        myStr = newstr;
    }
   /* private static void onlyOwner()
    {
        Blockchain.require(Blockchain.getCaller().equals(owner));
    }*/

}

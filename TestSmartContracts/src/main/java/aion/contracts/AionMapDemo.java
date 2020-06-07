package aion.contracts;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;
import org.aion.avm.userlib.AionMap;

public class AionMapDemo {
   // private static AionList<Address> contractAddressList = new AionList<>();
    private static AionMap<Address,Integer> balances = new AionMap<>();
    @Callable
    public static boolean AssignToken(Address addr, int token){
        if(balances.containsKey(addr)){
            Blockchain.println("Token is already assigned to this address!");
            return false;
        }else{
            balances.put(addr,token);
            return true;
        }
    }

    @Callable
    public static int getToken(Address addr){
        if(balances.containsKey(addr)){
            return balances.get(addr);
        }else {
            Blockchain.println("There no value/token for this address!");
            return 0;
        }
    }
}

// a0b296a3a88d693ef735407cbc2fd29a50b8ff2cb1432a11a3668eb1e366080e	..
// a0da241d264c5849589b92e4e8e9f5a9d939d4e936fb291736e0298f4d2fa202	..
// a03aa55fece390d2789ae2aed01206b340e70c8007d4098a89457d101b207376	..
// a04967045eaa81396c5d3dc26eeab6154a370fed155bc95a443e56b9803029eb	..
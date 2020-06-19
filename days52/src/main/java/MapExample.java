package org.aion;
import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;
import org.aion.avm.userlib.AionMap;

public class MapExample
{
    private static AionMap<Address, Number> token = new AionMap<>();
    @Callable
    public static String assignTokens() {
        Address user = Blockchain.getCaller();
        boolean isPresent = token.containsKey(user);
        if(isPresent){
            return("token already assigned to this address");
        }
        else{
            token.put(user,10);
            return ("tokens issues to the address" + user.toString());


        }
    }

}
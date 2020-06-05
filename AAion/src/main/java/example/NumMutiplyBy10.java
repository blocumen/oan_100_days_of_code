package example;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;

public class NumMutiplyBy10 {
    @Initializable
    private static int myInt;

    @Callable
    public static int getMyInt() {
        Blockchain.println(String.valueOf(myInt*10));
        return myInt*10;

    }
}

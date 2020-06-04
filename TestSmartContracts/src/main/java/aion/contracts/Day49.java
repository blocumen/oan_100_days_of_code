package aion.contracts;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;

public class Day49 {
    private static Address deployerAddress = Blockchain.getCaller();

    private static void validateDeployer(){
        Blockchain.require(Blockchain.getCaller().equals(deployerAddress));
    }

    @Callable
    public static long fetchBlock(){
        validateDeployer();
        return Blockchain.getBlockNumber();
    }


}

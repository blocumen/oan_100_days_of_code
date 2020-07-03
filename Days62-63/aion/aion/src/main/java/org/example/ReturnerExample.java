package org.example;
import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.abi.ABIDecoder;

public class ReturnerExample {
    public static Address owner;
    static {
        //Set the caller address Owner
        owner = Blockchain.getCaller();
    }
    //Function to retrieve the Address

    @Callable
    public static Address getOwner() {
        return owner;
    }
}
//Contract Address: 0b2260914e069f3c38e1974bbdf0b7d7cfa3ecaf08622f917bed06f5d06cc194
//Deployer Address: 0xa092de3423a1e77f4c5f8500564e3601759143b7c0e652a7012d35eb67b283ca

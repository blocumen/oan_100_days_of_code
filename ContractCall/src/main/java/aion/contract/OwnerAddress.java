package aion.contract;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;

public class OwnerAddress {
    // To set the owner address of the contract
    public static Address owner;

    static {
        //Set the caller address to owner
        owner= Blockchain.getCaller();
    }

    //Function to retrieve the Address
    @Callable
    public static Address getOwner(){
        return owner;
    }
}
//0b43613dd9eb89f5bbc8dc42aa3bbaaa5b10162d631b975e01384dc3083b0df9
//0b79ae90799efe49afc00c7e75060bea63e7a54026619f41a4ad507b431b011f
//0b2260914e069f3c38e1974bbdf0b7d7cfa3ecaf08622f917bed06f5d06cc194
//0ba3b75af1fa99cb67110d072622e19067da375f070ffb3028bce290a94a9f7e
//0b955d6e63952ab1adb9dd22ad11d7ece6f84e842333c8babe9404dbb3b6cc1e
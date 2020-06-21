package aion.contracts;

import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;

public class SimpleOwnable {

    private static Address owner;
    private static Address newOwner;

    // Assign the log topic upon deployment.
    @Initializable
    private static String transferLogTopic;

    @Initializable
    private static String deployer;
//
//    public byte[] addr = Helpers.hexStringToBytes("a0b296a3a88d693ef735407cbc2fd29a50b8ff2cb1432a11a3668eb1e366080e");
//
//    public Address newadd = new Address(addr);
    static {
        // Assign the deployer as the owner.
        owner = Blockchain.getCaller();
        newOwner = new Address(new byte[32]);

        // Log the deployer upon deployment
        Blockchain.log(deployer.getBytes());
    }

    // Save the address of the new owner, wait for acceptance.
    @Callable
    public static void transferOwnership(Address newOwnerAddress) {
        Blockchain.require(Blockchain.getCaller().equals(owner));
        newOwner = newOwnerAddress;
        //owner = newOwner;
    }

    // New owner accepts the ownership. Update the owner address and log the transfer.
    @Callable
    public static void acceptOwnership() {
        Blockchain.require(Blockchain.getCaller().equals(newOwner));
        Blockchain.log(transferLogTopic.getBytes(), owner.toByteArray(), newOwner.toByteArray());
        owner = newOwner;
        newOwner = new Address(new byte[32]);
    }

    // Get the contract owner address.
    @Callable
    public static Address getOwnerAddress() {
        Blockchain.println(owner.toString());
        return owner;
    }
}

// a0b296a3a88d693ef735407cbc2fd29a50b8ff2cb1432a11a3668eb1e366080e	..
// a0da241d264c5849589b92e4e8e9f5a9d939d4e936fb291736e0298f4d2fa202	..
// a03aa55fece390d2789ae2aed01206b340e70c8007d4098a89457d101b207376	..
// a04967045eaa81396c5d3dc26eeab6154a370fed155bc95a443e56b9803029eb	..

//a025f4fd54064e869f158c1b4eb0ed34820f67e60ee80a53b469f725efc06378
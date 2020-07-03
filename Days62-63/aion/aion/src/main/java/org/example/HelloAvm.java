import avm.Address;
import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;

public class HelloAvm {

    private static Address owner;
    private static Address newOwner;

    // Assign the log topic upon deployment.
    private static String transferLogTopic;

    private static String deployer;

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
        return owner;
    }
}
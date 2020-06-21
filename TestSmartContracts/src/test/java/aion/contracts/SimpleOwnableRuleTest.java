package aion.contracts;

import avm.Address;
import org.aion.avm.embed.AvmRule;
import org.aion.avm.userlib.abi.ABIStreamingEncoder;
import org.aion.types.TransactionStatus;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import java.math.BigInteger;

public class SimpleOwnableRuleTest {
    @Rule
    public AvmRule avmRule = new AvmRule(true);

    // Default address with balance
    private Address deployer = avmRule.getPreminedAccount();

    private Address contractAddress;

    @Before
    public void deployContract() {
        ABIStreamingEncoder encoder = new ABIStreamingEncoder();
        byte[] deploymentArguments = encoder.encodeOneString("OwnershipTransferred").encodeOneString("Harshil").toBytes();
        byte[] contract = avmRule.getDappBytes(SimpleOwnable.class, deploymentArguments);

        // Deploy the contract and get the contract address
        contractAddress = avmRule.deploy(deployer, BigInteger.ZERO, contract).getDappAddress();

    }

    @Test
    public void testGetOwnerAddress() {

        ABIStreamingEncoder encoder = new ABIStreamingEncoder();
        byte[] txData = encoder.encodeOneString("getOwnerAddress").toBytes();
        AvmRule.ResultWrapper result = avmRule.call(deployer, contractAddress, BigInteger.ZERO, txData);

        TransactionStatus status = result.getReceiptStatus();
        Assert.assertTrue(status.isSuccess());

        // Cast the return type
        Address res = (Address) result.getDecodedReturnData();
        Assert.assertTrue(res.equals(deployer));
    }

}

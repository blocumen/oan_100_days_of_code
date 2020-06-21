package aion.contracts;

import avm.Address;
import org.aion.avm.core.util.Helpers;
import org.aion.avm.embed.AvmRule;
import org.aion.avm.tooling.ABIUtil;
import org.aion.types.TransactionStatus;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.ClassRule;
import org.junit.Test;

import java.math.BigInteger;

public class AionListDemoRuleTest {
    @ClassRule
    public static AvmRule avmRule = new AvmRule(true);

    private static Address caller = avmRule.getPreminedAccount();

    private static Address dappAddr;

    private String str = "a03aa55fece390d2789ae2aed01206b340e70c8007d4098a89457d101b207376";
    private byte[] bytes = Helpers.hexStringToBytes(str);
    private Address addr = new Address(bytes);

    @BeforeClass
    public static void deployDapp(){
        byte[] dapp= avmRule.getDappBytes(aion.contracts.AionListDemo.class,null);
        dappAddr = avmRule.deploy(caller, BigInteger.ZERO,dapp).getDappAddress();
    }

    @Test
    public void testAddAddress(){
        //calling Dapps:
        // 1- encode method name and arguments
        // 2- make the call;
        byte[] txData = ABIUtil.encodeMethodArguments("addAddress",addr);
        AvmRule.ResultWrapper result = avmRule.call(caller, dappAddr, BigInteger.ZERO, txData);

        // getReceiptStatus() checks the status of the transaction execution
        TransactionStatus status = result.getReceiptStatus();
        Assert.assertTrue("Successfull:",status.isSuccess());
        //Print the return Output of the Function
        System.out.println(result.getDecodedReturnData());
    }

    @Test
    public void testRemoveAddress(){
        byte[] txData = ABIUtil.encodeDeploymentArguments("removeAddress",addr);
        AvmRule.ResultWrapper result = avmRule.call(caller,dappAddr,BigInteger.ZERO,txData);

        TransactionStatus status = result.getReceiptStatus();
        //System.out.println(status.isSuccess()+" "+status.isFailed()+" "+status.isFatal()+" "+status.isRejected()+" "+status.isReverted());
        Assert.assertTrue("Successfull:",status.isSuccess());
    }

    @Test
    public void testDisplayList(){
        byte[] txData = ABIUtil.encodeDeploymentArguments("displayList");
        AvmRule.ResultWrapper result = avmRule.call(caller,dappAddr,BigInteger.ZERO,txData);

        TransactionStatus status = result.getReceiptStatus();
        Assert.assertTrue(status.isSuccess());
    }
}


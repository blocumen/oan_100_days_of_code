package aion.contract;

import avm.Address;
import avm.Blockchain;
import avm.Result;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.abi.ABIDecoder;
import org.aion.avm.userlib.abi.ABIStreamingEncoder;

import java.math.BigInteger;

public class CallerAddress {
    public static Address returnerContractAddress;
    public static int count=0;

    static {
        ABIDecoder decoder = new ABIDecoder(Blockchain.getData());
        returnerContractAddress = decoder.decodeOneAddress();
        //Blockchain.println(decoder.decodeOneAddress()+" ");
    }

    @Callable
    public static Address getCallerAddress(){
        ABIStreamingEncoder encoder = new ABIStreamingEncoder();
        byte[] data = encoder.encodeOneString("getOwner").toBytes();
        Result getAddress = Blockchain.call(returnerContractAddress, BigInteger.ZERO,data,Blockchain.getRemainingEnergy());
        ABIDecoder decoder = new ABIDecoder(getAddress.getReturnData());
        Address ownerAddress = decoder.decodeOneAddress();
        return ownerAddress;
    }

    @Callable
    public static int incrementCount(){
        Blockchain.require(Blockchain.getCaller().equals(getCallerAddress()));
        count++;
        return count;
    }
}

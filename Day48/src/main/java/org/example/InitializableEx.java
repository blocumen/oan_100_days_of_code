package org.example;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;

public class InitializableEx
{
    @Initializable
    private static String status;

    @Initializable
    private static byte num;

    @Callable
    public static String getStatus() {
        Blockchain.println("Current string is " + status);
        return status;
    }

    @Callable

    public static byte getByte()
    {
        Blockchain.println("byte "+num);
        return num;
    }

}

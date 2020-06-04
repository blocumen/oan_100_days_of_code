package org.aion;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.tooling.abi.Initializable;

public class Initialize
{
    @Initializable
    private static String myString;

    @Callable
    public static String getInitialize () {
        return ("String is initialized with " + myString);
    }
}

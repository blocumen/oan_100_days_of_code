package org.aion;

import avm.Blockchain;
import org.aion.avm.tooling.abi.Callable;

public class Multiply
{
    private static String myStr = "Hello AVM";

    @Callable
    public static String multiply (double number) {
        double res =  number * 10;
        return ("multiplied number is " + res);
    }

}

package example;

import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionList;

public class ListandObjects {
    private static AionList<String> carList = new AionList<>();
    private static AionList<String> carListCopy = new AionList<>();
    private static AionList<String> carSubList = new AionList<>();
    @Callable
    public static void addCar(String newCarBrand) {
        carList.add(newCarBrand);
    }
    @Callable
    public static void addCar1(String newCarlist) {
        carListCopy.add(newCarlist);
    }
    @Callable
    public static void addCar2(String newCarSubList) {
        carSubList.add(newCarSubList);
    }
    @Callable
    public static void clearCarSet() {
        carList.clear();
    }

}

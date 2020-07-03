package aionexample;
import avm.*;
import org.aion.avm.tooling.abi.Callable;
import org.aion.avm.userlib.AionBuffer;
import org.aion.avm.userlib.AionMap;
import java.math.BigInteger;

public class HybridStorage
{
    // Create an address object to hold the owner of this contract.
    private static Address owner;

    // Create an empty carStock Map object.
    private static final AionMap<String, Integer> carStock = new AionMap<>();

    static {
// Define who the owner of this contract is.
        owner = Blockchain.getCaller();
    }

    // Add a new car to the Map object.
    @Callable
    public static void addCarStock(String make, int currentStock) {
        onlyOwner();

// Check that the carStock Map object doesn't already contain this make.
        Blockchain.require(!carStock.containsKey(make));

// Put the car into the carStock Map object.
        carStock.put(make, currentStock);
    }

    // Update a car already in the Map object.
    @Callable
    public static void updateCarStock(String make, int newStock) {
        onlyOwner();

// Check that the supplied $make already exists in the carStock Map object.
        Blockchain.require(carStock.containsKey(make));

// Update the map using make as the key.
        carStock.put(make, newStock);
    }

    // Remove a car from the Map object.
    @Callable
    public static void removeCarMake(String make) {
        onlyOwner();
        carStock.remove(make);
    }

    // Return an item from the Map object using make as the key.
    @Callable
    public static int getCarStock(String make, String model) {
        Blockchain.require(carStock.containsKey(make));
        return carStock.get(make);
    }

    // Add car information about a car to the object graph.
    @Callable
    public static void addPurchaseInfo(long orderID, String customerID, String stockNumber, int price){
        onlyOwner();

// Put all the purchase information into a buffer object and then put that into a byte array. The order that this information is added into the byteArray will be the same order that it is read OUT.
        byte[] newOrderInfo = AionBuffer.allocate(Integer.BYTES + customerID.length() + Integer.BYTES + stockNumber.length() + Integer.BYTES)
                .putInt(customerID.length())
                .put(customerID.getBytes())
                .putInt(stockNumber.length())
                .put(stockNumber.getBytes())
                .putInt(price)
                .getArray();

// Add the newOrderInfo byte array into the object graph.
        Blockchain.putStorage(AionBuffer.allocate(32).put32ByteInt(BigInteger.valueOf(orderID)).getArray(),newOrderInfo);
    }

    // Get an order from the byte array stored in the object graph.
    @Callable
    public static String getOrderInformation(long orderID) {
// Grab the correct array item by using the orderId as the key.
        byte[] orderInfo = Blockchain.getStorage(AionBuffer.allocate(32).put32ByteInt(BigInteger.valueOf(orderID)).getArray());
// Create a buffer object by wrapping the orderInfo byte array.
        AionBuffer orderInfoBuf = AionBuffer.wrap(orderInfo);

// Now that we've got a buffer object, we can grab each variable using the order that they were put into the array in the first place. See addPurchaseInfo() for the order that they're put int there.

// Get the length of the customerId byte variable.
        int customerIDLength =  orderInfoBuf.getInt();
// Create a new byte array called customerId using that length.
        byte[] customerID = new byte[customerIDLength];
// Get customerId byte array from the order info buffer.
        orderInfoBuf.get(customerID);

// Get the length of the stockNumberId byte variable.
        int stockNumberIDLength =  orderInfoBuf.getInt();
// Create a new byte array called stockNumber using that length.
        byte[] stockNumber = new byte[stockNumberIDLength];
// Get the stockNumber byte array from the order info buffer.
        orderInfoBuf.get(stockNumber);

// Get the price from the remaining bytes from the order info buffer
        int price = orderInfoBuf.getInt();

// Return all the variables to the user as a String.
        return "Order ID: " + orderID + "\nCustomer ID: " + new String(customerID)
                + "\nStock Number: " + new String(stockNumber)
                + "\nPrice: " + price;
    }

    // If this modifier is set on a function, only the owner of this contract can call the assigned function.
    private static void onlyOwner() {
        Blockchain.require(owner.equals(Blockchain.getCaller()));
    }
}
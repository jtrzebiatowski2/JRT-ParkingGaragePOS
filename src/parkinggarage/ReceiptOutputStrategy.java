package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.2
 */

/**
 * This interface allows for the creation of many different receipt output strategies because the way that a receipt is
 * output varies. All classes implementing this interface must override the methods and provide a unique implementation.
 */
public interface ReceiptOutputStrategy {
    /**
     *
     * @param parkingReceipt
     */
    public abstract void outputReceipt(ParkingReceipt parkingReceipt);
}

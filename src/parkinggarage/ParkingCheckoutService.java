package parkinggarage;

import java.util.Objects;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This service class class is responsible for parking new cars, and also checking parked cars
 * out of the garage.
 * 
 */
public class ParkingCheckoutService {
    //Creates a garage manager object for utilzation by the parking checkout service
    private GarageManager garageManager;
    //Variable to hold the error message for an invalid parking garage manager
    private final String GARAGE_MANAGER_NULL_MESSAGE = "The garage manager does not exist";

    /**
     *
     * @param garageManager
     * *Default constructor ensuring that a garage manager object is passed as a parameter. That parameter is also 
     * validated through the encapsulated method, setGarageManager
     * 
     */
    
    public ParkingCheckoutService(GarageManager garageManager){
        setGarageManager(garageManager);
    }
    
     /**
     *This method is used to park new cars into the parking garage. It takes the parameters hours parked and
     *car number and creates a new parked car object. That new parked car object is then added to the garage
     *manager's parked car object array through delegation of the addParkedCar method. A car is also added
     *to the garage managers garage car total variable through an encapsulated method and delegation.
     * @param hoursParked
     * @param carNumber
     */
    public final void parkNewCar(double hoursParked , int carNumber) {
        garageManager.addParkedCar(hoursParked, carNumber);
        garageManager.addCarToGarageCarTotal();
    } 
     
    /**
     * This method is used to checkout a parked car in the parking garage. it takes the car number and the hours parked
     * as parameters. A new parking receipt is then created given the parameters car number, hours parked, 
     * the appropriate fee calculator found through delegating the garage manager to retrieve it.
     * When the car checks out, the car is subtracted from the total number of cars in the garage. A receipt
     * output object is created and the parking receipt object is passed to the output receipt method of the console
     * receipt output class
     * 
     * @param carNumber
     * @param hoursParked
     * @param receiptOutput
     * 
     */
    public void checkoutParkedCar(int carNumber, double hoursParked, ReceiptOutputStrategy receiptOutput, GarageManager garageManager){ 
        ParkingReceipt parkingReceipt = new ParkingReceipt(carNumber, hoursParked, garageManager.getFeeCalculator(), garageManager);
        garageManager.subtractToGarageCarTotal();
        receiptOutput.outputReceipt(parkingReceipt);
    }

    /**
     * Method to set a garage manager object which also includes validation ensuring it is not null
     *
     * @param garageManager
     */
    private void setGarageManager(GarageManager garageManager) {
        if(garageManager != null){
        this.garageManager = garageManager;
    }
        else{
            throw new IllegalArgumentException(GARAGE_MANAGER_NULL_MESSAGE);
        }
    }
    /**Returns the garage manager object
     *
     * @return garageManager
     */
    public GarageManager getGarageManager() {
        return garageManager;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 31 * hash + Objects.hashCode(this.garageManager);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ParkingCheckoutService other = (ParkingCheckoutService) obj;
        if (!Objects.equals(this.garageManager, other.garageManager)) {
            return false;
        }
        return true;
    }
    
    
}

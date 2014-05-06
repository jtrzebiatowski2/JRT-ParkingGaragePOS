package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This class is an implementation of the receipt interface and is used to hold information
 * about the parking garage company and parked cars.
 * 
 */
public class ParkingReceipt implements Receipt {
    //Variabe holding the parking garage company name
    private String parkingGarageCompanyName;
    //Variable holding the parking garage compnay address
    private String parkingGarageCompanyAddress;
    //Variable to hold the total parked hours in the garage
    private double garageTotalHours;
    //Varaible to hold the totla fees collected by the parking garage
    private double garageTotalFees;
    //Variable holding the parked car number
    private int parkedCarNumber;
    //Variable holding the number of hours the parked car has been parked
    private double carHoursParked;
    //Variable holding the parking fee for the parked car
    private double parkingFeeTotal;
    //Variable to hold the error message for a car parked with hours outside the accepted range
    private final String INVALID_HOURS_ERROR_MESSAGE = "Hours outside of the accepted parking values";
    //Constant holding validation integer for min parking hours 
    private final int MIN_PARK_CHECK = 0;
    //Constant to hold the max park hours
    private final int MAX_PARK_HOURS = 24;
    //Constant to hold the error mesage for an invalid car number
    private final String INVALID_CAR_NUMBER_ERROR_MESSAGE = "Invalid Car Number";
    //Constant used for validating some setter methods
    private final int ZERO = 0;
    
    
    /**
     * This method is used to create a parking receipt for a car checking out. It takes a car number, hours parked, 
     * the parking fee calculator type, and a garage manager. The method first checks to verify that the garage 
     * manager is not null, and also that the parked car checking out is valid and not null. The garage manager
     * first gets the appropriate garage company name, then the appropriate garage company address. A new parked car 
     * object is created and passed the car number and the hours the car has been parked. The parking fee accrued
     * is calculated using the proper calculator and the hours the car has been parked. The garage manager then
     * adds the number of hours the car has been parked to the running garage total of parked hours. The garage manager
     * also adds the amount of the fee collected to the running total for the parking garage. These values are then
     * retrieved through a getter method and assigned to the appropriate variables.
     * 
     * @param carNumber
     * @param hoursParked
     * @param parkingFeeCalculator
     * @param gm
     */
    
    public ParkingReceipt(int carNumber, double hoursParked, ParkingFeeCalculationStrategy parkingFeeCalculator, GarageManager gm){
                parkingGarageCompanyName = gm.getParkingGarageCompany().getCompanyName();
                parkingGarageCompanyAddress = gm.getParkingGarageCompany().getCompanyAddress();
                ParkedCar pc = new ParkedCar(hoursParked, carNumber); 
                parkedCarNumber = carNumber;
                parkingFeeTotal = parkingFeeCalculator.getParkingFee(hoursParked);
                carHoursParked = hoursParked;
                gm.addParkedHoursToTotal(pc.getHoursParked());
                gm.addParkingFeeCollectedToTotal(parkingFeeTotal);
                garageTotalHours = gm.getAccumulatedParkedHours();
                garageTotalFees = gm.getAccumulatedFeesCollected();
                gm.storeNewGarageTotals();
                gm.printGarageTotalsToFile();
       }
   
     /**
     *
     * @return parkedCarNumber
     */
    public int getCarNumber(){
           return parkedCarNumber;
    }
     
     /**
     *
     * @return parkingGarageCompanyName
     */
    public String getParkingGarageCompanyName(){
            return parkingGarageCompanyName;
        }
        
     /**
     *
     * @return carHoursParked
     */
    public double getHoursParked(){
            return carHoursParked;
        }
     
     /**
     *
     * @return garageTotalHours
     */
    public double getGarageTotalHours(){
            return garageTotalHours;
        }
    
     /**
     *
     * @return
     */
    public double getGarageTotalFees(){
            return garageTotalFees;
        }
        
     /**
     *
     * @return parkingFeeTotal
     */
    public double getParkingFeeTotal() {
        return parkingFeeTotal;
    }
        
    /**
     * Sets the number of parked hours and validates the hours are within the required range
     * @param carHoursParked
     */
    public void setHoursParked(double carHoursParked) {
        if(carHoursParked > MIN_PARK_CHECK && carHoursParked <= MAX_PARK_HOURS ){
        this.carHoursParked = carHoursParked;
    }
        else{
            throw new IllegalArgumentException(INVALID_HOURS_ERROR_MESSAGE);
        }
    }

    /**
     *Sets the car number for a parked car. Would contain different validation based on clients parameters for
     *numbering or setting id's to parked cars
     *@param parkedCarNumber
     */
    public void setParkedCarNumber(int parkedCarNumber) {
        if(parkedCarNumber > ZERO){
        this.parkedCarNumber = parkedCarNumber;
    }
        else{
            throw new IllegalArgumentException(INVALID_CAR_NUMBER_ERROR_MESSAGE);
        }
    }

    /**
     *
     * @return parkingGarageComapnyAddress
     */
    public String getParkingGarageCompanyAddress() {
        return parkingGarageCompanyAddress;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + this.parkedCarNumber;
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
        final ParkingReceipt other = (ParkingReceipt) obj;
        if (this.parkedCarNumber != other.parkedCarNumber) {
            return false;
        }
        return true;
    }
 
}

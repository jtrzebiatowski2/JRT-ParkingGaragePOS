package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This class is an implementation of a parking fee calculation strategy object
 * It contains a unique implementation of the getParkingFee() method along with
 * a toString() method that returns the name of the calculator object type
 */
public class ThriftyFeeCalculator implements ParkingFeeCalculationStrategy{
    //This variable holds the minimum amount to park with the Thrifty fee and is not final in case the prices need to change
    private double minimumParkingCharge = 1.5;
    //This variable holds the amount charge for any additional hours and part-hours over the allotted 3 standard hours
    private double pricePerHourOrPartHour = .75;
    //This variable holds the number of hours allotted to incure the minimum parking fee 
    private double maxFlatRateParkTimeInHours = 2.0;
    //The maximum number of hours a car may stay parked
    private int maxParkTimeInHours = 24;
    //Constant variable holding zero to ensure entered parked time is greater than 0 hours
    private final int ZERO_PARK_TIME = 0;
    //String with error message for cars parked with time equal to 0
    private final String MIN_PARK_TIME_ERROR_MESSAGE = "The car must be parked more than 0 hours to incure a parking fee";
    //String with error message for cars parked over the maximum number of hours allowed
    private final String MAX_HOURS_EXCEEDED_ERROR_MESSAGE = "The car has exceeded the allotted number of hours for parking";
    //number used to begin a fee calculation process
    private double feeInitialization = 0.0;
    //Variable to hold the accrued parking fee
    private double parkingFee;
    
  /**
   * This method overrides the abstract method from the parking fee calculation strategy interface. It includes a 
   * unique formula for calculating a parking fee and takes the number of hours parked as a parameter consistent with
   * the interface method. 
   * 
   * @param timeParkedInHours
   * @return parkingFee
   */
    
    @Override
    public double getParkingFee(double timeParkedInHours) {
       parkingFee = feeInitialization;
       //Checks to see if car is parked for more than 0 hours
       if(timeParkedInHours != ZERO_PARK_TIME ){
       //Checks to see if car has parked for less then the maximum allowed hours
           if (timeParkedInHours <= maxParkTimeInHours){
       //Checks to see if car has parked for less than 3 hours to return the min parking charge
               if (timeParkedInHours <= maxFlatRateParkTimeInHours){
                   return minimumParkingCharge;
                }
       //If none of the above conditions are met the time is calculated here. The parking fee is first set equal to the 
       //minimum charge and a for loop is used to add the additional fee per hour and part-hour parked.
       //The Math.ceil opertaion rounds the portional decimal parking time to the highest integer value (5.3 hrs becomes 6.0)
       //to ensure cars are charged for any minute over a whole hour.
               else{
                   parkingFee += minimumParkingCharge;
                   for (int i= 0; ((Math.floor(timeParkedInHours - maxFlatRateParkTimeInHours))- i)>= ZERO_PARK_TIME; i++){
                       parkingFee += pricePerHourOrPartHour;
                   }
       
                    return parkingFee; 
               }
            }
           //If hours parked is greater than 24 an error message is shown
           else{
               throw new IllegalArgumentException(MAX_HOURS_EXCEEDED_ERROR_MESSAGE);
           }
        }
       //If hours parked is less than or equal to 0 an error message is shown
       else{
           throw new IllegalArgumentException(MIN_PARK_TIME_ERROR_MESSAGE);
       }
    
    }

    /**
     * 
     * @return 
     */
    @Override
    public String toString() {
        return "Thrifty Fee Calculator";
    }
    
    
}

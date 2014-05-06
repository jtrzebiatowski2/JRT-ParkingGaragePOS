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
public class BestValueFeeCalculator implements ParkingFeeCalculationStrategy{
    //This variable holds the minimum amount to park with the Best Value fee and is not final in case the prices needs to change
    private double minimumParkingCharge = 2.0;
    //This variable holds the amount charge for any additional hours and part-hours over the allotted 3 standard hours
    private double pricePerHourOrPartHour = .50;
    //This variable holds the number of hours allotted to incure the minimum parking fee 
    private double maxFlatRateParkTimeInHours = 3.0;
    //This is the maximum charge a vehicle may incure while parked
    private double maxFeeCharged = 10.00;
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
  
    /**
     *Default constructor
     */
    public BestValueFeeCalculator() {
    }
    
   /**
   * @param timeParkedInHours
   * This method overrides the abstract method from the parking fee calculation strategy interface. It includes a 
   * unique formula for calculating a parking fee and takes the number of hours parked as a parameter consistent with
   * the interface method. 
   */
    
    @Override
    public double getParkingFee(double timeParkedInHours) {
       double parkingFee = feeInitialization;
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
       //The Math.floor operation rounds the portional decimal point of the park time to the lowest integer value (5.3 hrs becomes 5.0)
       //to ensure the charge increments are applied appropriately
               else{
                   parkingFee += minimumParkingCharge;
                   for (int i=0; ((Math.floor(timeParkedInHours - maxFlatRateParkTimeInHours))- i)>= ZERO_PARK_TIME; i++){
                       parkingFee += pricePerHourOrPartHour;
                   }
        //If the calculated fee is over the maximum charge, the max charge is returned instead, otherwise the calculated fee is returned
                   if(parkingFee > maxFeeCharged){
                      return maxFeeCharged;
                   }
                   else{
                       return parkingFee;
                   }
                   
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
 * @return 
 */
    @Override
    public String toString() {
        return "Best Value Fee Calculator";
    }
    
}

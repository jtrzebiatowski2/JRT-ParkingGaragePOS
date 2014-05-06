package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 */


/**
 * This interface allows for the creation of many parking fee calculator abstractions all having 
 * differing ways to calculate the parking fees based upon the requirements of the parking garage
 * client. The method takes the parameter of time parked in hours and must be overridden in all 
 * implementing classes
 */

public interface ParkingFeeCalculationStrategy {
    /**
     *
     * @param timeParkedInHours
     * 
     */
    public abstract double getParkingFee(double timeParkedInHours);
}

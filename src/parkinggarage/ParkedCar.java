package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This class represents a parked car object. It stores the car number and the number of hours the
 * car is parked along with appropriate getter and setter methods.
 * 
 */
public class ParkedCar {
    //variable used to check that min park times are met
    private final double INVALID_MIN_PARK_TIME = 0.0;
    //variable holding min park time error message
    private final String INVALID_MIN_PARK_TIME_ERROR_MESSAGE = "Park time must be greater than 0 hours";
    //variable to hold the number of hours a car is parked
    private double hoursParked;
    //variable holding the car number for garage information and receipt information etc.
    private int carNumber;
    //variable to check for valid car number
    private final int INVALID_CAR_NUMBER = 0;
    //invalid car number error message
    private final String IVALID_CAR_NUMBER_ERROR_MESSAGE = "Car number may not be equal to 0";
    
    //Constructor which ensures that any parked car object created contains a car number and holds the park time
    //which are validated through the encapsulated methods
    /**
     *
     * @param hoursParked
     * @param carNumber
     */
    public ParkedCar(double hoursParked, int carNumber) {
        setHoursParked(hoursParked);
        setCarNumber(carNumber);
    }
    
    /**
     *Method returning the car number
     * @return carNumber
     */
    public int getCarNumber() {
        return carNumber;
    }
    
    /**
     *Method returning the number of hours a car is parked
     * @return hpursParked
     */
    public double getHoursParked() {
        return hoursParked;
    }
    

    /**
     *Method setting the car number and validating that the car number is greater than 0
     * would also provide validation here if client wanted a specific car numbering/Id system in place
     * @param carNumber
     */
    private void setCarNumber(int carNumber) {
        if(carNumber > INVALID_CAR_NUMBER){
        this.carNumber = carNumber;
        }
        else{
            throw new IllegalArgumentException(IVALID_CAR_NUMBER_ERROR_MESSAGE);
        }
    }
    /**
     *Gets the number of hours parked and validates that the hours parked is greater than 0
     * @param hoursParked
     */
    private void setHoursParked(double hoursParked) {
        if (hoursParked != INVALID_MIN_PARK_TIME ){
            
           this.hoursParked = hoursParked;
        }
        
        else{
          throw new IllegalArgumentException(INVALID_MIN_PARK_TIME_ERROR_MESSAGE);
        }
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 61 * hash + this.carNumber;
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
        final ParkedCar other = (ParkedCar) obj;
        if (this.carNumber != other.carNumber) {
            return false;
        }
        return true;
    }

    
}

package parkinggarage;

import java.util.Objects;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This class implements the company interface and hold information relating to
 * a parking garage object. It includes company name, address, and also a parking fee calculation 
 * strategy object along with all appropriate getter and setter methods.
 * 
 */
public class ParkingGarageCompany implements Company{
    //String to hold the variable company name
    private String companyName;
    //Creates a parking fee calculator strategy object from the abstract interface
    private ParkingFeeCalculationStrategy parkingFeeCalculator;
    //String to hold error message if a company is constructed with no name field
    private final String NULL_COMPANY_NAME_ERROR_MESSAGE = "You must provide a company name";
    //String to hold the variable company address
    private String companyAddress;
    //String to hold error message if a company is constructed with no address field
    private final String NULL_COMPANY_ADDRESS_ERROR_MESSAGE = "You must provide a company address";
    //String to hold the error message if a company is constructed with no fee strategy
    private final String INVALID_FEE_STRATEGY_ERROR_MESSAGE = "You must use a valid parking fee strategy";

    /**
     * The parking garage company constructor requires a company name, a a parking fee calculation strategy object
     *and a company address. Through the constructor three methods are encapsulated to ensure that the paramters passed to the parking garage company
     *object contain the required fields and those fields are validated properly.
     *
     * @param companyName
     * @param parkingFeeCalculator
     * @param companyAddress
     */
    public ParkingGarageCompany(String companyName, ParkingFeeCalculationStrategy parkingFeeCalculator, String companyAddress) {
        setCompanyName(companyName);
        setParkingFeeCalculationStrategy(parkingFeeCalculator);
        setCompanyAddress(companyAddress);
    }
    
    
    /**
     * Overridden method from the company interface to return the company name
     *
     * @return companyName
     */
    @Override
    public final String getCompanyName() {
        return companyName;
    }
    /**
     * Sets the company name and validates to ensure that the property is not null
     *
     * @param companyName
     */
    @Override
    public final void setCompanyName(String companyName) {
        if(companyName != null){
            this.companyName = companyName;
        }
        else{
            throw new IllegalArgumentException(NULL_COMPANY_NAME_ERROR_MESSAGE);
        }
    }
    /**
     * Overridden method from the company interface to return the company address
     *
     * @return companyAddress
     */
    @Override
    public final String getCompanyAddress() {
        return companyAddress;
    }
    /**
     * Sets the company address and ensures that the property is not null
     *
     * @param companyAddress
     */
    @Override
    public final void setCompanyAddress(String companyAddress) {
        if(companyAddress != null){
            this.companyAddress = companyAddress;
        }
        else{
            throw new IllegalArgumentException(NULL_COMPANY_ADDRESS_ERROR_MESSAGE);
        }
    }
    /**
     * Method returning the parking fee calculation strategy 
     *
     * @return parkingFeeCalculator
     */
    public final ParkingFeeCalculationStrategy getParkingFeeCalculationStrategy(){
        return parkingFeeCalculator;
    }
    /**
     * This method sets the parking fee strategy object and validates that it is not null
     *
     * @param parkingFeeCalculator
     */
    public final void setParkingFeeCalculationStrategy(ParkingFeeCalculationStrategy parkingFeeCalculator){
        if (parkingFeeCalculator != null){
            this.parkingFeeCalculator = parkingFeeCalculator;
        }
        else{
            throw new IllegalArgumentException(INVALID_FEE_STRATEGY_ERROR_MESSAGE);
        }
    }

    @Override
    public String toString() {
        return companyName;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 29 * hash + Objects.hashCode(this.companyName);
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
        final ParkingGarageCompany other = (ParkingGarageCompany) obj;
        if (!Objects.equals(this.companyName, other.companyName)) {
            return false;
        }
        return true;
    }

    
    
    
    
}

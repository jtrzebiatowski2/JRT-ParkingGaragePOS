package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This fake company database holds information for different parking garage companies.
 * The purpose of this database is to store information in case the garage application designed
 * here is offered as a web service rather than a personalized software application.
 * Of course you would not store multiple company's information in the program if it was built 
 * solely for a single client.
 * 
 */
public class FakeParkingGarageCompanyDatabase implements Database{
    
    //String to hold error message for improper field data
    private final String REQUIRED_FIELD_ERROR_MESSAGE = "The fields may not be blank";
    
    /**
    *Array of parking garage company objects. More companies may be added to this array and used in the startup class
    *and the parking fee strategy objects may also be changed based upon how the company wants to charge customers
    */
    
    private ParkingGarageCompany [] parkingGarageCompanies =
    {
        new ParkingGarageCompany("Best Value Parking Garage", new BestValueFeeCalculator() , "453 W. Main St. Milwaukee, WI 53225"),
        new ParkingGarageCompany("Thrifty Parking Garage", new ThriftyFeeCalculator(), "7546 Lombardi Dr. Green Bay, WI 54975")
    };
    
/**
 * This method adds a new parking garage company object to the parking garage companies array
 * it validates that the entered company contains the required fields and a fee strategy object.
 * It stores the old array into a temporary array which has an additional array spot vacant. After copying the
 * old array into the new array, the new array object is added to the last vacant spot in the copied array
 * 
 * @param companyName
 * @param parkingFeeCalculator
 * @param companyAddress
 * */

    public void addNewParkingGarageCompany(String companyName, ParkingFeeCalculationStrategy parkingFeeCalculator, String companyAddress){
        if(companyName == null || parkingFeeCalculator == null || companyAddress == null) {
            throw new IllegalArgumentException(REQUIRED_FIELD_ERROR_MESSAGE);
        }
        ParkingGarageCompany newCompany = new ParkingGarageCompany(companyName, parkingFeeCalculator, companyAddress);
        ParkingGarageCompany [] temp = new ParkingGarageCompany[parkingGarageCompanies.length + 1 ];
        System.arraycopy(parkingGarageCompanies, 0, temp, 0, parkingGarageCompanies.length);
        parkingGarageCompanies = temp;
        parkingGarageCompanies[parkingGarageCompanies.length-1] = newCompany;
   
    }
    
    /**
    * This method loops through the parkingGarageCompanies array and finds the company that matches the 
    *searched name and returns that garage company
    * @param companyName
    * @return pgc
    */
    
     public final ParkingGarageCompany findCompany(String companyName) {
        ParkingGarageCompany pgc = null;
        for(ParkingGarageCompany c : parkingGarageCompanies) {
            if(companyName.equals(c.getCompanyName())) {
                pgc = c;
                break;
            }
        }
        
        return pgc;
    }
}
            
            
            
 
    
    
package parkinggarage;

import java.util.Map;
import java.util.Objects;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This is the brains behind the Parking Garage Program. As the primary service class
 * the garage manager handles many of the functionalities of the program and delegates tasks
 * to other classes accordingly. It is responsible for adding parked cars to the garage companies, 
 * storing total parked hours, total collected fees, garage capacity, number of cars in garage,
 * contains a map of the garage totals and uses a file manager instantiation to handle reading and
 * writing of garage data to appropriate text files outside of the program.
 * 
 */
public class GarageManager {
    //Creates a ParkedCar array to hold the parked cars within the garage
    private ParkedCar[] parkedCars;
    //Ceates parking garage company object
    private ParkingGarageCompany parkingGarageCompany;
    //String to hold error message for required fields upon data entry
    private final String REQUIRED_FIELDS_ERROR_MESSAGE = "The fields may not be blank";
    //Variable to hold the total number of hours throughout the day, this variable will be continually populated
    //as cars leave the garage and receipts are printed
    private double totalParkedHours;
    //Variable to hold the total amount of fees collected throughout the day, this variable will be continually
    //populated as more cars leave the lot and receipts are printed
    private double totalFeesCollected;
    //Variable to hold the number of cars in the garage at any given time
    private int numberOfCarsInGarage;
    //This variable will not be used in the program but should be based on client information regarding capacity
    //eventually the variable would be used to refuse cars when the limit has been reached.
    private int garageCapacity;
    //Constant holding the error message for an invalid parking garage company
    private final String NULL_PARKING_GARAGE_COMPANY_ERROR_MESSAGE = "The parking garage company does not exist";
    //Constant holding the integer 0 to initialize accumulated variables in the garage manager object
    private final int ZERO = 0;
   //Map holding the current garage totals of Hours, and Fees collected
    private Map garageTotals;
    //String holding the file path of the garage totals text file
    private String garageTotalsFile;
    
    /**
     * Instantiation of a File Manager object composed of a text reader and text writer which both
     * contain the appropriate garage total converter strategy objects
    */
    private FileManager fileManager = new FileManager(
            new TextReader(new GarageTotalsConverter()), 
            new TextFileWriter(new GarageTotalsConverter()));
    

    /**
     * Default constructor for a Garage manager requiring a Parking Garage Company as a parameter
     * The constructor encapsulates the setParkingGarageCompany method which validates that the passed
     * parking garage company object is not null. Other validation would be provided based on client requirements
     * An array of parked car objects is also created to store the parked cars in the given garage
     *
     * @param parkingGarageCompany
     */
    public GarageManager(ParkingGarageCompany parkingGarageCompany){
        setParkingGarageCompany(parkingGarageCompany);
        parkedCars = new ParkedCar[0];
        totalParkedHours = ZERO;
        totalFeesCollected = ZERO;
        numberOfCarsInGarage = ZERO;
    }
    
    /**
     * This method adds a new car object to the parked cars array. The method creates a new parked car object
     * then creates a temporary array which adds one extra spot, copies the original array to the temporary array
     * then adds the new parked car object to the created empty spot and assigns the copied array to the original array
     *
     * @param parkedHours
     * @param carNumber
     */
    public void addParkedCar(double parkedHours, int carNumber){
        ParkedCar parkedCar = new ParkedCar(parkedHours, carNumber);
        ParkedCar[] temp = new ParkedCar[parkedCars.length + 1];
        System.arraycopy(parkedCars, 0, temp, 0, parkedCars.length);
        parkedCars = temp;
        parkedCars[parkedCars.length-1] = parkedCar;
        
    }

    /**
     * Method used to loop through the populated parked car array and find a parked car given the car's number
     * @param carNumber
     * @return
     */
    public ParkedCar findParkedCar(int carNumber){
        if(carNumber <= ZERO) {
            throw new IllegalArgumentException(REQUIRED_FIELDS_ERROR_MESSAGE);
        }
            ParkedCar parkedCar = null;
            
              for(ParkedCar pc : parkedCars) {
                if((pc.getCarNumber()) == (carNumber));
                {
                parkedCar = pc;
                break;
                }
    } 
        return parkedCar; 
    }

    /**
     *
     * @return
     */
    public int getGarageCapacity() {
        return garageCapacity;
    }

    /**
     *
     * @param garageCapacity
     */
    public void setGarageCapacity(int garageCapacity) {
        this.garageCapacity = garageCapacity;
        //Provide validation based upon the specifications of the individual garage client
    }
    
    /**
     * This method adds 1 to the populated car total for the garage manager object and is used when a car enters the garage
     * @return
     */
    public final int addCarToGarageCarTotal(){
        return numberOfCarsInGarage++;
        
    }
    
    /**
     *This method subtracts 1 from the populated car total for the garage manager object and is used when a car checkout
     * @return
     */
    public final int subtractToGarageCarTotal(){
        return numberOfCarsInGarage--;
    }
    
    
    /**
     *This method adds the number of hours parked by an individual car to the running total of the garage company
     * @param hoursParked
     */
    public final void addParkedHoursToTotal(double hoursParked){
        if(hoursParked > ZERO){
            getTotalParkedHours();
            this.totalParkedHours += hoursParked;
        }
        else{
            throw new IllegalArgumentException(REQUIRED_FIELDS_ERROR_MESSAGE);
        }
    }
    /**
     * This method adds the collected fee from an individual parked car to the running total of the garage company
     * @param parkingFee
     */
    public final void addParkingFeeCollectedToTotal(double parkingFee){
        if (parkingFee > ZERO){
            getTotalFeesCollected();
            this.totalFeesCollected += parkingFee;
        }
        else{
            throw new IllegalArgumentException(REQUIRED_FIELDS_ERROR_MESSAGE);
        }
    }
    /**
     * This method stores the calculated total hours and total fees in the garage totals map
     * for future writing to the text file
     */
    public void storeNewGarageTotals(){
        garageTotals.put("Total Hours", Double.toString(totalParkedHours));
        garageTotals.put("Total Fees", Double.toString(totalFeesCollected));
    }
    
    /**
     * @return totalFeesCollected
     */
    public double getAccumulatedFeesCollected(){
        return totalFeesCollected;
    }
    
    /**
     * @return totalParkedHours
     */
    public double getAccumulatedParkedHours(){
        return totalParkedHours;
    }
    /**
     * Returns total fees collected for the garage company by first gathering the totals
     * from the garage text file, parsing the string into a double and storing the value in a local
     * variable for manipulation.
     * @return
     * 
     */
    public double getTotalFeesCollected() {
        gatherGarageTotalsFromFile();
        totalFeesCollected = Double.parseDouble(garageTotals.get("Total Fees").toString());
        return totalFeesCollected;
    }
    /**
     *Returns total hours parked for the garage company by first gathering the totals
     * from the garage text file, parsing the string into a double and storing the value in a local
     * variable for manipulation.
     * @return totalParkedHours
     */
    public double getTotalParkedHours() {
        gatherGarageTotalsFromFile();
        totalParkedHours = Double.parseDouble(garageTotals.get("Total Hours").toString());
        return totalParkedHours;
    }
    
    /**
     *
     * @param parkingGarageCompany
     */
    private void setParkingGarageCompany(ParkingGarageCompany parkingGarageCompany) {
        if(parkingGarageCompany != null){
        this.parkingGarageCompany = parkingGarageCompany;
        }
        else{
            throw new IllegalArgumentException(NULL_PARKING_GARAGE_COMPANY_ERROR_MESSAGE);
        }
    }

    /**
     *
     * @return parkingGarageCompany
     */
    public ParkingGarageCompany getParkingGarageCompany() {
        return parkingGarageCompany;
    }
    
     /**
     *
     * @return parkingFeeCalculationStrategy
     */
    public ParkingFeeCalculationStrategy getFeeCalculator(){
        return parkingGarageCompany.getParkingFeeCalculationStrategy();
    }
    
    /**
     * This method delegates the writeFile() method to the file manager taking the
     * parameters of the garage totals file path and the garage totals map
     * 
     */
    public void printGarageTotalsToFile(){
        fileManager.writeFile(garageTotalsFile, garageTotals);
    }
    
    /**
     *@return garageTotals
     * This method delegates the readFile() method to the file manager class
     * taking the garage totals file path as a parameter and returning a map of
     * read values
     */
    public Map gatherGarageTotalsFromFile(){
        garageTotals = fileManager.readFile(garageTotalsFile);
        
        return garageTotals;
    }
    
    /**
     * 
     * @param filePath 
     * This method sets the file path of the garage totals file
     */
    public void setGarageTotalsFile(String filePath){
        this.garageTotalsFile = filePath;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.parkingGarageCompany);
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
        final GarageManager other = (GarageManager) obj;
        if (!Objects.equals(this.parkingGarageCompany, other.parkingGarageCompany)) {
            return false;
        }
        return true;
    }
   
    
}

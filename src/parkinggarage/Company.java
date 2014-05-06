package parkinggarage;
/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This interface represents a Company from which other companies may inherit. The methods are common of all companies
 * and the interface allows for the creation of different types of companies that may want to use some details of
 * this program.
 * 
 */

public interface Company {
    /**
     * Method to get company name
     */
    public abstract String getCompanyName();
    
    /**
     * @param companyName
     * Method to set company name
     */
    public abstract void setCompanyName(String companyName);
    
    /*
     * Method to get company address
     */
    public abstract String getCompanyAddress();
    
    /**
     * @param companyAddress
     * Method to set company address
     */
    public abstract void setCompanyAddress(String companyAddress);
    
}

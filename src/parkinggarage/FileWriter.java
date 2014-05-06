package parkinggarage;

import java.util.Map;

/**
 *
 * @author J-Tron
 * @version 1.0
 * This interface allows for the creation of abstract file writer strategy objects
 */
public interface FileWriter {
    /**
     * @param filePath
     * @param dataToBeWritten
     * 
     * This abstract method takes a file path and some data and writes it to a file
     * depending upon the implementation of the code by the strategy object using the method.
     */
    
    public abstract void writeFile(String filePath, Map<String,String>dataToBeWritten);
    
}

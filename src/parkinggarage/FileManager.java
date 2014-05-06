package parkinggarage;

import java.util.Map;

/**
 *
 * @author J-Tron
 * @version 1.0
 * This is a high level service class with an object composed of a FileWriter and 
 * a FileReader. The methods within this class allow the manager to read from and write to files
 * given a file path, and data.
 */
public class FileManager {
    private FileWriter writer;
    private FileReader reader;
    
    /**
     * @param FileReader 
     * @param FileWriter
     * File manager constructor requiring reader and writer strategy objects
     */
    public FileManager(FileReader newFileReader, FileWriter newFileWriter){
        reader = newFileReader;
        writer = newFileWriter;
    }
    
    /**
     * @param filePath
     * @return map
     * This method takes a file path and delegates to the reader to read the file and return a 
     * map with the read data.
     */
    public Map readFile(String filePath){
        if(filePath == null){
            throw new IllegalArgumentException("Please enter a file path");
        }
    
    Map map = reader.readFile(filePath);
    
    return map;
            }
    
    /**
     * @param filePath
     * @param dataToBeWritten
     * This method takes a file path and data in the form of a map and delegates writing 
     * to the writer object
     */
    public void writeFile(String filePath, Map<String,String> dataToBeWritten){
        writer.writeFile(filePath, dataToBeWritten);
    }

}

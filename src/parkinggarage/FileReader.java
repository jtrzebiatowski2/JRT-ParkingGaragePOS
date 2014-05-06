package parkinggarage;

import java.util.Map;

/**
 *
 * @author J-Tron
 * @version 1.0
 * 
 * This interface allows for the abstractions of a file reader objects and requires
 * that they all contain a readFile() method returning a map.
 * @param filePath
 */
public interface FileReader {
    public abstract Map readFile(String filePath);
}

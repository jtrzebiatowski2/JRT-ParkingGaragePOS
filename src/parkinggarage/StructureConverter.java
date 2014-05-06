package parkinggarage;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author J-Tron
 * @version 1.0
 * 
 * This interface contains several different abstract methods for converting
 * different formats of text content into a map for manipulation. It also contains a method
 * for converting a map into a list. This will be used by the file reader and file writers.
 * 
 */
public interface StructureConverter {
    public abstract Map convert(String textContent);
    public abstract Map convert(List<String> textContent);
    public abstract Map convert(String[] textContent);
    public abstract Map convert(Set<String> textContent);
    public abstract Map convert(ArrayList<String> textContent);
    public abstract List convert(Map<String, String> textContent);
}

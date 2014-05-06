package parkinggarage;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 *
 * @author J-Tron
 * @version 1.0
 * This class is an implementation of a structure converter strategy object.
 * The garage totals converter class has a number of methods that lack 
 * implementation to demonstrate that many different parameters may be used
 * in the constructor, suiting to the needs of many programmers.
 * Primarily the function of this class is to use a custom conversion format
 * for the garage program by converting a list to a map and also a map to a list
 * which will be useful when reading from and writing to text files.
 * 
 */
public class GarageTotalsConverter implements StructureConverter {

    /**
     *
     * @param textContent
     * @return
     */
    @Override
    public Map convert(String textContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param textContent
     * @return totalsMap
     * 
     * This method takes a list of strings as a parameter and puts it into a map
     * for appropriate manipulation.
     */
    @Override
    public Map convert(List<String> textContent) {

        String totalHoursParked = textContent.get(0);
        String totalFeesCollected = textContent.get(1);
        
        Map<String, String> totalsMap = new LinkedHashMap<String, String>();
        totalsMap.put("Total Hours", totalHoursParked);
        totalsMap.put("Total Fees", totalFeesCollected);
        
        return totalsMap;
        
    }
    /**
     *
     * @param textContent
     * @return
     */
    @Override
    public Map convert(String[] textContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     *
     * @param textContent
     * @return
     */
    @Override
    public Map convert(Set<String> textContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     *
     * @param textContent
     * @return
     */
    @Override
    public Map convert(ArrayList<String> textContent) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @param textContent
     * @return totalsList
     * 
     * This method takes a map of strings as text content and puts it into an 
     * array list for appropriate manipulation.
     */
    @Override
    public List convert(Map<String, String> textContent) {
       String totalHoursParked = textContent.get("Total Hours").toString();
       String totalFeesCollected = textContent.get("Total Fees").toString();
       
       List<String> totalsList = new ArrayList<>();
       totalsList.add(totalHoursParked);
       totalsList.add(totalFeesCollected);
       
       return totalsList;

    }
    
}

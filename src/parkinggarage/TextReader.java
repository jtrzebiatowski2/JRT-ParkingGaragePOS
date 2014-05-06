package parkinggarage;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author J-Tron
 * @version 1.0
 * 
 * This class is an implementation of a file reader strategy object. It is composed of a 
 * structure converter strategy object and contains methods for reading text from a file.
 */
public class TextReader implements FileReader {
    
    private StructureConverter converter;
    
    public TextReader(StructureConverter txtConverter){
        if(txtConverter == null){
            throw new IllegalArgumentException("Enter a valid format type");
        }
        converter = txtConverter;
    }
    
    /**
     *
     * @param filePath
     * @return map
     * 
     * This method takes a file path as a parameter, creates a buffered reader, and also an array list
     * to store the lines read in by the reader. After the list is populated the convert method
     * is delegated to the converter object and the list is converted appropriately for manipulation.
     * 
     */
    @Override
    public Map readFile(String filePath){
        
        File data = new File(filePath);
        
        BufferedReader in = null;
        List<String> totalsList = new ArrayList<String>();
        
        try {
	   in = new BufferedReader(new java.io.FileReader(data));
	   String line = in.readLine();
	   while(line != null){
		  totalsList.add(line);
		  line = in.readLine();  
	   }
	 
        } catch(IOException ioe) {
            System.out.println("Unable to read this file");
        } finally {
            try {
                in.close();
            } catch(Exception e) {
                
            }
        }
        
        Map map = converter.convert(totalsList);
        
        return map;
    }
    
    
}

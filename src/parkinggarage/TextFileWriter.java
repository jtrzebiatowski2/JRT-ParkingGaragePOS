package parkinggarage;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This implementation of a file writer is specific to writing text to a file. It is composed with
 * a structure converter strategy object for appropriate structure conversion. The method writeFile()
 * writes data to a specific file given the path and the data to be written.
 * 
 */
public class TextFileWriter implements FileWriter {
    private StructureConverter converter;

    /**
     *
     * @param txtConverter
     */
    public TextFileWriter(StructureConverter txtConverter){
        if(txtConverter == null){
            throw new IllegalArgumentException("Enter a valid format type");
        }
        converter = txtConverter;
    }
    
    /**
     * 
     * @param filePath
     * @param dataToBeWritten 
     * 
     * This method creates a buffered writer, and also an array list for converted data to be 
     * stored within. The data is converted from a map to a list, then a for loop loops over the list
     * and writes the data to the file at the given file path.
     * 
     */
    @Override
    public void writeFile(String filePath, Map<String,String> dataToBeWritten) {
       
        File data = new File(filePath);
        
        BufferedWriter writer = null;
        
        List<String> convertedData = new ArrayList<String>();
        
        try{
            convertedData = converter.convert(dataToBeWritten);
            writer = new BufferedWriter(new java.io.FileWriter(data));
            
            for(String s : convertedData){
                writer.write(s + '\n');
            }
              
        } catch (IOException ex) {
            Logger.getLogger(TextFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally{
            try {   
                writer.close();
                } 
            catch(Exception e) {
                
            }
                }
        }
        
 }
   
    


package parkinggarage;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import javax.swing.JOptionPane;

/**
 *
 * @author J-Tron
 * @version 1.2
 * 
 * This implementation of a receipt output strategy object contains methods for
 * generating a GUI receipt output object
 */
public class GUIReceiptOutput implements ReceiptOutputStrategy{
    
    /**
     * This method overrides the method from the implemented interface. It takes a parking receipt object and passes
    * that object to the function generateReceipt(). After the receipt is generated, it is output to a message dialog
    * box.
    * @param parkingReceipt
    */
    
    @Override
        public void outputReceipt(ParkingReceipt parkingReceipt){
        if(parkingReceipt == null){
            throw new IllegalArgumentException("Parking receipt is empty");
        }
        String receipt = generateReceipt(parkingReceipt);
        JOptionPane.showMessageDialog(null, receipt, "Parking Receipt", JOptionPane.INFORMATION_MESSAGE);
    }
    
       
 /**
  * This method takes a parking receipt object and formats the information that will appear in the message dialog box.
  * The necessary information is gathered from methods within the parking receipt class and formatted with
  * the java number format and decimal format classes imported above. Each generated receipt contain the
  * individual parking information for the parked car and then displays the accumulated totals for the 
  * specific parking garage after each car checkout.
  * 
  * @param parkingReceipt
  * @return output
  */
    
public String generateReceipt(ParkingReceipt parkingReceipt){
     if(parkingReceipt == null){
            throw new IllegalArgumentException("Parking receipt is empty");
        }
    DecimalFormat df = new DecimalFormat("#.##");
    String output =
            ("************************************************************** \n" +
            "Receipt for Car Number " + parkingReceipt.getCarNumber() +  ": " +'\n'
            + "Garage Parked In: " + parkingReceipt.getParkingGarageCompanyName() + "\n"
            + "Parking Duration: " + parkingReceipt.getHoursParked() + " hours parked \n"
            + "Fee Charged: " + NumberFormat.getCurrencyInstance().format(parkingReceipt.getParkingFeeTotal()) + '\n'
            + "Thank you for parking at " + parkingReceipt.getParkingGarageCompanyName() + '\n'
            + "************************************************************* \n"
            + "==============================================\n"
            + "Totals For " + parkingReceipt.getParkingGarageCompanyName() + " to date" + '\n'
            + "Garage Location: " + parkingReceipt.getParkingGarageCompanyAddress() + '\n'
            + "Total Hours Charged: " + df.format(parkingReceipt.getGarageTotalHours()) + '\n'
            + "Total Amount Collected: " + NumberFormat.getCurrencyInstance().format(parkingReceipt.getGarageTotalFees()) + '\n'
            + "==============================================\n\n");
    
   return output;
}
    
}

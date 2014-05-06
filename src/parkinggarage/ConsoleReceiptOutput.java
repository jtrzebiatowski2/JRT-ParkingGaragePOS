package parkinggarage;

import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 *
 * @author J-Tron
 * @version 1.2
 * This class implements a receipt output strategy object and has unique methods
 * for outputting information to console device.
 */
public class ConsoleReceiptOutput implements ReceiptOutputStrategy{
/**
 * This method overrides the method from the implemented interface. It takes a parking receipt object and passes
 * that object to the function generateReceipt(). After the receipt is generated, it is printed to the console.
 * 
 * @param parkingReceipt
*/
    @Override
        public void outputReceipt(ParkingReceipt parkingReceipt){
        String receipt = generateReceipt(parkingReceipt);
        System.out.print(receipt);
    }
    
 /**
  * This method takes a parking receipt object and formats the information that will appear in the console.
  * The necessary information is gathered from methods within the parking receipt class and formatted with
  * the java number format and decimal format classes imported above. Each generated receipt contain the
  * individual parking information for the parked car and then displays the accumulated totals for the 
  * specific parking garage after each car checkout.
  * 
  * @param parkingReceipt
  * @return output
  * 
  */
private String generateReceipt(ParkingReceipt parkingReceipt){
    if(parkingReceipt == null){
        throw new IllegalArgumentException("The parking receipt is not valid");
    }
    else{
    DecimalFormat df = new DecimalFormat("#.##");
    String output =
            ("****************************************************** \n" +
            "Receipt for Car Number " + parkingReceipt.getCarNumber() +  ": " + '\n'
            + "Garage Parked In: " + parkingReceipt.getParkingGarageCompanyName() + "\n"
            + "Parking Duration: " + parkingReceipt.getHoursParked() + " hours parked \n"
            + "Fee Charged: " + NumberFormat.getCurrencyInstance().format(parkingReceipt.getParkingFeeTotal()) + '\n'
            + "Thank you for parking at " + parkingReceipt.getParkingGarageCompanyName() + '\n'
            + "****************************************************** \n"
            + "======================================================\n"
            + "Totals For " + parkingReceipt.getParkingGarageCompanyName() + " Today " + '\n'
            + "Garage Location: " + parkingReceipt.getParkingGarageCompanyAddress() + '\n'
            + "Total Hours Charged: " + df.format(parkingReceipt.getGarageTotalHours()) + '\n'
            + "Total Amount Collected: " + NumberFormat.getCurrencyInstance().format(parkingReceipt.getGarageTotalFees()) + '\n'
            + "======================================================\n\n");
    
   return output;
    }
}

    
}

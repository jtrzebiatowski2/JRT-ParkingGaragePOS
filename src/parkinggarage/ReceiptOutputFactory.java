package parkinggarage;

/**
 *
 * @author J-Tron
 * @version 1.0
 * 
 * This represents a class that creates a simple factory pattern for receipt output type
 * 
 */
public class ReceiptOutputFactory {
    public static enum Outputs{
        CONSOLE, GUI
    }
    
    private static ReceiptOutputFactory instance;
    
    /**
     * This is an implementation of the Singleton Design Pattern.
     * The Singleton pattern is used to make sure that one and only
     * one instance of a class can ever be created. By making the
     * constructor private, we can control instance creation and provide
     * a static method (see getInstance() below) to provide what is needed.
     **/
    
    private ReceiptOutputFactory() {
    }
    
    /**
     * Needed to get a Singleton instance. Because the constructor
     * needs to be private in order to ensure only one instance exists, the 
     * getInstnce method is called to create the reciptOutputFactory
     */
    public static ReceiptOutputFactory getInstance(){
        if (instance == null){
            instance = new ReceiptOutputFactory();
        }
        return instance;
    }
    
    /**
     * This is the actual Factory method.
     * @param outputType - a type safe ENUM representing the type of
     * output to create.
     * @return a Reader built to factory specifications
     */
     public ReceiptOutputStrategy getReceiptOutput(Outputs outputType) {
        ReceiptOutputStrategy ros = null;
        
        switch(outputType) {
            case CONSOLE:
                ros = new ConsoleReceiptOutput();
                break;
            case GUI:
                ros = new GUIReceiptOutput();
                break;
        }
        
        return ros;
    }
    
}

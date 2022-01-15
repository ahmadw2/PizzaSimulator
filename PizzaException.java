
/**
 * PizzaException
 * 
 * Description: This class inherits from the RuntimeException class. 
 *              It's made for the Pizza Simulator to throw an exception 
 *              when the user tries to use methods in an improper manner.
 *
 * @author Wajeeha Ahmad
 * @version August 16, 2019
 */
public class PizzaException extends RuntimeException
{
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor calls its parent class's constructor.           
     * 
     * @param       NONE     
     */    
    public PizzaException()
    {
        super();
    }

    /**
     * Overloaded Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor calls its parent class's constructor 
     *              with a message describing the error.           
     * 
     * @param       String msg   
     */     
    public PizzaException(String msg)
    {
        super(msg);
    }
}


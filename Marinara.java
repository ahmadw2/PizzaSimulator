/**
 * Marinara
 *
 * Description: This class represents a Marinara sauce and inherits from the 
 *              Base class.
 *
 * @author Wajeeha Ahmad
 * @version August 16th, 2019
 */
public class Marinara extends Base
{
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This method calls its parent constructor which
     *              takes in a description, a money object to 
     *              represent price and an int that represents calories.
     * 
     * @param       String description, Money cost, int calories
     */    
    public Marinara(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }
}
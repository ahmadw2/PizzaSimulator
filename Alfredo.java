/**
 * Alfredo
 * 
 * Description: This class represents a Alfredo sauce and inherits from the 
 *              Base class.
 *
 * @author Wajeeha Ahmad
 * @version August 16th, 2019
 */
public class Alfredo extends Base
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
    public Alfredo(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }
}

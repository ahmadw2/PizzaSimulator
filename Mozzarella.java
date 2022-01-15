
/**
 * Mozzarella
 * 
 * Description: This class represents mozzarella and inherits from the Cheese
 *              class.
 *              
 * @author Wajeeha Ahmad
 * @version August 16th, 2019
 */
public class Mozzarella extends Cheese
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
    public Mozzarella(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }

}

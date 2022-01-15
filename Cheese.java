
/**
 * Cheese
 * 
 * Description: This class represents cheese and inherits from the Ingredient
 *              class.
 *              
 * @author Wajeeha Ahmad
 * @version August 16th, 2019
 */
public class Cheese extends Ingredient
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
    public Cheese(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }
}

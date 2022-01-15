/**
 * Sausage
 *
 * Description: This class represents sausage and inherits from the Meat
 *              class.
 *
 * @author Wajeeha Ahmad
 * @version August 16th, 2019
 */
public class Sausage extends Meat
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
    public Sausage(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }
}

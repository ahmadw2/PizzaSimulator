import java.awt.Color;
/**
 * Pepper
 * 
 * Description: This class represent peppers and inherits from the 
 *              Vegetable class. 
 *
 * @author Wajeeha Ahmad
 * @version August 16, 2019
 */
public class Pepper extends Vegetable
{
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This method calls its parent constructor which
     *              takes in a description, a money object to 
     *              represent price and an int that represents calories.
     *              It sets the color to a default of red.
     * 
     * @param       String description, Money cost, int calories
     */  
    public Pepper(String description, Money cost, int calories)
    {
        super(description, cost, calories);
        super.setColor(Color.RED);
    }
    
    /**
     * Overloaded Constructor 
     * ----------------------------------------------------------------------
     * Description: This method calls its parent constructor which
     *              takes in a description, a money object to 
     *              represent price and an int that represents calories and
     *              takes in a color object.
     *              
     * 
     * @param       String description, Money cost, int calories, Color color
     */    
    public Pepper(String description, Money cost, int calories, Color color)
    {
        super(description, cost, calories);
        super.setColor(color);
    }
    
    /**
     * Driver
     * ----------------------------------------------------------------------
     * Description: This method tests the other methods.             
     */ 
    public static void main(String[] args)
    {
        Money dollar = new Money(0, 50);
        Pepper pepper = new Pepper("Habinero", dollar, 10, Color.ORANGE);
        
        System.out.println(pepper);
    }
}

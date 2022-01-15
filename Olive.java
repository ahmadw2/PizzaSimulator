import java.awt.Color;
/**
 * Olive
 * 
 * Description: This class represent olive and inherits from the 
 *              Vegetable class.
 *
 * @author Wajeeha Ahmad
 * @version August 16, 2019
 */
public class Olive extends Vegetable
{
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This method calls its parent constructor which
     *              takes in a description, a money object to 
     *              represent price and an int that represents calories.
     *              It sets the color to a default of black.
     * 
     * @param       String description, Money cost, int calories
     */     
    public Olive(String description, Money cost, int calories)
    {
        super(description, cost, calories);
        super.setColor(Color.BLACK);
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
    public Olive(String description, Money cost, int calories, Color color)
    {
        super(description, cost, calories);
        super.setColor(color);
    }
}

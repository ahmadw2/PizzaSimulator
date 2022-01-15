import java.awt.Color;
/**
 * Vegetable
 * 
 * Description: This class represents vegetables and inherits from the 
 *              Ingredient class. It also adds a color instance variable.
 *
 * @author Wajeeha Ahmad
 * @version August 16, 2019
 */
public class Vegetable extends Ingredient
{
    Color color;
    
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This method calls its parent constructor which
     *              takes in a description, a money object to 
     *              represent price and an int that represents calories.
     * 
     * @param       String description, Money cost, int calories
     */   
    public Vegetable(String description, Money cost, int calories)
    {
        super(description, cost, calories);
    }
    
    /**
     * Overloaded Constructor 
     * ----------------------------------------------------------------------
     * Description: This method calls its parent constructor which
     *              takes in a description, a money object to 
     *              represent price and an int that represents calories.
     *              It also takes in a color object.
     *              
     * 
     * @param       String description, Money cost, int calories, Color color
     */ 
    public Vegetable(String description, Money cost, int calories, 
                    Color color)
    {
        super(description, cost, calories);
        setColor(color);
    }
    
    /**
     * toString                      
     * ----------------------------------------------------------------------
     * Description: This method is an @Override of the toString method. It
     *              returns the description, the price and the calories of 
     *              the ingredient object and the color.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns a description of the Vegetable object.
     */
    public String toString()
    {
        return super.toString() + "\nColor: " + this.color;
    }
    
    /**
     * getColor                     
     * ----------------------------------------------------------------------
     * Description: This method returns the color of the vegetable.
     * 
     * @param       NONE
     * @return      Color
     * PRE:         NONE
     * POST:        Returns the color.
     */    
    public Color getColor()
    {
        return this.color;
    }
    
    /**
     * setColor                     
     * ----------------------------------------------------------------------
     * Description: This method sets the color of the vegetable.
     * 
     * @param       Color color
     * @return      NONE
     * PRE:         NONE
     * POST:        Sets the color.
     */ 
    public void setColor(Color color)
    {
        this.color = color;
    }
   
    /**
     * equals                      
     * ----------------------------------------------------------------------
     * Description: This method is an @Override of the equals method. It
     *              returns true if the object in the param has
     *              the same description, cost and calories  and color
     *              as this vegetable.
     * 
     * @param       Object o
     * @return      boolean
     * PRE:         Object in param must be same class type.
     * POST:        Returns true if equal. False if not.
     */    
    public boolean equals(Object o)
    {
        if(super.equals(o))
        {
            Vegetable that = (Vegetable) o;
            if(this.color.equals(that.color))
            {
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

}

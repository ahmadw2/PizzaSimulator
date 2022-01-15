
/**
 * Ingredient
 * 
 * Description: This class represents an ingredient and works as a parent 
 *              class to other ingredient classes.
 *
 * @author Wajeeha Ahmad
 * @version August 16th, 2019
 */
public class Ingredient implements Comparable
{
    public final String description;
    public final Money cost;
    public final int calories;

    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This method takes in a description, a money object to 
     *              represent price and an int that represents calories.
     * 
     * @param       String description, Money cost, int calories
     */
    public Ingredient(String description, Money cost, int calories)
    {
        this.description = description;
        this.cost = cost.clone();
        this.calories = calories;
    }

    /**
     * compareTo                      
     * ----------------------------------------------------------------------
     * Description: This method is an @Override of the Comparable class.
     *              It compares the price of two ingredients and returns a 
     *              positive number if this object has a larger price. It 
     *              returns a negative number if this object has a lesser 
     *              price. It returns 0 if they're equal.
     * 
     * @param       Object o
     * @return      int
     * PRE:         Object in param should be the same class type.
     * POST:        Returns an int representing which object is greater.
     */
    public int compareTo(Object o)
    {
        if (o == null)
        {
            throw new PizzaException("Object cannot be null.");
        }

        else if(!(o instanceof Ingredient))
        {    
            throw new PizzaException("Object in param must be same Class.");
        }
        else 
        {
            Ingredient that = (Ingredient) o;
            return this.cost.compareTo(that.cost);
        }

    }

    /**
     * toString                      
     * ----------------------------------------------------------------------
     * Description: This method is an @Override of the toString method. It
     *              returns the description, the price and the calories of 
     *              the ingredient object.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns a description of the ingredient object.
     */
    public String toString()
    {
        return this.description + "\nCost: " + this.cost + "\nCalories: " +
        this.calories;
    }

    /**
     * equals                      
     * ----------------------------------------------------------------------
     * Description: This method is an @Override of the equals method. It
     *              returns true if the object in the param has
     *              the same description, cost and calories as this object.
     * 
     * @param       Object o
     * @return      boolean
     * PRE:         Object in param must be same class type.
     * POST:        Returns true if equal. False if not.
     */
    public boolean equals(Object o)
    {
        if (o == null || !(o instanceof Ingredient))
        {
            return false;
        }
        else 
        {
            Ingredient that = (Ingredient) o;
            if(this.description.equals(that.description) &&
            this.cost.equals(that.cost) &&
            this.calories == that.calories)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

}

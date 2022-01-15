import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;
/**
 * This class represents a square.
 *
 * @author Wajeeha Ahmad
 * @version July 3rd, 2019, upgraded on August 19, 2019
 */
public class Square extends Shape
{
    private int sideLength;

    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor takes in x and y coordinates as well as
     *              the side length for the square.
     * @param       int x, int y, int sideLength    
     */    
    public Square(int x, int y, int sideLength)
    {
        super(x,y);
        setSideLength(sideLength);
    }

    /**
     * getSideLength                     
     * ----------------------------------------------------------------------
     * Description: This method returns the side length of the square as an 
     *              int.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns the square's side length.
     */    
    public int getSideLength()
    {
        return this.sideLength;
    }

    /**
     * getArea                      
     * ----------------------------------------------------------------------
     * Description: This method calculates the area of the square by 
     *              multiplying the side lengths by one another.
     *              
     * @param       NONE
     * @return      double
     * PRE:         NONE
     * POST:        Returns the area of the square.      
     */    
    public double getArea()
    {
        double area = this.sideLength * this.sideLength;
        return area;
    }

    /**
     * setSideLength                      
     * ----------------------------------------------------------------------
     * Description: This method sets the side length and checks for 
     *              invariants such as making sure the int is positive.
     * 
     * @param       int sideLength
     * @return      NONE
     * PRE:         int in param must be positive.
     * POST:        The square's side length will be set.
     */    
    public void setSideLength(int sideLength)
    {
        if(sideLength < 1)
        {
            System.out.println("ERROR! Can't have negative length.");
        }
        else
        {
            this.sideLength = sideLength;
        }
    }
    
    /**
     * draw                      
     * ----------------------------------------------------------------------
     * Description: This method takes in a Graphics object and uses it to 
     *              draw the square using Java 2D. Using Graphics2D's 
     *              drawRect function, it sets the x and y coordinates for   
     *              location and takes in the side length as the height and 
     *              width to size the square it draws.
     * 
     * @param       Graphics g
     * @return      NONE
     * PRE:         NONE
     * POST:        It will render the square in a red color onto the 
     *              screen.     
     */    
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int s = this.sideLength;
        g2d.setColor(Color.RED);
        g2d.setPaint(Color.RED);
        g2d.drawRect(getX(),getY(),s,s);
    }
    
    /**
     * clone                     
     * ----------------------------------------------------------------------
     * Description: This method will return a clone of the Square Object.
     * 
     * @param       NONE
     * @return      Square
     * PRE:         NONE
     * POST:        Returns a clone of this Square.
     */      
    public Square clone()
    {
        Square clone = new Square(getX(), getY(), this.sideLength);
        return clone;
    }
    
    /**
     * toString                      
     * ----------------------------------------------------------------------
     * Description: This method returns a String representation of this 
     *              Square.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns String representation of this Square.
     */     
    public String toString()
    {
        return "Square";
    }

}


import java.awt.*;
import javax.swing.*;
import java.awt.geom.*;

/**
 * Circle
 * 
 * This class represents a circle, it inherits x and y coordinates from
 * the parent class Shape and creates new instance variables for its radius
 * to size the radius shape. 
 *
 * @author Wajeeha Ahmad
 * @version July 24th, 2019, upgraded on August 19, 2019
 */
public class Circle extends Shape
{
    private double radius;

    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor takes in x and y coordinates as well as
     *              the radius length for the circle.
     * @param       int x, int y, double r      
     */
    public Circle(int x, int y, double r)
    {
        super(x,y);
        setRadius(r);
    }

    /**
     * setRadius                      
     * ----------------------------------------------------------------------
     * Description: This method sets the radius and checks for invariants 
     *              such as making sure the double is positive.
     * 
     * @param       double r
     * @return      NONE
     * PRE:         Radius in param must be positive.
     * POST:        The circle's radius will be set to the double in the param.
     */
    public void setRadius(double r)
    {
        if(r > 0)
        {
            this.radius = r;
        }
        else
        {
            this.radius = 1;
        }
    }

    /**
     * getRadius                      
     * ----------------------------------------------------------------------
     * Description: This method returns the radius of the circle as a double.
     * 
     * @param       NONE
     * @return      double
     * PRE:         NONE
     * POST:        Returns the circle's radius.
     */
    public double getRadius()
    {
        return this.radius;
    }

    /**
     * getArea                      
     * ----------------------------------------------------------------------
     * Description: This method calculates the area of the circle and returns 
     *              it as a double. It squares the radius and multiplies it 
     *              by pi.
     * 
     * @param       NONE
     * @return      double
     * PRE:         NONE
     * POST:        Returns the area of the circle.      
     */
    public double getArea()
    {
        return (this.radius*this.radius)*Math.PI;
    }

    /**
     * draw                      
     * ----------------------------------------------------------------------
     * Description: This method takes in a Graphics object and uses it to draw
     *              the circle using Java 2D. Using Graphics2D's drawOval
     *              function, it sets the x and y coordinates for the location
     *              and takes in the radius as the height and width
     *              to size the circle it draws.
     * 
     * @param       Graphics g
     * @return      NONE
     * PRE:         NONE
     * POST:        It will render the circle in a cyan color onto the screen.     
     */
    public void draw(Graphics g)
    {
        Graphics2D g2d = (Graphics2D) g;
        int r = (int)this.radius;
        g2d.setColor(Color.CYAN);
        g2d.setPaint(Color.CYAN);
        g2d.drawOval(getX(),getY(),r,r);
    }
    
    /**
     * clone                     
     * ----------------------------------------------------------------------
     * Description: This method will return a clone of the Circle Object.
     * 
     * @param       NONE
     * @return      Circle
     * PRE:         NONE
     * POST:        Returns a clone of this Circle.
     */    
    public Circle clone()
    {
        Circle clone = new Circle(getX(), getY(), this.radius);
        return clone;
    }
    
    /**
     * toString                      
     * ----------------------------------------------------------------------
     * Description: This method returns a String representation of this 
     *              Circle.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns String representation of this circle.
     */    
    public String toString()
    {
        return "Circle";
    }
}

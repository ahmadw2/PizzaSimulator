import java.awt.*;

/** Class Shape
 *
 * By Rob Nash (edited by Wajeeha Ahmad)
 * 
 * This is the superclass in a hierarchy of shapes that you have to construct
 */

class Shape implements Cloneable {
    private int x = 0;
    private int y = 0;
    
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor takes in two x and y coordinates
     *              and sets them.
     * 
     * @param       int a, int b
     */    
    public Shape( int a, int b ) {
        x=a;
        y=b;
    }

    /**
     * getArea                      
     * ----------------------------------------------------------------------
     * Description: This method is meant to be overidden by child classes.
     *              It will return the area of the shape.
     * 
     * @param       NONE
     * @return      double
     * PRE:         NONE
     * POST:        Returns area.
     */    
    public double getArea(){ return -1; }

    /**
     * draw                      
     * ----------------------------------------------------------------------
     * Description: This method is meant to be overidden by child classes.
     *              It will draw of the shape.
     * 
     * @param       Graphics g
     * @return      NONE
     * PRE:         NONE
     * POST:        Draws the shape.
     */    
    public void draw( Graphics g ){}

    /**
     * getX                      
     * ----------------------------------------------------------------------
     * Description: This method returns the value of x.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns x.
     */
    public int getX() { return x; }

    /**
     * getY                      
     * ----------------------------------------------------------------------
     * Description: This method returns the value of y.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns y.
     */    
    public int getY() { return y; }
    
    /**
     * clone                     
     * ----------------------------------------------------------------------
     * Description: This method is meant to be overidden by child classes.
     *              It will return a clone of the shape Object.
     * 
     * @param       NONE
     * @return      Shape
     * PRE:         NONE
     * POST:        Returns a clone of this Shape.
     */  
    public Shape clone(){return new Shape(getX(), getY());}
}

import java.io.Serializable;
/**
 * This class represents US money in the form of dollars and cents.
 *
 * @author Wajeeha Ahmad
 * @version July 20th, 2019, upgraded on August 16th, 2019
 */
public class Money implements Comparable, Cloneable, Serializable
{
    private int dollars;
    private int cents;

    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor takes in dollars and sets it to the 
     *              instance variables.
     * @param       int dol
     */
    public Money(int dol)
    {
        setDollars(dol);
        setCents(0);
    }
    
    /**
     * Overloaded Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor takes in dollars and cents and sets it 
     *              to the instance variables.
     * @param       int dol, int cent
     */
    public Money(int dol, int cent)
    {
        setMoney(dol, cent);
    }

    /**
     * Copy Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor takes in dollars and cents of a Money 
     *              object and copies it into a new Object.
     * @param       Money other
     */
    public Money(Money other)
    {
        this.dollars = other.dollars;
        this.cents = other.cents;
    }
    
    /**
     * compareTo                      
     * ----------------------------------------------------------------------
     * Description: This method compares this Money with another Money object.
     *              If this Money's amount is greater than the Money amount
     *              in the param, it will return a positive number. If it is
     *              less than the amount, it will return a negative number.
     *              If the amounts are equal, it will return a 0.
     * 
     * @param       Object other
     * @return      int
     * PRE:         Object in param must be of same class.
     * POST:        This method will return an int representing whether or
     *              not this object is greater than than the object in the 
     *              param.
     */
    public int compareTo(Object other)
    {
        if (other == null)
        {
            throw new NullPointerException("Object cannot be null.");
        }

        else if(!(other instanceof Money))
        {    
            throw new RuntimeException("Object in param must be same Class.");
        }
        else 
        {
            Money that = (Money) other;
            if(this.dollars > that.dollars) return 1;
            else if(this.dollars < that.dollars) return -1;
            else
            {
                if(this.cents > that.cents)return 1;
                else if(this.cents < that.cents) return -1;
                else return 0;
            }
        }
    }
    
    /**
     * clone                       
     * ----------------------------------------------------------------------
     * Description: This method returns a clone of this Money object, it 
     *              creates a deep copy using the copy constructor and then
     *              returns that.
     * 
     * @param       NONE
     * @return      Money
     * PRE:         NONE
     * POST:        This method will return a clone of this object.
     */
    public Money clone()
    {
        return new Money(this);
    }

    /**
     * setDollars                       
     * ----------------------------------------------------------------------
     * Description: This method sets the dollar amount and checks for 
     *              invariants.
     * 
     * @param       int dol
     * @return      NONE
     * PRE:         Dollars in param must be positive.
     * POST:        Sets the int as the dollar amount.
     */
    public void setDollars(int dol)
    {
        if(dol >= 0)
        {
            this.dollars = dol;
        }
        else
        {
            System.out.println("ERROR! Cannot have negative dollar input.");
        }
    }

    /**
     * setCents                       
     * ----------------------------------------------------------------------
     * Description: This method sets the cent amount and checks for 
     *              invariants.
     * 
     * @param       int cent
     * @return      NONE
     * PRE:         Cents in param must be positive and in between 0 - 99.
     * POST:        Sets the int as the cent amount.     
     */
    public void setCents(int cent)
    {
        if(cent >= 0 && cent <= 99)
        {
            this.cents = cent;
        }
        else
        {
            System.out.println("ERROR! Cents must be between 0 - 99.");
        }
    }

    /**
     * setMoney                        
     * ----------------------------------------------------------------------
     * Description: This method sets the cent and dollar amount and checks 
     *              for invariants.
     * 
     * @param       int dol, int cent
     * @return      NONE
     * PRE:         Cents and Dollars must be positive. Cents must be 0 - 99.
     * POST:        Sets the money amount to the ints in the param.
     */
    public void setMoney(int dol, int cent)
    {
        setDollars(dol);
        setCents(cent);
    }

    /**
     * getDollars                     
     * ----------------------------------------------------------------------
     * Description: This method returns the dollar amount.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns the dollar amount.
     */
    public int getDollars()
    {
        return this.dollars;
    }

    /**
     * getCents                       
     * ----------------------------------------------------------------------
     * Description: This method returns the cents amount.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns the cents amount.    
     */
    public int getCents()
    {
        return this.cents;
    }

    /**
     * getMoney                        
     * ----------------------------------------------------------------------
     * Description: This method returns the amount of money as a Double.
     * 
     * @param       NONE
     * @return      Double
     * PRE:         NONE
     * POST:        Returns the amount of money as a Double.
     */
    public double getMoney()
    {
        double money = 0.0;
        double decimalCents = 0.0;

        decimalCents = this.cents/100.0;
        money = this.dollars + decimalCents;

        return money;
    }

    /**
     * add                       
     * ----------------------------------------------------------------------
     * Description: This method adds dollars to the current amount.
     * 
     * @param       int dol
     * @return      NONE
     * PRE:         The dollars being added must be positive.
     * POST:        The dollars will be added to the current amount.
     */
    public void add(int dol)
    {

        if(dol >= 0)
        {
            int totalDollars = this.dollars + dol;
            setDollars(totalDollars);
        }
        else
        {
            System.out.println("ERROR! Cannot add negative dollars.");
        }
    }

    /**
     * add (overloaded)                        
     * ----------------------------------------------------------------------
     * Description: This method adds the dollars and cents to the current
     *              amount.
     * 
     * @param       int dol, int cent    
     * @return      NONE
     * PRE:         The dollars must be positive. The cents must be between
     *              0 - 99.
     * POST:        The amount will be added to the dollars and cents.
     */
    public void add(int dol, int cent)
    {
        add(dol);
        if(cent >= 0 && cent <= 99)
        {
            int totalCents = this.cents + cent;
            if(totalCents > 99)
            {
                this.dollars++;
                totalCents = totalCents - 100;
                setCents(totalCents);
            }
            else
            {
                setCents(totalCents);
            }
        }
        else
        {
            System.out.println("ERROR! Cents must be between 0 and 99.");
        }
    }

    /**
     * add (overloaded)                        
     * ----------------------------------------------------------------------
     * Description: This method adds the dollars and cents of a Money object
     *              to the current amount.
     * 
     * @param       Money other    
     * @return      NONE
     * PRE:         The money object should not be null.
     * POST:        The amount will be added to the dollars and cents.        
     */
    public void add(Money other)
    {
        if(other != null)
        {
            add(other.dollars, other.cents);
        }
    }

    /**
     * equals                        
     * ----------------------------------------------------------------------
     * Description: This method checks to see if the Money object is equal
     *              to another Money Object.
     * 
     * @param       Object o
     * @return      boolean
     * PRE:         NONE
     * POST:        Returns true if amounts are equal. False if not.
     */
    public boolean equals(Object o)
    {
        if(!(o instanceof Money) || o == null)
        {
            return false;
        }
        else
        {
            Money that = (Money) o;
            if(this.dollars == that.dollars && this.cents == that.cents)
            {
                return true;
            }
            else
            {
                return false;
            }
        }
    }

    /**
     * toString                        
     * ----------------------------------------------------------------------
     * Description: This method returns a String representation of the amount.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns a string representaion of the amount (ex. $5.44)
     */
    public String toString()
    {
        return "$" + this.dollars + "." + this.cents;
    }
    
    /**
     * Driver
     * ----------------------------------------------------------------------
     * Description: This method tests the other methods.             
     */    
    public static void main(String[] args)
    {
        Money m  = new Money(0,0);
        Money f  = new Money(2,0);
        m.add(f);
        System.out.println(m);
    }

}

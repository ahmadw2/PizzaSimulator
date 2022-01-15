/**
 * This Fraction class represents the ratio of two numbers.
 *
 * @author Wajeeha Ahmad
 * @version July 5th, 2019, upgraded on August 18th, 2019
 */
public class Fraction implements Comparable
{
    private int numerator;
    private int denominator;

    /**
     * No argument constructor                        
     * --------
     * Defaults to numerator and denominator to 1.
     */
    public Fraction()
    {
        this.numerator = 1;
        this.denominator = 1;
    }

    /**
     * Argument constructor                        
     * --------
     * @param num and den
     * Takes in a numerator and denominator
     * and sets them as the instance variables.
     */
    public Fraction(int num, int den)
    {
        setNumerator(num);
        setDenominator(den);
        simplify(this.numerator, this.denominator);
    }

    /**
     * compareTo                        
     * --------
     * Compares two fractions, if this one is bigger it returns a positive
     * number, If the other is bigger it will return a negative number. If
     * they're equal, it will return 0.
     * 
     * @param Object o
     * @return int.
     * PRE:  Object o must be a Fraction
     * POST: returns a int.
     */    
    public int compareTo(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("Object cannot be null.");
        }

        else if(!(o instanceof Fraction))
        {    
            throw new RuntimeException("Object in param must be same Class.");
        }
        else 
        {
            Fraction that = (Fraction) o;
            if(this.getDecimal() > that.getDecimal()) {return 1;}
            else if(this.getDecimal() < that.getDecimal()) {return -1;}
            else {return 0;}
        }
    }

    /**
     * equals                         
     * --------
     * This function takes in a Fraction object and checks to see if
     * the Fraction equals the "this" fraction.
     * @param Fraction: This is the fraction object.
     * @return : This returns a boolean, true if its equal
     * and false if it is not.
     * PRE:  NONE
     * POST: returns a boolean.
     */
    public boolean equals(Fraction other)
    {
        if(this.numerator == other.numerator && 
        this.denominator == other.denominator)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * setNumerator                         
     * --------
     * This function takes in an int representing the numerator.
     * and checks if its negative before it sets it into the instance variable.
     * @param int num: This is the int representing the numerator.
     * @return : NONE
     * PRE:  NONE
     * POST: Sets the numerator.
     */
    private void setNumerator(int num)
    {
        if(num >= 0)
        {
            this.numerator = num;
        }
        else
        {
            System.out.println("This program only uses positive fractions. " +
                "Defaulted numerator to 1.");
            this.numerator = 1;
        }
    }

    /**
     * setDenominator                         
     * --------
     * This function takes in an int representing the denominator.
     * and checks if its negative or equal to zero before it sets 
     * it into the instance variable.
     * @param int den: This is the int representing the denominator.
     * @return : NONE
     * PRE:  NONE
     * POST: Sets the denominator.
     */
    private void setDenominator(int den)
    {
        if(den == 0)
        {
            System.out.println("Error! Cannot have 0 in the denominator! " +
                "Defaulted denominator to 1.");
            this.denominator = 1;
        }
        else if(den < 0)
        {
            System.out.println("This program only uses positive fractions. " +
                "Defaulted denominator to 1.");
            this.denominator = 1;
        }

        else
        {
            this.denominator = den;
        }
    }

    /**
     * getNumerator                         
     * --------
     * This function returns the numerator.
     * @param NONE
     * @return : int representing the numerator.
     * PRE:  NONE
     * POST: returns the numerator.
     */
    public int getNumerator()
    {
        return this.numerator;
    }

    /**
     * getDenominator                         
     * --------
     * This function returns the denominator.
     * @param NONE
     * @return : int representing the denominator.
     * PRE:  NONE
     * POST: returns the denominator.
     */
    public int getDenominator()
    {
        return this.denominator;
    }

    /**
     * simplify                         
     * --------
     * This function takes in the two ints representing
     * the numerator and denominator and simplifies them.
     * @param int numerator and int denominator
     * @return : NONE
     * PRE:  NONE
     * POST: Sets the instance variable as the simplified version.
     */
    public void simplify(int num, int den)
    {
        if(num % den == 0)
        {
            this.numerator = num/den;
            this.denominator = 1;
        }
        else if(den % num == 0)
        {
            this.denominator = den/num;
            this.numerator = 1;
        }
        else if (num < den)
        {
            int greatestCommonDenominator;
            for(int i = (num - 1); i > 1; i--)
            {
                if(num % i == 0 && den % i == 0)
                {
                    greatestCommonDenominator = i;
                    this.numerator = num / i;
                    this.denominator = den / i;
                    break;
                }
            }
        }
        else if (den < num)
        {
            int greatestCommonDenominator;
            for(int i = (den - 1); i > 1; i--)
            {
                if(num % i == 0 && den % i == 0)
                {
                    greatestCommonDenominator = i;
                    this.numerator = num / i;
                    this.denominator = den / i;
                    break;
                }
            }
        }
    }

    /**
     * subtract                        
     * --------
     * This method subtracts a fraction from this fraction and returns the
     * result.
     * @param Fraction that
     * @return : Fraction
     * PRE:  Fraction being subtracted must be less than this fraction.
     * POST: Returns the differnce (doesn't change the fraction instance)
     */    
    public Fraction subtract(Fraction that)
    {
        int den = this.denominator * that.denominator;
        int num1 = this.numerator * that.denominator;
        int num2 = that.numerator * this.denominator;

        Fraction frac;
        if(num1 - num2 < 0)
        {
            System.out.println("Error, Cannot subtract more than there is.");
            frac = new Fraction(1,1);
            return frac;
        }
        else if (num1 - num2 == 0)
        {
            frac = new Fraction(0,1);
            return frac;
        }
        else
        {
            int num = num1 - num2;
            frac = new Fraction(num, den);
            return frac;
        }
    }
    
    /**
     * getDecimal                      
     * ----------------------------------------------------------------------
     * This method returns a decimal representation of the fraction as a 
     * double.
     * @param    NONE   
     * @return   double   
     * PRE:      NONE   
     * POST:     Returns decimal number of fraction.   
     */    
    public double getDecimal()
    {
        double num = 1.0 * this.numerator;
        double den = 1.0 * this.denominator;
        double total = (num/den);
        return total;
    }

    /**
     * toString                     
     * ----------------------------------------------------------------------
     * This method is a toString @Override and returns a String 
     * representation of the Fraction.
     * @param    NONE   
     * @return   String   
     * PRE:      NONE   
     * POST:     Returns String representation of the fraction.   
     */     
    public String toString()
    {
        return this.numerator + "/" + this.denominator;
    }

}

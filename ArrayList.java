/**
 * ArrayList
 * 
 * This class mimics the already existing ArrayList class.
 * It allows the user to create an array that automatically
 * resizes itself and shifts elements over. 
 *
 * @author Wajeeha Ahmad
 * @version July 14th, 2019, upgraded on August 18th, 2019
 */
public class ArrayList<Type> implements Comparable
{
    private Object[] theArray;

    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor creates an instance of the ArrayList.    
     */
    public ArrayList()
    {
        theArray = new Object[100];
    }

    /**
     * insert                         
     * ----------------------------------------------------------------------
     * Description: The method insert takes in an object and index number
     *              and inserts the object into the position of the index 
     *              number in the ArrayList's instance variable theArray. 
     *              If an element is already in that index position, it 
     *              shifts the element then places the new Object into the 
     *              index position.
     * 
     * @param       Type o, int index
     * @return      NONE
     * PRE:         Object in param should not be null or you'll get error 
     *              message.
     *              Index in param should not be negative or you'll get error 
     *              message.
     * POST:        Inserts the object into the index position provided
     *              in the argument.
     */
    public void insert(Type o, int index)
    {
        if(o != null && index >= 0 && index < (this.theArray.length))
        {
            if(this.theArray[index] == null)
            {
                this.theArray[index] = o;
            }
            else if(this.theArray[index] != null)
            {

                for(int i = 0; i < this.theArray.length; i++)
                {
                    if(this.theArray[i] == null)
                    {
                        this.theArray[i] = this.theArray[index];
                        break;
                    }
                }
                this.theArray[index] = o;
            }

        }
        else if(index >= (this.theArray.length))
        {
            Object[] biggerArray = new Object[index + 100];
            for(int i = 0; i < this.theArray.length; i++)
            {
                if(this.theArray != null)
                {
                    biggerArray[i] = this.theArray[i];
                }
            }
            this.theArray = biggerArray;
            if(this.theArray[index] == null)
            {
                this.theArray[index] = o;
            }
            else if(this.theArray[index] != null)
            {
                for(int i = 0; i < this.theArray.length; i++)
                {
                    if(this.theArray[i] == null)
                    {
                        this.theArray[i] = this.theArray[index];
                        break;
                    }
                }
                this.theArray[index] = o;
            }
        }
        else
        {
            if(o == null)
            {
                System.out.println("ERROR! Cannot have null object.");
            }
            if(index < 0)
            {
                System.out.println("ERROR! Cannot have negative index.");
            }
        }
    }

    /**
     * add                        
     * ----------------------------------------------------------------------
     * Description: The method insert an object into the next open position.
     * 
     * @param       Type o 
     * @return      NONE
     * PRE:         Object in param should not be null or you'll get error 
     *              message.
     * POST:        Inserts the object into an open slot.
     */
    public void add(Type o)
    {
        if(o != null && this.size() < (theArray.length))
        {
            for(int i = 0; i < this.theArray.length; i++)
            {
                if(this.theArray[i] == null)
                {
                    this.theArray[i] = o;
                    break;
                }
            }

        }
        else if(this.size() == (theArray.length))
        {
            this.insert(o, theArray.length);
        }
        else
        {
            System.out.println("ERROR! Cannot have null object.");
        }

    }
    
    /**
     * compareTo                       
     * ----------------------------------------------------------------------
     * Description: This method compares two ArrayLists. If this ArrayList 
     *              has a larger size it will return positive one. If the 
     *              other ArrayList has a larger size, it will return 
     *              negative one. If they have the same size, it will return
     *              0.
     *              
     * @param       Object o
     * @return      int
     * PRE:         Object in param must also be an ArrayList.
     * POST:        Returns an int representing the comparison.
     */    
    public int compareTo(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("Object cannot be null.");
        }

        else if(!(o instanceof ArrayList))
        {    
            throw new RuntimeException("Object in param must be same Class.");
        }
        else 
        {
            ArrayList that = (ArrayList) o;
            if(this.size() > that.size()) {return 1;}
            else if(this.size() < that.size()) {return -1;}
            else {return 0;}
        }
    }

    /**
     * remove                        
     * ----------------------------------------------------------------------
     * Description: This method removes the Object in the index position
     *              recieved from the argument. It returns the Object and 
     *              shifts the rest of the elements so there are no gaps in 
     *              the array. 
     * 
     * @param       int index
     * @return      Type
     * PRE:         Element should exist in the index position or you'll get 
     *              error message.
     * POST:        Returns the element in the index position recieved from 
     *              param.
     */
    public Type remove(int index)
    {
        if(this.theArray[index] != null)
        {
            Object o = this.theArray[index];
            Type t = (Type) o;
            int count = 0;
            for(int i = 0; i < this.theArray.length; i++)
            {
                if(this.theArray[i] != null)
                {
                    count++;
                }
            }
            for(int i = index; i < this.theArray.length; i++)
            {

                if(this.theArray[i] != null)
                {
                    this.theArray[i] = this.theArray[i+1];
                }
            }
            this.theArray[count] = null;
            return t;
        }
        else
        {
            System.out.println("ERROR! No element found in index " + index +
                ".");
            return null;
        }

    }

    /**
     * swap                         
     * ----------------------------------------------------------------------
     * Description: This method swaps the index position of two elements.
     * 
     * @param       int idx1, int idx2
     * @return      NONE
     * PRE:         NONE
     * POST:        Swaps the position of two elements.
     */
    public void swap(int idx1, int idx2)
    {
        if(this.theArray[idx1] != null && this.theArray[idx2] != null)
        {
            Object o = this.theArray[idx1];
            Type t = (Type) o;
            this.theArray[idx1] = this.theArray[idx2];
            this.theArray[idx2] = t;

        }
        else
        {
            throw new RuntimeException("Invalid index position.");
        }
    }

    /**
     * size                         
     * ----------------------------------------------------------------------
     * Description: This method returns an int that counts how many
     *              elements are in the ArrayList.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns the number of elements in the ArrayList.
     */
    public int size()
    {
        int count = 0;
        for(int i = 0; i < this.theArray.length; i++)
        {
            if(this.theArray[i] != null)
            {
                count++;
            }
        }
        return count;
    }

    /**
     * toString                         
     * ----------------------------------------------------------------------
     * Description: This method creates a String that lists the index number
     *              and the element that is inside it. It then returns that 
     *              String in the order of 0 to however many elements are in.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns a string with the index number and element inside
     *              of the ArrayList.
     */
    public String toString()
    {
        String stringArray = "";
        for(int i = 0; i < this.theArray.length; i++)
        {
            if(this.theArray[i] != null)
            {

                stringArray = stringArray + "Index " + i + ": " + theArray[i] 
                + "\n";
            }
        }
        return stringArray;
    }

    /**
     * isEmpty                      
     * ----------------------------------------------------------------------
     * Description: This method returns a boolean that declares whether or 
     *              not the ArrayList is empty.
     * 
     * @param       NONE
     * @return      boolean
     * PRE:         NONE
     * POST:        Returns a boolean: True if ArrayList is empty. False if 
     *              it is not empty.
     */
    public boolean isEmpty()
    {
        boolean isEmpty = false;
        for(int i = 0; i < this.theArray.length; i++)
        {
            if(this.theArray[i] == null)
            {
                isEmpty = true;
            }
            else
            {
                isEmpty = false;
                break;
            }
        }
        return isEmpty;
    }

    /**
     * indexOf                        
     * ----------------------------------------------------------------------
     * Description: This method takes in an Object in its argument and
     *              returns the index number in which that Object as an 
     *              element is located in the ArrayList.
     * 
     * @param       Type o
     * @return      int
     * PRE:         NONE
     * POST:        Returns index position of Object if it is found in the
     *              elements of the ArrayList. If not found, it returns a -1.
     */
    public int indexOf(Type o)
    {
        int num = -1;
        for(int i = 0; i < this.theArray.length; i++)
        {
            if(this.theArray[i] == o)
            {
                num = i;
                break;
            }
        }
        return num;
    }

    /**
     * equals                        
     * ----------------------------------------------------------------------
     * Description: This method takes in another ArrayList into its argument
     *              and returns a boolean that shows whether or not the 
     *              contents of each ArrayList are the same or not.
     * 
     * @param       ArrayList that
     * @return      boolean
     * PRE:         NONE
     * POST:        Returns a boolean: True if the contents in both ArrayLists
     *              match. False if they are not the same.
     */
    public boolean equals(ArrayList that)
    {
        if(this.size() == that.size())
        {
            boolean isEqual = false;
            for(int i = 0; i < this.theArray.length; i++)
            {
                if(this.theArray[i] == that.theArray[i])
                {
                    isEqual = true;
                }
                else
                {
                    isEqual = false;
                    break;
                }
            }
            return isEqual;
        }
        else
        {
            return false;
        }

    }

    /**
     * get                         
     * ----------------------------------------------------------------------
     * Description: This method returns the Object in the index position
     *              recieved from the parameter.
     * 
     * @param       int index
     * @return      Object
     * PRE:         Index number should have element stored. Or else you'll 
     *              recieve an error message.
     * POST:        Returns the Object stored in the index position.
     */
    public Type get(int index)
    {
        if(index < this.theArray.length)
        {
            if(this.theArray[index] != null)
            {
                Object o = this.theArray[index];
                Type t = (Type) o;
                return t;
            }
            else
            {
                throw new RuntimeException("ERROR! Index " + index + " returns null.");
            }
        }
        else
        {
            throw new RuntimeException("Index is out of bounds.");
        }
    }

    /**
     * Driver                        
     * ----------------------------------------------------------------------
     * Description: This method is here to test the methods above.
     */
    public static void main(String[] args)
    {
        ArrayList<Pizza> pizzas = new ArrayList<Pizza>();
        Pizza cheese = new Pizza();
        Money dollar = new Money(0, 50);
        Alfredo sauce = new Alfredo("Alfredo", dollar, 100);

        pizzas.insert(cheese, 0);

        ArrayList<Integer> numbers = new ArrayList<Integer>();
        numbers.insert(1, 1);
        numbers.add(0);
        numbers.add(2);
        numbers.insert(3, 2);
        numbers.add(4);

        System.out.println(numbers);
    }
}

/**
 * Pizza 
 * 
 * Description: This class represents a pizza. It creates a random instance 
 *              of pizza with random ingredients. 
 *
 * @author Wajeeha Ahmad
 * @version August 17, 2019
 */
public class Pizza implements PizzaComparable
{
    ArrayList<Ingredient> ingredients = new ArrayList<Ingredient>();
    int calories;
    Money price = new Money(0,0);
    Shape myShape;
    Fraction fraction;
    /**
     * Constructor 
     * ----------------------------------------------------------------------
     * Description: This constructor creates a random instance of pizza
     *              using a random number generator. If the number is even, 
     *              the pizza will be a Circle. If it's odd, it will be a 
     *              square. Other random numbers decide the rest of the 
     *              ingredients as well.
     * 
     * @param       NONE
     */
    public Pizza()
    {
        this.fraction = new Fraction(1,1);
        int random = getRandInt();
        int x = getRandInt();
        int y = getRandInt();
        int s = getRandInt();
        if(random % 2 == 0)
        {
            Circle c = new Circle(x,y,s);
            this.myShape = c;
        }
        else
        {
            Square q = new Square(x,y,s);
            this.myShape = q;
        }
        if(x % 2 == 0) 
        {
            Money cost = new Money(2, 0);
            Marinara sauce = new Marinara("Marinara", cost, 100);
            addIngredient(sauce);
        }
        else
        {
            Money cost = new Money(3, 0);
            Alfredo sauce = new Alfredo("Alfredo", cost, 150);
            addIngredient(sauce);
        }
        if(y % 2 == 0) 
        {
            Money cost = new Money(2, 0);
            Mozzarella cheese = new Mozzarella("Mozzarella", cost, 200);
            addIngredient(cheese);
        }
        else
        {
            Money cost = new Money(4, 0);
            Goat cheese = new Goat("Goat Cheese", cost, 150);
            addIngredient(cheese);
        }
        if(s % 3 == 0)
        {
            Money cost = new Money(2, 0);
            Pepperoni meat = new Pepperoni("Pepperoni", cost, 150);
            addIngredient(meat);
        }
        else if(s % 5 == 0)
        {
            Money cost = new Money(2, 0);
            Sausage meat = new Sausage("Sausage", cost, 150);
            addIngredient(meat);
        }
        else if(s % 7 == 0)
        {
            Money cost = new Money(1, 0);
            Pepper veggies = new Pepper("Pepper", cost, 30);
            addIngredient(veggies);
        }
        else if(s % 11 == 0)
        {
            Money cost = new Money(1, 0);
            Olive veggies = new Olive("Olive", cost, 30);
            addIngredient(veggies);
        }

    }

    /**
     * setRemaining                      
     * ----------------------------------------------------------------------
     * Description: This method takes in a fraction and sets the amount of
     *              pizza that is still left.
     * 
     * @param       Fraction f
     * @return      NONE
     * PRE:         Fraction value must not be above 1.
     * POST:        Sets the remaining fraction.
     */    
    public void setRemaining(Fraction f)
    {
        if(f.getNumerator() <= f.getDenominator())
        {
            Fraction newfrac = new Fraction(f.getNumerator(), 
                                            f.getDenominator());
            this.fraction = newfrac;
        }
        else
        {
            throw new PizzaException("Fraction value cannot be above 1.");
        }
    }

    /**
     * getRemaining                      
     * ----------------------------------------------------------------------
     * Description: This method returns a fraction representing the amount
     *              of pizza is left.
     * 
     * @param       NONE
     * @return      Fraction
     * PRE:         NONE
     * POST:        Returns the remaining fraction.
     */ 
    public Fraction getRemaining()
    {
        Fraction newfrac = new Fraction(this.fraction.getNumerator(), 
                this.fraction.getDenominator());
        return newfrac;
    }

    /**
     * getCalories                      
     * ----------------------------------------------------------------------
     * Description: This method returns the number of calories per slice.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns the calorie count.
     */    
    public int getCalories()
    {
        return this.calories;
    }

    /**
     * getCost                      
     * ----------------------------------------------------------------------
     * Description: This method returns a Money object representing the cost
     *              of the remaining pizza.
     * 
     * @param       NONE
     * @return      Money
     * PRE:         NONE
     * POST:        Returns the cost.
     */
    public Money getCost()
    {
        double totalCost = this.price.getMoney();
        double num = 1.0 * this.fraction.getNumerator();
        double den = 1.0 * this.fraction.getDenominator();
        double frac = (num/den);
        totalCost = totalCost * frac;

        String[] numbers = String.valueOf(totalCost).split("\\.");

        int dollars = Integer.parseInt(numbers[0]);
        String s = numbers[1];

        if(s.length() > 2)
        {
            s = s.substring(0,2);
        }
        int cents = Integer.parseInt(s);

        Money newPrice = new Money(dollars, cents);

        return newPrice;
    }

    /**
     * getRemainingArea                      
     * ----------------------------------------------------------------------
     * Description: This method returns the remaining amount of area left
     *              of the pizza.
     * 
     * @param       NONE
     * @return      double
     * PRE:         NONE
     * POST:        Returns the area.
     */    
    public double getRemainingArea()
    {
        double num = 1.0 * this.fraction.getNumerator();
        double den = 1.0 * this.fraction.getDenominator();
        double frac = (num/den);
        double area = this.myShape.getArea();
        double total = frac * area;
        return total;
    }

    /**
     * addIngredient                      
     * ----------------------------------------------------------------------
     * Description: This method adds ingredients to the ingredient array
     *              that makes up the pizza.
     * 
     * @param       Ingredient a
     * @return      NONE
     * PRE:         NONE
     * POST:        Adds to the ingredients array.
     */    
    public void addIngredient(Ingredient a)
    {
        ingredients.add(a);
        this.calories = this.calories + a.calories;
        this.price.add(a.cost);
    }

    /**
     * eatSomePizza                      
     * ----------------------------------------------------------------------
     * Description: This method takes in a fraction and subtracts it from
     *              the amount of pizza left.
     * 
     * @param       Fraction amt
     * @return      NONE
     * PRE:         Fraction in param must not be greater than fraction of
     *              pizza left.
     * POST:        Eats pizza. 
     */
    public void eatSomePizza(Fraction amt)
    {
        int den = fraction.getDenominator() * amt.getDenominator();
        int num1 = fraction.getNumerator() * amt.getDenominator();
        int num2 = amt.getNumerator() * fraction.getDenominator();

        if(num1 - num2 < 0)
        {
            throw new RuntimeException("Cannot eat more pizza than exists.");
        }
        else if (num1 - num2 == 0)
        {
            throw new PizzaException("Finished all of the Pizza.");
        }
        else
        {
            int num = num1 - num2;
            Fraction newfrac = new Fraction(num, den);
            this.fraction = newfrac;
        }

    }

    /**
     * toString                      
     * ----------------------------------------------------------------------
     * Description: This method is an @Override of the toString method.
     *              It returns the pizza's ingredients, price, calories,
     *              fraction, remaining area, and shape.
     * 
     * @param       NONE
     * @return      String
     * PRE:         NONE
     * POST:        Returns string representation of Pizza.
     */
    public String toString()
    {   
        String pizzaIngredients = "";
        for (int i = 0; i < ingredients.size(); i++){
            if(i < (ingredients.size() - 1)){
              pizzaIngredients += ingredients.get(i).description + ", ";
            }
            else{
              pizzaIngredients += ingredients.get(i).description;
            }
        }

        return "Pizza Description:" + "\nIngredients: " + pizzaIngredients
        + "\nPrice: " + getCost() + "\nCalories: " + this.calories 
        + "\nFraction remaining: " + this.fraction + "\nArea remaining: " 
        + getRemainingArea() + "\nShape: " + this.myShape + "\n";
    }

    /**
     * compareTo                      
     * ----------------------------------------------------------------------
     * Description: This method compares two instances of Pizza. If this 
     *              pizza's price is greater, it will return positive one.
     *              If the price is lesser, it will return negative one. If
     *              the prices are equal, it will return zero.
     * 
     * @param       Object o
     * @return      int
     * PRE:         Object in param must also be pizza.
     * POST:        Returns the int.
     */    
    public int compareTo(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("Object cannot be null.");
        }
        else if(!(o instanceof Pizza))
        {    
            throw new PizzaException("Object in param must be Pizza.");
        }
        else
        {
            Pizza that = (Pizza) o;
            return this.getCost().compareTo(that.getCost());
        }
    }

    /**
     * compareToBySize                      
     * ----------------------------------------------------------------------
     * Description: This method compares two instances of Pizza. If this 
     *              pizza's size is greater, it will return positive one.
     *              If the size is lesser, it will return negative one. If
     *              the sizes are equal, it will return zero.
     * 
     * @param       Object o
     * @return      int
     * PRE:         Object in param must also be pizza.
     * POST:        Returns the int.
     */      
    public int compareToBySize(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("Object cannot be null.");
        }
        else if(!(o instanceof Pizza))
        {    
            throw new PizzaException("Object in param must be Pizza.");
        }
        else
        {
            Pizza that = (Pizza) o;
            if(this.getRemainingArea() > that.getRemainingArea())
            {return 1;}
            else if(this.getRemainingArea() < that.getRemainingArea())
            {return -1;}
            else
            {return 0;}
        }
    }

    /**
     * compareToByCalories                     
     * ----------------------------------------------------------------------
     * Description: This method compares two instances of Pizza. If this 
     *              pizza's calories is greater, it will return positive one.
     *              If the calories is lesser, it will return negative one. If
     *              the calories are equal, it will return zero.
     * 
     * @param       Object o
     * @return      int
     * PRE:         Object in param must also be pizza.
     * POST:        Returns the int.
     */      
    public int compareToByCalories(Object o)
    {
        if (o == null)
        {
            throw new NullPointerException("Object cannot be null.");
        }
        else if(!(o instanceof Pizza))
        {    
            throw new PizzaException("Object in param must be Pizza.");
        }
        else
        {
            Pizza that = (Pizza) o;
            if(this.calories > that.calories)
            {return 1;}
            else if(this.calories < that.calories)
            {return -1;}
            else
            {return 0;}
        }
    }

    /**
     * setShape                      
     * ----------------------------------------------------------------------
     * Description: This method sets the shape of the pizza.
     * 
     * @param       Shape s
     * @return      NONE
     * PRE:         NONE
     * POST:        Sets pizza's shape.
     */    
    public void setShape(Shape s) 
    { 
        myShape = (Shape)s.clone();
    }

    /**
     * getShape                      
     * ----------------------------------------------------------------------
     * Description: This method returns a clone of the shape of the pizza.
     * 
     * @param       NONE
     * @return      Shape
     * PRE:         NONE
     * POST:        Gets pizza's shape.
     */      
    public Shape getShape() 
    { 
        return (Shape) myShape.clone();
    }

    /**
     * getRandInt                      
     * ----------------------------------------------------------------------
     * Description: This method is a helper method to help make random 
     *              pizza instances. It returns a random number from 1-100.
     * 
     * @param       NONE
     * @return      int
     * PRE:         NONE
     * POST:        Returns random number.
     */    
    private int getRandInt() {
        return ( (int) ( Math.random() * 100 ) ) + 1;   
    }

    /**
     * Driver
     * ----------------------------------------------------------------------
     * Description: This method tests the other methods.             
     */     
    public static void main(String[] args)
    {
        Pizza p = new Pizza();
        System.out.println(p);
        Fraction frac = new Fraction(1,5);
        p.eatSomePizza(frac);
        System.out.println(p);
        Square s = new Square(5,5,5);
        p.setShape(s);
        System.out.println(p);
        System.out.println(p.getShape());
        
    }
}

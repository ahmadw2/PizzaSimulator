import java.util.Scanner;

/** PizzaManager Skeleton File
 *  CSS 162, Final Project
 * 
 *  This class is a starting point for your final project and is incomplete.
 *  Note that if there are any inconsistencies between this skeleton and
 *  the assignment description, the assignment description controls.
 * 
 *  Author: Rob Nash with edits by Johnny Lin
 */
public class PizzaManager {

    ArrayList<Pizza> pizzas = new ArrayList<Pizza>();

    /** 
     * The console interface is defined in the start method 
     * You can exit or extend the code below to accomplish all of 
     * the outcomes defined in the homework document
     */
    public void start() {
        char selection='q';

        Scanner foo = new Scanner(System.in);

        while(true) {
            displayAllPizzas();
            displayInstructions();

            String input = foo.next();
            selection = input.charAt(0);
            switch(selection) {
                case 'A':    
                case 'a':    System.out.println("Adding a random pizza "+
                                                "to the ArrayList<Pizza>.");
                             addRandomPizza();
                break;
                case 'H':    
                case 'h':    System.out.println("Adding one hundred "+
                                                "random pizzas to the "+
                                                "ArrayList<Pizza>.");
                             for(int i = 0; i <= 100; i++)
                             {
                                 addRandomPizza();
                             }
                break;                    
                case 'E':    
                case 'e':    System.out.println("Eating a fraction of "+
                                                "a pizza. How much? (a/b)");

                             eatSomePizza(foo);
                break;            
                case 'P':    
                case 'p':    System.out.println("Sorting pizzas by (P)rice");
                             sortByPrice(); 
                break;    
                case 'S':    
                case 's':    System.out.println("Sorting pizzas by (S)ize");
                             sortBySize();
                break;          
                case 'C':    
                case 'c':    System.out.println("Sorting pizzas by (C)alories");
                             sortByCalories();
                break;
                case 'B':
                case 'b':    System.out.println("(B)inary search over pizzas by "+
                                                "calories(int).  Sorting first.  "+
                                                "What calorie count are you looking"+
                                                " for?");
                             int cals = foo.nextInt();                   
                             System.out.println("Pizza with " + cals + 
                             " calories at Index: " +
                             binarySearchByCalories(cals));
                break;             
                case 'Q':
                case 'q':    System.out.println("(Q)uitting!" );
                             System.exit(0);      
                break;
                default:     System.out.println("Unrecognized input - try again");
            }
        }

    }

    /**
     * eatSomePizza                      
     * ----------------------------------------------------------------------
     * Description: This method lets the user eat a fraction of a pizza of 
     *              their choice.
     * 
     * @param       Scanner keys
     * @return      NONE
     * PRE:         User must not eat more pizza than there is.
     * POST:        User eats the pizza. If the pizza has been totally 
     *              consumed, it will take the pizza out from the list.
     */    
    private void eatSomePizza(Scanner keys) {
        String input = keys.next();

        String[] fractionSplit = input.split("/");

        Fraction fraction = new Fraction(Integer.parseInt(fractionSplit[0]),
                Integer.parseInt(fractionSplit[1]));
        System.out.println("Which pizza? Provide index number.");  
        int index = keys.nextInt();

        Pizza p = pizzas.get(index);
        try
        {
            p.eatSomePizza(fraction);
        }
        catch(PizzaException e)
        {
            System.out.print(e + "\n");
            pizzas.remove(index);
        }
        catch(RuntimeException r)
        {
            System.out.print(r);
        }
        
    }
    
    /**
     * addRandomPizza                      
     * ----------------------------------------------------------------------
     * Description: This method creates a Pizza instance and adds it to the
     *              ArrayList of Pizzas. 
     *              
     * @param       NONE
     * @return      NONE
     * PRE:         NONE
     * POST:        Adds a pizza.
     */
    private void addRandomPizza() {
        Pizza pizza = new Pizza();
        pizzas.add(pizza);
    }

    /**
     * displayAllPizzas                      
     * ----------------------------------------------------------------------
     * Description: This method displays all the pizzas with descriptions.
     * 
     * @param       NONE
     * @return      NONE
     * PRE:         NONE
     * POST:        Displays all the pizzas.
     */    
    private void displayAllPizzas() {
        System.out.println(this.pizzas);
    }

    /**
     * sortByPrice                      
     * ----------------------------------------------------------------------
     * Description: This method uses the insertion algorithm to sort the 
     *              ArrayList by price. 
     *              (Code taken from: 
     *              https://javarevisited.blogspot.com/2014/12/
     *              insertion-sort-algorithm-in-java-to-array-example.html)
     * 
     * @param       NONE
     * @return      NONE
     * PRE:         NONE
     * POST:        This will sort the array by price.
     */    
    private void sortByPrice() 
    {  
        for(int i = 1; i < pizzas.size(); i++)
        {
            Pizza value = pizzas.get(i);
            int q = i;
            while(q > 0 && (pizzas.get(q-1).compareTo(value) == 1))
            {
                pizzas.swap(q-1,q);
                q--;
            }
        }
    }
    
    /**
     * sortBySize                      
     * ----------------------------------------------------------------------
     * Description: This method sorts the array by the area remaining of the
     *              pizza.
     * 
     * @param       NONE
     * @return      NONE
     * PRE:         NONE
     * POST:        Sorts the pizza by size. 
     */
    private void sortBySize() 
    {
        
        for(int i = 0; i < (pizzas.size()-1); i++)
        {
            int min = i;
            for(int j = (i + 1); j < pizzas.size(); j++)
            {
                if(pizzas.get(j).compareToBySize(pizzas.get(min)) == -1)
                   {
                       min = j;
                   }
            }
            if(min != i)
            {
                pizzas.swap(min,i);
            }
        }
    }

    /**
     * sortByCalories                      
     * ----------------------------------------------------------------------
     * Description: This method sorts the array by the calories per slice.
     * 
     * @param       NONE
     * @return      NONE
     * PRE:         NONE
     * POST:        Sorts the pizza by calories.      
     */    
    private void sortByCalories() 
    {
        for(int i = 0; i < (pizzas.size()-1); i++)
        {
            int min = i;
            for(int j = (i + 1); j < pizzas.size(); j++)
            {
                int num1 = pizzas.get(j).getCalories();
                int num2 = pizzas.get(min).getCalories();
                if(num1 < num2)
                   {
                       min = j;
                   }
            }
            if(min != i)
            {
                pizzas.swap(min,i);
            }
        }
    }

    /**
     * binarySearchByCalories                      
     * ----------------------------------------------------------------------
     * Description: This method takes in a calorie amount in the param and
     *              does a binary search and returns the index position of 
     *              the first pizza it finds with that amount of calories. 
     *              If a pizza with that many calories doesn't exist, it will
     *              return -1.
     * 
     * 
     * @param       int cals
     * @return      int
     * PRE:         NONE
     * POST:        Returns index position of pizza if found.
     */    
    private int binarySearchByCalories(int cals) {
        sortByCalories();
        int lowIndex = 0;
        int highIndex = (pizzas.size() - 1);
        int midIndex;
        while(lowIndex <= highIndex)
        {
            midIndex = (highIndex + lowIndex) / 2;
            if(pizzas.get(midIndex).getCalories() == cals)
            {
                return midIndex;
            }
            else if(pizzas.get(midIndex).getCalories() > cals)
            {
                highIndex = midIndex - 1;
            }
            else if(pizzas.get(midIndex).getCalories() < cals)
            {
                lowIndex = midIndex + 1;
            }
        }
        return -1;
    }

    /**
     * No need to edit functions below this line, unless extending the menu or
     * changing the instructions
     */
    private static final String instructions = 
        "-----------------------\nWelcome to PizzaManager\n" +
        "-----------------------\n(A)dd a random pizza"+
        "\nAdd a (H)undred random pizzas\n(E)at a fraction of a pizza"+
        "\nSort pizzas by (P)rice\nSort pizzas by (S)ize\nSort pizzas by (C)alories"+
        "\n(B)inary Search pizzas by calories\n(Q)uit\n";

    private void displayInstructions() {
        System.out.println(instructions);    
    }

    /*
     * Notice the one-line main function.
     */
    public static void main(String[] args) {
        new PizzaManager().start();
    }
}

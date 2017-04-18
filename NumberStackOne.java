/**
 * NumberStackOne.java - MAR-06-2016 - ITEC 220 - 
 * This class contains the stack and methods that are used to store data from the first input.
 * @author Tre Haga
 * @version 1.0
 */
import java.util.*;
public class NumberStackOne
{
    /**
     * The NumberStackOne class instance variables.
     */
    private Stack<Integer> stackOne;
    /**
     * The NumberStackOne class constructor.
     */
    public NumberStackOne()
    {
        stackOne = new Stack<Integer>();
    }
    /**
     * The pushInput method takes a string input, converts a single string character into an integer, and pushes the integer onto the top of the stack.
     * @param input The variable input to be pushed onto the stack.
     */
    public void pushInput(String input)
    {
        int digit = 0;
        for (int index = 0; index < input.length(); index++)
        {
            digit = Integer.parseInt(Character.toString(input.charAt(index)));
            this.stackOne.push(digit);
        }
    }
    /**
     * The popDIgit method removes a single integer from the top of the stack and returns that integer.
     * @return result
     */
    public int popDigit()
    {
        int result = 0;
        result = this.stackOne.pop();
        return result;
    }
    /**
     * The getNumberStackOne method returns the NumberStackOne stack.
     * @return 
     */
    public Stack<Integer> getNumberStackOne()
    {
        return this.stackOne;
    }
    /**
     * The toString method returns a single string list of each element in the stack.
     * @return result
     */
    public String toString()
    {
        String result = "";
        for (int index = 0; index < this.stackOne.size(); index++)
        {
            result += this.stackOne.get(index);
        }
        return result;
    }
}
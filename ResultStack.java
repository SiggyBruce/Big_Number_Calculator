/**
 * ResultStack.java - MAR-06-2016 - ITEC 220 - 
 * This class contains the result stack and methods that utilize the NumberStackOne and NumberStackTwo class stacks in order to produce a result.
 * @author Tre Haga
 * @version 1.0
 */
import java.util.*;
public class ResultStack
{
    /**
     * The ResultStack class instance variables.
     */
    private Stack<Integer> resultStack;
    private NumberStackOne stackOne;
    private NumberStackTwo stackTwo;
    private boolean isNegative;
    /**
     * The ResultStack class constructor.
     */
    public ResultStack()
    {
        resultStack = new Stack<Integer>();
        stackOne = new NumberStackOne();
        stackTwo = new NumberStackTwo();
        isNegative = false;
    }
    /**
     * The addDigits method takes two string input variables, calls the pushInput method for each, adds each integer, and pushes them onto the top of the resultStack stack.
     * @param inputOne The inputOne variable that holds the first string of numbers.
     * @param inputTwo The inputTwo variable that holds the second string of numbers.
     */
    public void addDigits(String inputOne, String inputTwo)
    {
        isNegative = false;
        int count = 0;
        if (inputOne.length() > inputTwo.length())
        {
            count = inputOne.length() - inputTwo.length();
            for (int index = 0; index < count; index++)
            {
                inputTwo = "0" + inputTwo;
            }
        }
        count = 0;
        if (inputTwo.length() > inputOne.length())
        {
            count = inputTwo.length() - inputOne.length();
            for (int index = 0; index < count; index++)
            {
                inputOne = "0" + inputOne;
            }
        }
        
        stackOne.pushInput(inputOne);
        stackTwo.pushInput(inputTwo);
        
        int digitOne = 0;
        int digitTwo = 0;
        int carry = 0;
        int result = 0;
        int resultDigit = 0;

        while ((!this.stackOne.getNumberStackOne().isEmpty()) || (!stackTwo.getNumberStackTwo().isEmpty()))
        {
            digitOne = stackOne.popDigit();
            digitTwo = stackTwo.popDigit();
            result = digitOne + digitTwo + carry;
            resultDigit = result % 10;
            carry = result / 10;
            this.resultStack.push(resultDigit);
        }
        if (carry > 0)
        {
            this.resultStack.push(carry);
        }
    }
    /**
     * The subtractDigits method takes two string input variables, calls the pushInput method for each, subtracts each integer, and pushes them onto the top of the resultStack stack.
     * @param inputOne The inputOne variable that holds the first string of numbers.
     * @param inputTwo The inputTwo variable that holds the second string of numbers. 
     */
    public void subtractDigits(String inputOne, String inputTwo)
    {
        int count = 0;
        if (inputOne.length() > inputTwo.length())
        {
            count = inputOne.length() - inputTwo.length();
            for (int index = 0; index < count; index++)
            {
                inputTwo = "0" + inputTwo;
            }
        }
        count = 0;
        if (inputTwo.length() > inputOne.length())
        {
            count = inputTwo.length() - inputOne.length();
            for (int index = 0; index < count; index++)
            {
                inputOne = "0" + inputOne;
            }
        }
        
        stackOne.pushInput(inputOne);
        stackTwo.pushInput(inputTwo);

        int digitOne = 0;
        int digitTwo = 0;
        int carry = 0;
        int result = 0;

        while ((!this.stackOne.getNumberStackOne().isEmpty()) || (!stackTwo.getNumberStackTwo().isEmpty()))
        {
            boolean isEqual = true;
            int index = 0;
            while (index < this.stackOne.getNumberStackOne().size() && index < this.stackTwo.getNumberStackTwo().size() && isEqual)
            {
                if (this.stackOne.getNumberStackOne().get(index) < this.stackTwo.getNumberStackTwo().get(index))
                {
                    isEqual = false;
                    isNegative = true;
                    digitOne = stackTwo.popDigit();
                    digitTwo = stackOne.popDigit();
                }
                else if (this.stackOne.getNumberStackOne().get(index) > this.stackTwo.getNumberStackTwo().get(index))
                {
                    isEqual = false;
                    isNegative = false;
                    digitOne = stackOne.popDigit();
                    digitTwo = stackTwo.popDigit();
                }
                else
                {
                    isNegative = false;
                    digitOne = stackOne.popDigit();
                    digitTwo = stackTwo.popDigit();
                }
                index++;
            }

            if ((digitOne == 0) && (digitTwo == 0) && (carry == 1))
            {
                digitOne = digitOne - carry;
                digitOne += 10;
                result = digitOne - digitTwo;
                carry = 1;
            }
            else
            {
                digitOne = digitOne - carry;
                if ((digitOne < digitTwo))
                {
                    digitOne += 10;
                    result = digitOne - digitTwo;
                    carry = 1;
                }
                else
                {
                    result = digitOne - digitTwo;
                    carry = 0;
                }
            }
            this.resultStack.push(result);
        }
    }
    /**
     * The emptyStacks method removes all elements from all three stacks.
     */
    public void emptyStacks()
    {
        while (!this.stackOne.getNumberStackOne().isEmpty())
        {
            this.stackOne.getNumberStackOne().pop();
        }
        while (!this.stackTwo.getNumberStackTwo().isEmpty())
        {
            this.stackTwo.getNumberStackTwo().pop();
        }
        while (!this.resultStack.isEmpty())
        {
            this.resultStack.pop();
        }
    }
    /**
     * The toString method removes all elements from the resultStack and returns a single string list of each element in the stack.
     * @return result
     */
    public String toString()
    {
        String result = "";
        for (int index = this.resultStack.size() - 1; index >= 0; index--)
        {
            result += this.resultStack.pop();
        }
        result = result.replaceFirst("^0+(?!$)", "");
        if (isNegative)
        {
            result = "-" + result;
        }
        return result;
    }
}
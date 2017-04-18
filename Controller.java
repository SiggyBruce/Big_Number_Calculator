/**
 * Controller.java - MAR-06-2016 - ITEC 220 - 
 * This class contains the logic and controls the data flow from the view to the model of the program. 
 * It exchanges data from the view to the model and vise versa.
 * @author Tre Haga
 * @version 1.0
 */
import java.awt.event.*;
public class Controller
{
    /**
     * The Controller class instance variables.
     */
    private View view;
    private NumberStackOne stackOne;
    private NumberStackTwo stackTwo;
    private ResultStack resultStack;
    private String inputOne, inputTwo;
    /**
     * The Controller class constructor.
     */
    public Controller()
    {
        view = new View();
	stackOne = new NumberStackOne();
        stackTwo = new NumberStackTwo();
        resultStack = new ResultStack();
	inputOne = "";
	inputTwo = "";
    }
    /**
     * The run method that initiates the beginning of the program.
     * Calls for the display from the View class.
     * Adds action listeners to the addition and subtraction buttons.
     */
    public void run()
    {
        view.display();
	view.getAdditionButton().addActionListener(new AdditionButtonClickHandler());
	view.getSubtractionButton().addActionListener(new SubtractionButtonClickHandler());
    }
    /**
     * The AdditionButtonClickHandler sub-class listens for events and executes commands when the addition button is pressed.
     */
    private class AdditionButtonClickHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                inputOne = view.getInputOne().getText();
                inputTwo = view.getInputTwo().getText();
                resultStack.addDigits(inputOne, inputTwo);
                view.setDisplayArea(resultStack.toString());
            }
            catch (NumberFormatException exception)
            {
                view.setDisplayArea("It appears you entered a character that is not considered a digit. Please try again.");
                resultStack.emptyStacks();
            }
        }
    }
    /**
     * The SubtractionButtonClickHandler sub-class listens for events and executes commands when the subtraction button is pressed.
     */
    private class SubtractionButtonClickHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent event)
        {
            try
            {
                inputOne = view.getInputOne().getText();
                inputTwo = view.getInputTwo().getText();
                resultStack.subtractDigits(inputOne, inputTwo);
                view.setDisplayArea(resultStack.toString());
            }
            catch (NumberFormatException exception)
            {
                view.setDisplayArea("It appears you entered a character that is not considered a digit. Please try again.");
                resultStack.emptyStacks();
            }
        }
    }
}
/**
 * View.java - MAR-06-2016 - ITEC 220 - 
 * This class contains methods that prompt the user and shows the visual GUI. 
 * It sends data to the Controller class to be processed.
 * @author Tre Haga
 * @version 1.0
 */
import javax.swing.*;
public class View extends JPanel
{
    /**
     * The View class instance variables.
     */
    private JTextField inputOne, inputTwo;
    private JButton additionButton, subtractionButton;
    private JTextArea displayArea;
    private JFrame frame;
    /**
     * The View class constructor.
     */
    public View()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException exception)
        {
            displayArea.setText("Unfortunately the program was unable to load the look and feel of your operating system.");
        }
	inputOne = new JTextField();
        inputTwo = new JTextField();
        additionButton = new JButton("Add");
        subtractionButton = new JButton("Subtract");
        displayArea = new JTextArea();
		
        this.setLayout(null);
        this.setSize(840, 420);
        
        this.inputOne.setSize(795, 30);
        this.inputOne.setLocation(20, 20);
        this.add(inputOne);
        
        this.inputTwo.setSize(795, 30);
        this.inputTwo.setLocation(20, 70);
        this.add(inputTwo);
        
        this.additionButton.setSize(100, 30);
        this.additionButton.setLocation(300, 120);
        this.add(additionButton);
        
        this.subtractionButton.setSize(100, 30);
        this.subtractionButton.setLocation(420, 120);
        this.add(subtractionButton);
        
        this.displayArea.setSize(795, 195);
        this.displayArea.setLocation(20, 170);
        this.displayArea.setEditable(false);
        this.displayArea.setLineWrap(true);
        this.add(displayArea);
    }
    /**
     * The display method creates a JFrame for the GUI to display.
     */
    public void display()
    {
        frame = new JFrame("Project 2");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
        this.frame.setContentPane(this);
        this.frame.setSize(840, 420);
        this.frame.setLocationRelativeTo(null);
        this.frame.setVisible(true);
    }
    /**
     * The getAdditionButton method returns the additionButton.
     * @return additionButton
     */
    public JButton getAdditionButton()
    {
        return this.additionButton;
    }
    /**
     * The getSubtractionButton method returns the subtractionButton.
     * @return subtractionButton
     */
    public JButton getSubtractionButton()
    {
        return this.subtractionButton;
    }
    /**
     * The getInputOne method returns the input of the inputOne text field.
     * @return inputOne
     */
    public JTextField getInputOne()
    {
        return this.inputOne;
    }
    /**
     * The getInputTwo method returns the input of the inputTwo text field.
     * @return inputTwo
     */
    public JTextField getInputTwo()
    {
        return this.inputTwo;
    }
    /**
     * The setDisplayArea sets the current displayArea to a new displayArea.
     * @param input The new display area.
     */
    public void setDisplayArea(String input)
    {
        this.displayArea.setText(input);
    }
}
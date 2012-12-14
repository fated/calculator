package calculator;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

/**
 * 
 */

/**
 * A controller of Calculator in MVC framework.
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93contro
 * ller"> Model–view–controller from Wikipedia</a>
 */
public class CalcView extends JFrame {

	/**
	 * Auto generated.
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Input Text Field.
	 */
	private JTextField inputTF;
    /**
     * Result Text Field.
     */
    private JTextField resultTF;
    /**
     * Calculate Button.
     */
    private JButton	calcButton;
    /**
     * Reverse Polish Radio Button.
     */
    private JRadioButton revButton;
    /**
     * Infix Radio Button.
     */
    private JRadioButton infixButton;
    /**
     * ButtonGroup of the pair of radio buttons.
     */
    private ButtonGroup bg;
    
	/**
	 * A constructor of class CalcController, adds components to the panel 
	 * and paint.
	 */
	public CalcView() {
		//set text fields
		inputTF = new JTextField(15);
		resultTF = new JTextField(15);
		resultTF.setBackground(Color.GRAY);
		resultTF.setForeground(Color.BLACK);
		resultTF.setEditable(false);

		//set button, radio buttons and button group
		calcButton = new JButton("Calculate");
		bg = new ButtonGroup();
		revButton = new JRadioButton("Reverse Polish");
		revButton.setActionCommand("postfix");
		infixButton = new JRadioButton("Infix", true);
		infixButton.setActionCommand("infix");
		bg.add(revButton);
		bg.add(infixButton);
		
		//set main panel and main layout
		JPanel content = new JPanel();
		content.setSize(300, 200);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.add(Box.createRigidArea(new Dimension(100, 5)));

		//add calcButton
        calcButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(calcButton);
		
		//set center panel and layout
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout());

		//add labels and text fields
		JPanel label = new JPanel();
		label.setLayout(new BoxLayout(label, BoxLayout.Y_AXIS));
		label.add(new JLabel("Expression"));
		label.add(new JLabel("Result"));
		center.add(label);
		
		JPanel tf = new JPanel();
		tf.setLayout(new BoxLayout(tf, BoxLayout.Y_AXIS));
		tf.add(inputTF);
		tf.add(resultTF);
		center.add(tf);

		//add center to content
		content.add(center);
		
		//add radio buttons
		JPanel radio = new JPanel();
		radio.setLayout(new FlowLayout());
		radio.add(revButton);
		radio.add(infixButton);
		content.add(radio);

		this.setContentPane(content);
		this.pack();
		this.setTitle("Calculator");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/**
	 * A method that gets the expression from text field.
	 * @return the string form of the expression.
	 */
	public final String getExpression() {
		return inputTF.getText();
	}
	
	/**
	 * A method that sets the value to text field.
	 * @param str the string form of the calculated value.
	 */
	public final void setAnswer(final String str) {
		resultTF.setText(str);
		resultTF.setBackground(Color.GRAY);		//change color
		resultTF.setForeground(Color.BLACK);
	}
	
	/**
	 * A method that sets the error message to text field.
	 * @param err the string form of the error message.
	 */
	public final void setErrorMessage(final String err) {
		resultTF.setText(err);
		resultTF.setBackground(Color.RED);		//change color
		resultTF.setForeground(Color.WHITE);
	}
	
	/**
	 * A method that adds a listener to the button.
	 * @param bl button listener.
	 */
	public final void addButtonListener(final ActionListener bl) {
		calcButton.addActionListener(bl);
	}
	
	/**
	 * A method that adds a listener to the radio button.
	 * @param rl radio listener.
	 */
	public final void addRadioListener(final ActionListener rl) {
		revButton.addActionListener(rl);
		infixButton.addActionListener(rl);
	}
}

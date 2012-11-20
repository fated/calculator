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
 * @author Bruce
 *
 */
public class CalcView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String expression;
	private String answer;
	private JTextField inputTF;
    private JTextField resultTF;
    private JButton	calcButton;
    private JRadioButton revButton;
    private JRadioButton infixButton;
    private ButtonGroup bg;
    
	public CalcView() {
		inputTF = new JTextField(15);
		resultTF = new JTextField(15);
		resultTF.setEditable(false);

		calcButton = new JButton("Calculate");
		bg = new ButtonGroup();
		revButton = new JRadioButton("Reverse Polish");
		revButton.setActionCommand("rev");
		infixButton = new JRadioButton("Infix", true);
		infixButton.setActionCommand("infix");
		bg.add(revButton);
		bg.add(infixButton);
		
		JPanel content = new JPanel();
		content.setSize(300, 200);
		content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
		content.add(Box.createRigidArea(new Dimension(100,5)));

        calcButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		content.add(calcButton);
		
		JPanel center = new JPanel();
		center.setLayout(new FlowLayout());

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

		content.add(center);
		
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
	
	public String getExpression() {
		expression = inputTF.getText();
		return expression;
	}
	
	public void setAnswer(String str) {
		answer = str;
		resultTF.setText(answer);
	}
	
	public void addButtonListener(ActionListener bl) {
		calcButton.addActionListener(bl);
	}
	
	public void addRadioListener(ActionListener rl1, ActionListener rl2) {
		revButton.addActionListener(rl1);
		infixButton.addActionListener(rl2);
	}
}

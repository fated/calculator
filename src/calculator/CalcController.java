package calculator;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * A controller of Calculator in MVC framework.
 * @author Bruce
 * @see <a href="http://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93contro
 * ller"> Model�Cview�Ccontroller from Wikipedia</a>
 */
public final class CalcController {

	/**
	 * View of Calculator in MVC framework.
	 */
	private static CalcView view;
	/**
	 * Model of Calculator in MVC framework.
	 */
	private static CalcModel model;
	/**
	 * Infix state.
	 */
	private static boolean isInfix = true;
	
	/**
	 * A constructor of class CalcController, initializes all fields and<br> 
	 * add action listeners to the view.
	 */
	private CalcController() {
		view = new CalcView();		//initialize
		model = new CalcModel();
		view.addButtonListener(new ButtonListener());	//add listeners
        view.addRadioListener(new RadioListener());
		view.setVisible(true);		//display
	}

	/**
	 * Launch the problem.
	 * @param args command arguments.
	 */
	public static void main(final String[] args) {
		@SuppressWarnings("unused")
		CalcController controller = new CalcController();
	}
	
	/**
	 * A private button listener class implements action listener interface.
	 * @author Bruce
	 *
	 */
	private class ButtonListener implements ActionListener {

		/**
		 * Invoked when an button is pressed.
		 * @param e action event.
		 * @see java.awt.event.ActionListener#actionPerformed
		 * (java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(final ActionEvent e) {
			String expr = view.getExpression();
			String result = "";
			
			try {
				result = Float.toString(model.evaluate(expr, isInfix));
				view.setAnswer(result);
			} catch (InvalidExpressionException e1) {
				view.setErrorMessage(e1.getMessage());	//output error message
			}
		}
		
	}
	
	/**
	 * A private radio button listener class implements action listener 
	 * interface.
	 * @author Bruce
	 *
	 */
	private class RadioListener implements ActionListener {

		/**
		 * Invoked when one of the radio buttons is selected.
		 * @param e action event.
		 * @see java.awt.event.ActionListener#actionPerformed
		 * (java.awt.event.ActionEvent)
		 */
		@Override
		public void actionPerformed(final ActionEvent e) {
			if (e.getActionCommand().equals("postfix")) {
				isInfix = false;
			}
			if (e.getActionCommand().equals("infix")) {
				isInfix = true;
			}
		}
		
	}
	
}

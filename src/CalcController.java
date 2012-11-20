import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 */

/**
 * @author Bruce
 *
 */
public class CalcController {

	private static CalcView view;
	private static CalcModel model;
	private static boolean isInfix = true;
	
	public CalcController() {
		view = new CalcView();
		model = new CalcModel();
		view.setVisible(true);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		CalcController controller = new CalcController();
		
		class ButtonListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String expr = view.getExpression();
				String result = "";
				
				try {
					result = Float.toString(model.evaluate(expr, isInfix));
				} catch (InvalidExpressionException e1) {
					// TODO Auto-generated catch block
				}
				view.setAnswer(result);
				view.setVisible(true);
			}
			
		}
		
		class RadioListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (e.getActionCommand().equals("rev"))
					isInfix = false;
				if (e.getActionCommand().equals("infix"))
					isInfix = true;
			}
		}
		
		view.addButtonListener(new ButtonListener());
        view.addRadioListener(new RadioListener(), new RadioListener());
	}
	
}

package Calculator;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.event.ActionEvent;

/**
 * Class of different actions when you press buttons
 * @author Ibra_san
 *
 */
public class Actions {
	//Panel with buttons
	private GUI gui;
	private JPanel buttonPanel;
	private JTextArea display;
	//Remember entered numbers and operator
	private int firstNum, secondNum;
	private String operation;
	
	/**
	 * Constructor
	 * @param gui Our buttons and display
	 */
	public Actions(GUI gui) {
		this.gui = gui;
		this.buttonPanel = gui.getPanel();
		this.display = gui.getDisplay();
		this.operation = ""; //Empty operation, when start entering
		
		addNumAction(); //Actions for numbers
		addDeleteAction(); //Action for C button
		addOperationActions(); //Actions for operators
		runAction(); //Action for result
	}
	
	/**
	 * Actions for number buttons
	 */
	private void addNumAction() {
		//Get buttons from 0 to 9
		for(int i = 0; i < 11; i++) {
			if(i != 9) { //9 button is + on our panel
				JButton button = (JButton)buttonPanel.getComponent(i);
				//Add action for every button
				button.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						//If we took result, the next number clear our display
						if(operation.equals("=")) {
							display.setText("");
							operation = "";
						}
						//Display next number
						display.setText(display.getText() + button.getText());
					}
				});
			}
		}
	}
	
	/**
	 * Action for C button
	 */
	private void addDeleteAction() {
		JButton button = gui.get(GUI.DEL);
		//Add action, delete last number
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String currentNum = display.getText();
				display.setText(currentNum.substring(0, currentNum.length()-1));
			}
		});
	}
	
	/**
	 * Actions for operator's buttons
	 */
	private void addOperationActions() {
		//+
		JButton button = gui.get(GUI.PLUS);
		button.addActionListener(getOperationListener(button));
		//-
		button = gui.get(GUI.MINUS);
		button.addActionListener(getOperationListener(button));
		//x
		button = gui.get(GUI.MULT);
		button.addActionListener(getOperationListener(button));
		//:
		button = gui.get(GUI.DIVIDE);
		button.addActionListener(getOperationListener(button));
	}
	
	/**
	 * Get action for every operator's button
	 * @param button Operator's button
	 * @return Action
	 */
	private ActionListener getOperationListener(JButton button) {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//Remember number and operator
				firstNum = Integer.valueOf(display.getText());
				operation = button.getText();
				display.setText(operation);
			}
		};
	}
	
	/**
	 * Action for result
	 */
	private void runAction() {
		JButton button = gui.get(GUI.RUN);
		//Add action
		button.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int l = display.getText().length();
				//Remember second number
				secondNum = Integer.valueOf(display.getText().substring(1, l));
				//Get result and display
				if(operation.equals("+"))
					display.setText("=" + (firstNum+secondNum));
				if(operation.equals("-"))
					display.setText("=" + (firstNum-secondNum));
				if(operation.equals("x"))
					display.setText("=" + (firstNum*secondNum));
				if(operation.equals("/")) {
					//We can't divide by 0
					if(secondNum != 0)
						display.setText("=" + (firstNum/secondNum));
					else
						display.setText("Uncorrect result");
				}
				//Remember finish operator =,
				//if we wanna enter next number, it clears display
				operation = button.getText();
			}
		});
	}
}

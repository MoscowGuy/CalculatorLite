package Calculator;
import javax.swing.JTextArea;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.GridLayout;

/**
 * Class of our program's gui
 * @author Ibra_san
 *
 */
public class GUI {
	private JTextArea display;
	private JPanel buttonPanel;
	private JButton buttonRun; //= operator
	
	//Constants for buttons, we can easy get button from gui
	public static final int BUT_0 = 10;
	public static final int BUT_1 = 0;
	public static final int BUT_2 = 1;
	public static final int BUT_3 = 2;
	public static final int BUT_4 = 3;
	public static final int BUT_5 = 4;
	public static final int BUT_6 = 5;
	public static final int BUT_7 = 6;
	public static final int BUT_8 = 7;
	public static final int BUT_9 = 8;
	public static final int PLUS = 9;
	public static final int MINUS = 11;
	public static final int MULT = 12;
	public static final int DIVIDE = 14;
	public static final int DEL = 13;
	public static final int RUN = 15;
	
	/**
	 * Empty constructor of gui
	 */
	public GUI() {
		createGUI();
	}
	
	/**
	 * Creating gui, add display, buttons and set them onto panel
	 */
	private void createGUI() {
		display = new JTextArea();
		buttonPanel = new JPanel(new GridLayout(5,3));
		
		JButton[] buttons = new JButton[15];
		
		//Create buttons for numbers 1-9
		for(int i = 0; i < 9; i++)
			buttons[i] = new JButton("" + (i+1));
		//Buttons for operations, add 0 button on center
		buttons[9] = new JButton("+");
		buttons[10] = new JButton("0");
		buttons[11] = new JButton("-");
		buttons[12] = new JButton("x");
		buttons[13] = new JButton("C");
		buttons[14] = new JButton("/");
		buttonRun = new JButton("="); 
		//Set buttons in panel
		for(JButton button : buttons)
			buttonPanel.add(button);
	}
	
	/**
	 * Get button's panel
	 * @return Panel
	 */
	public JPanel getPanel() {
		return this.buttonPanel;
	}
	
	/**
	 * Get display area
	 * @return TextArea display
	 */
	public JTextArea getDisplay() {
		return this.display;
	}
	
	/**
	 * Get number button
	 * @param i Constant by button's name (BUT_0, MINUS and etc)
	 * @return Button
	 */
	public JButton get(int i) {
		if(i == 15)
			return this.buttonRun;
		return (JButton)this.buttonPanel.getComponent(i);
	}

}

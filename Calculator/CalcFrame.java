package Calculator;
import javax.swing.JFrame;
import java.awt.BorderLayout;

/**
 * Class of program main frame
 * @author Ibra_san
 *
 */
@SuppressWarnings("serial")
public class CalcFrame extends JFrame{
	private GUI gui;
	
	/**
	 * Empty constructor, create gui, add actions for buttons
	 */
	CalcFrame(){
		gui = new GUI();
		
		setBounds(300,300,300,300);
		setLayout(new BorderLayout());
		add(gui.getDisplay(), BorderLayout.NORTH);
		add(gui.getPanel(), BorderLayout.CENTER);
		add(gui.get(GUI.RUN), BorderLayout.SOUTH);
		
		new Actions(gui);
		
		setVisible(true);
	}
}

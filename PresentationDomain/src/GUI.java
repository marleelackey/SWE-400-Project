import java.awt.*;
import javax.swing.*;

/**
 * This here be the gui
 * @author Joshua Kellogg
 *
 */
public class GUI {
	private final Dimension FRAME_SIZE = new Dimension(800, 500);
	
	JFrame mainFrame = new JFrame("SWE Rocks!");
	
	JPanel elementMainPanel = new JPanel();
	JPanel listOfElementsPanel = new JPanel();
	JPanel elementControlPanel = new JPanel();
	
	JPanel metalMainPanel = new JPanel();
	JPanel listOfMetalsPanel = new JPanel();
	JPanel metalControlPanel = new JPanel();
	
	JPanel compoundMainPanel = new JPanel();
	JPanel listOfCompoundPanel = new JPanel();
	JPanel compoundControlPanel = new JPanel();
	
	JPanel acidMainPanel = new JPanel();
	JPanel listOfAcidsPanel = new JPanel();
	JPanel acidControlPanel = new JPanel();
	
	JPanel baseMainPanel = new JPanel();
	JPanel listOfBasesPanel = new JPanel();
	JPanel baseControlPanel = new JPanel();
	
	JPanel chemicalMainPanel = new JPanel();
	JPanel listOfChemicalsPanel = new JPanel();
	JPanel chemicalControlPanel = new JPanel();
	
	public GUI() {
		setupPanels(elementMainPanel, listOfElementsPanel, elementControlPanel);
		mainFrame.setPreferredSize(FRAME_SIZE);
		mainFrame.pack();
		mainFrame.add(elementMainPanel);
		mainFrame.setVisible(true);
	}
	
	private void setupPanels(JPanel main, JPanel list, JPanel control) {
		list.setPreferredSize(new Dimension( (int)Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		control.setPreferredSize(new Dimension( (int)Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		list.setBackground(new Color(235, 91, 52));
		control.setBackground(new Color(52, 186, 235));
		main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));
		main.add(list);
		main.add(control);
	}
	
}

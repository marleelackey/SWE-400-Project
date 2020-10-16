package gui;
import java.awt.*;
import javax.swing.*;

import commands.AddElementCmd;
import commands.ExecuterForCommands;

import java.awt.event.*;

/**
 * This here be the gui
 * 
 * @author Joshua Kellogg
 *
 */
public class MasterGUI implements guiInterface {
	

	JFrame mainFrame = new JFrame("SWE Rocks!");
	JTabbedPane mainPane = new JTabbedPane();

	public MasterGUI() {

		mainFrame.setPreferredSize(FRAME_SIZE);
		mainFrame.pack();

		mainPane.addTab("Element", new ElementGUI().elementMainPanel);
		mainPane.addTab("Metal", new MetalGUI().metalMainPanel);
		mainPane.addTab("Compound", new CompoundGUI().compoundMainPanel);
		mainPane.addTab("Acid", new AcidGUI().acidMainPanel);
		mainPane.addTab("Base", new BaseGUI().baseMainPanel);
		mainPane.addTab("Chemical", new ChemicalGUI().chemicalMainPanel);

		mainFrame.add(mainPane);
		mainFrame.setVisible(true);
	}

	private void setupPanels(JPanel main, JPanel list, JPanel control) {
		list.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		control.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		list.setBackground(new Color(235, 91, 52));
		control.setBackground(new Color(52, 186, 235));
		main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));
		main.add(list);
		main.add(control);
	}

	
}

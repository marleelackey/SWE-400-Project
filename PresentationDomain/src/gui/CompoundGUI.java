package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class CompoundGUI implements guiInterface {
	JPanel compoundMainPanel = new JPanel();
	JPanel listOfCompoundPanel = new JPanel();
	JPanel compoundControlPanel = new JPanel();
	
	public CompoundGUI() {
		listOfCompoundPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		compoundControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfCompoundPanel.setBackground(new Color(235, 91, 52));
		compoundControlPanel.setBackground(new Color(52, 186, 235));
		compoundMainPanel.setLayout(new BoxLayout(compoundMainPanel, BoxLayout.LINE_AXIS));
		compoundMainPanel.add(listOfCompoundPanel);
		compoundMainPanel.add(compoundControlPanel);
	}
}

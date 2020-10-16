package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class AcidGUI implements guiInterface {
	JPanel acidMainPanel = new JPanel();
	JPanel listOfAcidsPanel = new JPanel();
	JPanel acidControlPanel = new JPanel();
	
	public AcidGUI() {
		listOfAcidsPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		acidControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfAcidsPanel.setBackground(new Color(235, 91, 52));
		acidControlPanel.setBackground(new Color(52, 186, 235));
		acidMainPanel.setLayout(new BoxLayout(acidMainPanel, BoxLayout.LINE_AXIS));
		acidMainPanel.add(listOfAcidsPanel);
		acidMainPanel.add(acidControlPanel);
	}
}

package gui;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class ChemicalGUI implements guiInterface {
	JPanel chemicalMainPanel = new JPanel();
	JPanel listOfChemicalsPanel = new JPanel();
	JPanel chemicalControlPanel = new JPanel();

	public ChemicalGUI() {
		listOfChemicalsPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		chemicalControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfChemicalsPanel.setBackground(new Color(235, 91, 52));
		chemicalControlPanel.setBackground(new Color(52, 186, 235));
		chemicalMainPanel.setLayout(new BoxLayout(chemicalMainPanel, BoxLayout.LINE_AXIS));
		chemicalMainPanel.add(listOfChemicalsPanel);
		chemicalMainPanel.add(chemicalControlPanel);
	}
}

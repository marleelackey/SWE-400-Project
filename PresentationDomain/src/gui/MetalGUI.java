package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class MetalGUI implements GUIInterface{

	static JPanel metalMainPanel = new JPanel();
	JPanel listOfMetalsPanel = new JPanel();
	JPanel metalControlPanel = new JPanel();
	
	
	public MetalGUI() {
		listOfMetalsPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		metalControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfMetalsPanel.setBackground(new Color(235, 91, 52));
		metalControlPanel.setBackground(new Color(52, 186, 235));
		metalMainPanel.setLayout(new BoxLayout(metalMainPanel, BoxLayout.LINE_AXIS));
		metalMainPanel.add(listOfMetalsPanel);
		metalMainPanel.add(metalControlPanel);
	}


	public static JPanel getmetalMainPanel() {
		return metalMainPanel;
	}
}

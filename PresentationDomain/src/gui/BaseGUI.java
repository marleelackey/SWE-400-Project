package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JPanel;

public class BaseGUI implements GUIInterface {
	static JPanel baseMainPanel = new JPanel();
	JPanel listOfBasesPanel = new JPanel();
	JPanel baseControlPanel = new JPanel();
	
	public BaseGUI() {
		listOfBasesPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		baseControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfBasesPanel.setBackground(new Color(235, 91, 52));
		baseControlPanel.setBackground(new Color(52, 186, 235));
		baseMainPanel.setLayout(new BoxLayout(baseMainPanel, BoxLayout.LINE_AXIS));
		baseMainPanel.add(listOfBasesPanel);
		baseMainPanel.add(baseControlPanel);
	}

	public static JPanel getBaseMainPanel() {
		return baseMainPanel;
	}
}

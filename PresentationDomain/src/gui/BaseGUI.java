package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class BaseGUI implements guiInterface {
	JPanel baseMainPanel = new JPanel();
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
		
		setuplistOfBasesPanel();
		setupupdateBasePanel();
		setupmodifyBaseAmountPanel();
	}

	private void setuplistOfBasesPanel() {
		listOfBasesPanel.add(new JLabel("Bases"));
	}

	private void setupupdateBasePanel() {
		JButton updateBaseButton = new JButton("Update");
		JPanel updateBasePanel = new JPanel(new GridLayout(0,2));
		updateBasePanel.add(new JLabel("Weight: "));
		JTextField weightInput = new JTextField();
		updateBasePanel.add(weightInput);
		updateBasePanel.add(new JLabel("Volume: "));
		JTextField volumeInput = new JTextField();
		updateBasePanel.add(volumeInput);
		updateBasePanel.add(updateBaseButton);
		
		updateBaseButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command stuff goes here
				 * 
				 */
			}
		});
		
		baseControlPanel.add(updateBasePanel);
		
	}
	
	private void setupmodifyBaseAmountPanel() {
		JPanel modifyBaseAmountPanel = new JPanel(new GridLayout(0, 2));
		modifyBaseAmountPanel.setBackground(new Color(220, 200, 220));	
		modifyBaseAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox baseNameInput = new JComboBox(new String[] {"Foundation", "Bunker", "Water"});
		modifyBaseAmountPanel.add(baseNameInput);
		modifyBaseAmountPanel.add(new JLabel("New Amount"));
		JTextField newAmountInput = new JTextField();
		modifyBaseAmountPanel.add(newAmountInput);
		JButton changeAmount = new JButton("Change");
		changeAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * Integer.parseInt(newAmountInput.getText()) -- new amount
				 */
			}
		});
		modifyBaseAmountPanel.add(changeAmount);
		baseControlPanel.add(modifyBaseAmountPanel);
	}
}

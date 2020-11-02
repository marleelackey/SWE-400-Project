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

public class MetalGUI implements guiInterface {
	JPanel metalMainPanel = new JPanel();
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
		
		setuplistOfMetalsPanel();
		setupupdateMetalPanel();
		setupfillerMetalPanel();
		setupmodifyMetalAmountPanel();
	}
	
	private void setuplistOfMetalsPanel() {
		listOfMetalsPanel.add(new JLabel("Metal"));
	}

	private void setupupdateMetalPanel() {
		JButton updateMetalButton = new JButton("Update");
		JPanel updateMetalPanel = new JPanel(new GridLayout(0,2));
		updateMetalPanel.add(new JLabel("Weight: "));
		JTextField weightInput = new JTextField();
		updateMetalPanel.add(weightInput);
		updateMetalPanel.add(new JLabel("Volume: "));
		JTextField volumeInput = new JTextField();
		updateMetalPanel.add(volumeInput);
		updateMetalPanel.add(updateMetalButton);
		
		updateMetalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command stuff goes here
				 * 
				 */
			}
		});
		
		metalControlPanel.add(updateMetalPanel);
	}
	private void setupfillerMetalPanel() {
		JPanel fillerMetalPanel = new JPanel(new GridLayout(0,2));
		
		metalControlPanel.add(fillerMetalPanel);
	}
	private void setupmodifyMetalAmountPanel() {
		JPanel modifyMetalAmountPanel = new JPanel(new GridLayout(0, 2));
		modifyMetalAmountPanel.setBackground(new Color(220, 200, 220));	
		modifyMetalAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox metalNameInput = new JComboBox(new String[] {"Steel", "Iron", "Rusty"});
		modifyMetalAmountPanel.add(metalNameInput);
		modifyMetalAmountPanel.add(new JLabel("New Amount"));
		JTextField newAmountInput = new JTextField();
		modifyMetalAmountPanel.add(newAmountInput);
		JButton changeAmount = new JButton("Change");
		changeAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * Integer.parseInt(newAmountInput.getText()) -- new amount
				 */
			}
		});
		modifyMetalAmountPanel.add(changeAmount);
		metalControlPanel.add(modifyMetalAmountPanel);
	}
}

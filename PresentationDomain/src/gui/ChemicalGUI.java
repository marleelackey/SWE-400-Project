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
		
		setuplistOfChemicalsPanel();
		setupupdateChemicalPanel();
		setupmodifyChemicalAmountPanel();
	}

	private void setuplistOfChemicalsPanel() {
		listOfChemicalsPanel.add(new JLabel("Chemical"));
	}

	private void setupupdateChemicalPanel() {
		JButton updateChemicalButton = new JButton("Update");
		JPanel updateChemicalPanel = new JPanel(new GridLayout(0,2));
		updateChemicalPanel.add(new JLabel("Weight: "));
		JTextField weightInput = new JTextField();
		updateChemicalPanel.add(weightInput);
		updateChemicalPanel.add(new JLabel("Volume: "));
		JTextField volumeInput = new JTextField();
		updateChemicalPanel.add(volumeInput);
		updateChemicalPanel.add(updateChemicalButton);
		
		updateChemicalButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command stuff goes here
				 * 
				 */
			}
		});
		
		chemicalControlPanel.add(updateChemicalPanel);
	}
	
	private void setupmodifyChemicalAmountPanel() {
		JPanel modifyChemicalAmountPanel = new JPanel(new GridLayout(0, 2));
		modifyChemicalAmountPanel.setBackground(new Color(220, 200, 220));	
		modifyChemicalAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox chemicalNameInput = new JComboBox(new String[] {"GenericChemName", "Chem", "CoolGuyChem"});
		modifyChemicalAmountPanel.add(chemicalNameInput);
		modifyChemicalAmountPanel.add(new JLabel("New Amount"));
		JTextField newAmountInput = new JTextField();
		modifyChemicalAmountPanel.add(newAmountInput);
		JButton changeAmount = new JButton("Change");
		changeAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * Integer.parseInt(newAmountInput.getText()) -- new amount
				 */
			}
		});
		modifyChemicalAmountPanel.add(changeAmount);
		chemicalControlPanel.add(modifyChemicalAmountPanel);
	}
}

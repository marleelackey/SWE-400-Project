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
		
		setuplistOfCompoundPanel();
		setupupdateCompoundPanel();
		setupmodifyCompoundAmountPanel();
		setupaddElementToCompoundAmountPanel();
		setupremoveElementFromCompoundAmountPanel();
	}

	private void setuplistOfCompoundPanel() {
		listOfCompoundPanel.add(new JLabel("Compound"));
	}

	private void setupupdateCompoundPanel() {
		JButton updateCompoundButton = new JButton("Update");
		JPanel updateCompoundPanel = new JPanel(new GridLayout(0,2));
		updateCompoundPanel.add(new JLabel("Weight: "));
		JTextField weightInput = new JTextField();
		updateCompoundPanel.add(weightInput);
		updateCompoundPanel.add(new JLabel("Volume: "));
		JTextField volumeInput = new JTextField();
		updateCompoundPanel.add(volumeInput);
		updateCompoundPanel.add(updateCompoundButton);
		
		updateCompoundButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command stuff goes here
				 * 
				 */
			}
		});

		compoundControlPanel.add(updateCompoundPanel);
	}
	
	private void setupmodifyCompoundAmountPanel() {
		JPanel modifyCompoundAmountPanel = new JPanel(new GridLayout(0, 2));
		modifyCompoundAmountPanel.setBackground(new Color(220, 200, 220));	
		modifyCompoundAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox compoundNameInput = new JComboBox(new String[] {"TwoThings", "ThreeThings", "Multiple"});
		modifyCompoundAmountPanel.add(compoundNameInput);
		modifyCompoundAmountPanel.add(new JLabel("New Amount"));
		JTextField newAmountInput = new JTextField();
		modifyCompoundAmountPanel.add(newAmountInput);
		JButton changeAmount = new JButton("Change");
		changeAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * Integer.parseInt(newAmountInput.getText()) -- new amount
				 */
			}
		});
		modifyCompoundAmountPanel.add(changeAmount);
		compoundControlPanel.add(modifyCompoundAmountPanel);
	}
	
	private void setupaddElementToCompoundAmountPanel() {
		JPanel addElementToCompoundAmountPanel = new JPanel(new GridLayout(0, 2));
		addElementToCompoundAmountPanel.setBackground(new Color(220, 240, 220));	
		addElementToCompoundAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox compoundNameInput = new JComboBox(new String[] {"TwoThings", "ThreeThings", "Multiple"});
		addElementToCompoundAmountPanel.add(compoundNameInput);
		// Commmand stuff to get list of elements in the compound
		JComboBox elementNameInput = new JComboBox(new String[] {"Element", "Eleminty", "OLOmont"});
		addElementToCompoundAmountPanel.add(elementNameInput);

		JButton addElement = new JButton("Remove");
		addElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * 
				 */
			}
		});
		addElementToCompoundAmountPanel.add(addElement);
		compoundControlPanel.add(addElementToCompoundAmountPanel);
	}
	
	private void setupremoveElementFromCompoundAmountPanel() {
		JPanel removeElementFromCompoundAmountPanel = new JPanel(new GridLayout(0, 2));
		removeElementFromCompoundAmountPanel.setBackground(new Color(220, 100, 220));	
		removeElementFromCompoundAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox compoundNameInput = new JComboBox(new String[] {"TwoThings", "ThreeThings", "Multiple"});
		removeElementFromCompoundAmountPanel.add(compoundNameInput);
		// Command thing for getting list of Elements
		JComboBox elementNameInput = new JComboBox(new String[] {"Element", "Eleminty", "OLOmont"});
		removeElementFromCompoundAmountPanel.add(elementNameInput);
		
		JButton removeElement = new JButton("Remove");
		removeElement.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * 
				 */
			}
		});
		removeElementFromCompoundAmountPanel.add(removeElement);
		compoundControlPanel.add(removeElementFromCompoundAmountPanel);
	}
}

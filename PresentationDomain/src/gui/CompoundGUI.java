package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import commands.ExecuterForCommands;
import commands.GetAllCompoundsCmd;
import commands.GetAllElementsCmd;

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
	
	private void setupaddElementToCompoundAmountPanel() {
		JPanel addElementToCompoundAmountPanel = new JPanel(new GridLayout(0, 2));
		addElementToCompoundAmountPanel.setBackground(new Color(220, 240, 220));	
		addElementToCompoundAmountPanel.add(new JLabel("Add Element"));
		ArrayList<String> compNames = new ArrayList<String>();
		GetAllCompoundsCmd compGetter = new GetAllCompoundsCmd();
		try {
			new ExecuterForCommands(compGetter);
			compGetter.getCdo().forEach(n -> compNames.add(n.getCompoundName()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JComboBox compoundNameInput = new JComboBox(compNames.toArray());
		addElementToCompoundAmountPanel.add(compoundNameInput);
		// Commmand stuff to get list of elements in the compound
		ArrayList<String> elementNames = new ArrayList<String>();
		GetAllElementsCmd elementGetter = new GetAllElementsCmd();
		try {
			new ExecuterForCommands(elementGetter);
			elementGetter.getElements().forEach(n -> elementNames.add(n.getElementName()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JComboBox elementNameInput = new JComboBox(elementNames.toArray());
		addElementToCompoundAmountPanel.add(elementNameInput);

		JButton addElement = new JButton("Add");
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
		removeElementFromCompoundAmountPanel.add(new JLabel("Remove Element"));
		ArrayList<String> compNames = new ArrayList<String>();
		GetAllCompoundsCmd compGetter = new GetAllCompoundsCmd();
		try {
			new ExecuterForCommands(compGetter);
			compGetter.getCdo().forEach(n -> compNames.add(n.getCompoundName()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JComboBox compoundNameInput = new JComboBox(compNames.toArray());
		removeElementFromCompoundAmountPanel.add(compoundNameInput);
		// Command thing for getting list of Elements
		ArrayList<String> elementNames = new ArrayList<String>();
		GetAllElementsCmd elementGetter = new GetAllElementsCmd();
		try {
			new ExecuterForCommands(elementGetter);
			elementGetter.getElements().forEach(n -> elementNames.add(n.getElementName()));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		JComboBox elementNameInput = new JComboBox(elementNames.toArray());		
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

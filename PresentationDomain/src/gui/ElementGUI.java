package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import commands.AddElementCmd;
import commands.ExecuterForCommands;

public class ElementGUI implements guiInterface {
	JPanel elementMainPanel = new JPanel();
	JPanel listOfElementsPanel = new JPanel();
	JPanel elementControlPanel = new JPanel();
	
	public ElementGUI() {
		listOfElementsPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		elementControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfElementsPanel.setBackground(new Color(235, 91, 52));
		elementControlPanel.setBackground(new Color(52, 186, 235));
		elementMainPanel.setLayout(new BoxLayout(elementMainPanel, BoxLayout.LINE_AXIS));
		elementMainPanel.add(listOfElementsPanel);
		elementMainPanel.add(elementControlPanel);
		
		elementControlPanel.setLayout(new BoxLayout(elementControlPanel, BoxLayout.PAGE_AXIS));
		
		setuplistOfElementsPanel();
		setupAddElementPanel();
		setupfindElementsInRangePanel();
		setupfindElementPanel();
		setupgetCompoundByElementPanel();
		setupmodifyElementPanel();
	}
	
	private void setuplistOfElementsPanel() {
		listOfElementsPanel.add(new JLabel("Element"));
	}

	private void setupAddElementPanel() {
		JPanel addElementPanel = new JPanel(new GridLayout(0, 2));
		addElementPanel.setBackground(new Color(52, 186, 235));
		JButton addElementButton = new JButton("Add Element");

		addElementPanel.add(new JLabel("Add Element"));
		addElementPanel.add(addElementButton);
		addElementPanel.add(new JLabel("Atomic Number: "));
		JTextField atomicNumberInput = new JTextField();
		addElementPanel.add(atomicNumberInput);
		addElementPanel.add(new JLabel("Atomic Mass: "));
		JTextField atomicMassInput = new JTextField();
		addElementPanel.add(atomicMassInput);
		addElementPanel.add(new JLabel("Name: "));
		JTextField nameInput = new JTextField();
		addElementPanel.add(nameInput);
		JCheckBox isMetalInput = new JCheckBox("Is Metal?");
		addElementPanel.add(isMetalInput);
		JComboBox metalDissolvedByInput = new JComboBox(new String[]{"Thing1", "Thing2", "ThingThrice"});
		addElementPanel.add(metalDissolvedByInput);

		addElementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				new ExecuterForCommands(
//						new AddElementCmd(547, nameInput.getText(), Integer.parseInt(atomicNumberInput.getText()),
//								Double.parseDouble(atomicMassInput.getText()), isMetalInput.isSelected(), 0));
			}
		});

		elementControlPanel.add(addElementPanel);
	}
	
	private void setupfindElementsInRangePanel() {
		JPanel findElementsInRangePanel = new JPanel(new GridLayout(0, 2));
		findElementsInRangePanel.setBackground(new Color(52, 186, 235));
		findElementsInRangePanel.add(new JLabel("Find Elements In Range"));
		JButton findElementsInRangeButton = new JButton("Find");
		findElementsInRangePanel.add(findElementsInRangeButton);
		findElementsInRangePanel.add(new JLabel("Lower Bound"));
		JTextField lowerBoundInput = new JTextField();
		findElementsInRangePanel.add(lowerBoundInput);
		findElementsInRangePanel.add(new JLabel("Upper Bound"));
		JTextField upperBoundInput = new JTextField();
		findElementsInRangePanel.add(upperBoundInput);
		
		findElementsInRangeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 */
			}
		});
		
		elementControlPanel.add(findElementsInRangePanel);
	}
	
	private void setupfindElementPanel() {
		JPanel findElementPanel = new JPanel();
		findElementPanel.setBackground(new Color(52, 186, 235));		
		JButton findByButton = new JButton("Find");
		findElementPanel.add(new JLabel("Find Element By Something"));
		JComboBox findByType = new JComboBox(new String[] {"Atomic Number","Atomic Mass","Name"});
		findElementPanel.add(findByType);
		findElementPanel.add(findByButton);
		
		findByButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 */
			}
		});
		
		elementControlPanel.add(findElementPanel);
	}
	
	private void setupgetCompoundByElementPanel() {
		JPanel getCompoundByElementPanel = new JPanel(new GridLayout(0, 2));
		getCompoundByElementPanel.setBackground(new Color(52, 186, 235));	
		getCompoundByElementPanel.add(new JLabel("Get Compounds By Element"));
		JButton getCompoundsButton = new JButton("Find Compounds");
		getCompoundByElementPanel.add(getCompoundsButton);
		getCompoundByElementPanel.add(new JLabel("Element Name"));
		JTextField elementNameInput = new JTextField();
		getCompoundByElementPanel.add(elementNameInput);
		getCompoundsButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 */
			}
		});
		
		elementControlPanel.add(getCompoundByElementPanel);
	}
	
	private void setupmodifyElementPanel() {
		JPanel modifyElementPanel = new JPanel();
		modifyElementPanel.setBackground(new Color(52, 186, 235));		
		modifyElementPanel.add(new JLabel("Modify Element"));
		
		elementControlPanel.add(modifyElementPanel);
	}

}

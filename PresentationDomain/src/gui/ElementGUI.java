package gui;
import java.awt.*;
import javax.swing.*;

import commands.AddElementCmd;
import commands.ExecuterForCommands;

import java.awt.event.*;

public class ElementGUI implements GUIInterface{
	
	static JPanel elementMainPanel = new JPanel();
	JPanel listOfElementsPanel = new JPanel();
	JPanel elementControlPanel = new JPanel();
	
	private JPanel addElementPanel = new JPanel(new GridLayout(0, 2));
	private	JPanel findElementsInRangePanel = new JPanel(new GridLayout(0, 2));
	private JPanel findElementPanel = new JPanel();
	private JPanel getCompoundByElementPanel = new JPanel();
	private JPanel modifyElementPanel = new JPanel();
	
	private JButton controlAddElementButton = new JButton("Add Element");
	private JTextField controlAtomicNumberInput = new JTextField();
	private JTextField controlAtomicMassInput = new JTextField();
	private JTextField controlNameInput = new JTextField();
	private JCheckBox controlIsMetalInput = new JCheckBox("Is Metal?");
	private JComboBox controlMetalDissolvedByInput = new JComboBox(new String[]{"Thing1", "Thing2", "ThingThrice"});
	//TODO Replace the string array with actual names of acids from the database
	
	private JTextField upperRangeInput = new JTextField();
	private JTextField lowerRangeInput = new JTextField();

	
	public ElementGUI() {
		
		listOfElementsPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		elementControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfElementsPanel.setBackground(new Color(235, 91, 52));
		elementControlPanel.setBackground(new Color(52, 186, 235));
		elementMainPanel.setLayout(new BoxLayout(elementMainPanel, BoxLayout.LINE_AXIS));
		elementMainPanel.add(listOfElementsPanel);
		elementMainPanel.add(elementControlPanel);
		
		elementControlPanel.setLayout(new BoxLayout(elementControlPanel, BoxLayout.PAGE_AXIS));

		
		addElementPanel.setBackground(new Color(52, 186, 235));
		findElementsInRangePanel.setBackground(new Color(52, 186, 235));
		findElementPanel.setBackground(new Color(52, 186, 235));
		getCompoundByElementPanel.setBackground(new Color(52, 186, 235));
		modifyElementPanel.setBackground(new Color(52, 186, 235));
		
		setupAddElementPanel();
		setupFindElementsInRangePanel();
		
		findElementsInRangePanel.add(new JTextArea("Find Elements In Range"));
		findElementPanel.add(new JTextArea("Find Element By Something"));
		getCompoundByElementPanel.add(new JTextArea("Get Compounds By Element"));
		modifyElementPanel.add(new JTextArea("Modify Element"));
		
		elementControlPanel.add(addElementPanel);
		elementControlPanel.add(findElementsInRangePanel);
		elementControlPanel.add(findElementPanel);
		elementControlPanel.add(getCompoundByElementPanel);
		elementControlPanel.add(modifyElementPanel);
	}
	
	/**
	 * Setup for the Add Element functionality, also has action listener for the add element button
	 */
	//TODO Replace the 0 in the AddElementCmd constructor with and acid id picked from the controlMetalDissolvedByInput combobox
	private void setupAddElementPanel() {
		addElementPanel.add(new JTextArea("Add Element"));
		addElementPanel.add(controlAddElementButton);
		addElementPanel.add(new JTextArea("Atomic Number: "));
		addElementPanel.add(controlAtomicNumberInput);
		addElementPanel.add(new JTextArea("Atomic Mass: "));
		addElementPanel.add(controlAtomicMassInput);
		addElementPanel.add(new JTextArea("Name: "));
		addElementPanel.add(controlNameInput);
		addElementPanel.add(controlIsMetalInput);
		addElementPanel.add(controlMetalDissolvedByInput);

		controlAddElementButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ExecuterForCommands(
						new AddElementCmd(547, controlNameInput.getText(), Integer.parseInt(controlAtomicNumberInput.getText()),
								Double.parseDouble(controlAtomicMassInput.getText()), controlIsMetalInput.isSelected(), 0));
			}
		});

	}
	
	private void setupFindElementsInRangePanel() {
		findElementsInRangePanel.add(new JTextArea("Upper Bound: "));
		findElementsInRangePanel.add(upperRangeInput);
		findElementsInRangePanel.add(new JTextArea("Lower Bound: "));
		findElementsInRangePanel.add(lowerRangeInput);
	}
	
	public static JPanel getElementMainPanel() {
		return elementMainPanel;
	}
}

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
import javax.swing.JTextArea;
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
		
		setupelementPanel();
	}
	
	private void setupelementPanel() {
		JPanel addElementPanel = new JPanel(new GridLayout(0, 2));
		addElementPanel.setBackground(new Color(52, 186, 235));
		JPanel findElementsInRangePanel = new JPanel();
		findElementsInRangePanel.setBackground(new Color(52, 186, 235));
		JPanel findElementPanel = new JPanel();
		findElementPanel.setBackground(new Color(52, 186, 235));
		JPanel getCompoundByElementPanel = new JPanel();
		getCompoundByElementPanel.setBackground(new Color(52, 186, 235));
		JPanel modifyElementPanel = new JPanel();
		modifyElementPanel.setBackground(new Color(52, 186, 235));

		elementControlPanel.setLayout(new BoxLayout(elementControlPanel, BoxLayout.PAGE_AXIS));

		JButton addElementButton = new JButton("Add Element");

		addElementPanel.add(new JTextArea("Add Element"));
		addElementPanel.add(addElementButton);
		addElementPanel.add(new JTextArea("Atomic Number: "));
		JTextField atomicNumberInput = new JTextField();
		addElementPanel.add(atomicNumberInput);
		addElementPanel.add(new JTextArea("Atomic Mass: "));
		JTextField atomicMassInput = new JTextField();
		addElementPanel.add(atomicMassInput);
		addElementPanel.add(new JTextArea("Name: "));
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
				System.out.println("Booton Pressed");
				System.out.println("Atomic Num is: " + atomicNumberInput.getText());
				System.out.println("Atomic Mass is: " + atomicMassInput.getText());
				System.out.println("Name is: " + nameInput.getText());
			}
		});

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
}

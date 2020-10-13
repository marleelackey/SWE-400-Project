import java.awt.*;
import javax.swing.*;

import commands.AddElementCmd;
import commands.ExecuterForCommands;

import java.awt.event.*;

/**
 * This here be the gui
 * 
 * @author Joshua Kellogg
 *
 */
public class GUI {
	private final Dimension FRAME_SIZE = new Dimension(800, 500);

	JFrame mainFrame = new JFrame("SWE Rocks!");
	JTabbedPane mainPane = new JTabbedPane();

	JPanel elementMainPanel = new JPanel();
	JPanel listOfElementsPanel = new JPanel();
	JPanel elementControlPanel = new JPanel();

	JPanel metalMainPanel = new JPanel();
	JPanel listOfMetalsPanel = new JPanel();
	JPanel metalControlPanel = new JPanel();

	JPanel compoundMainPanel = new JPanel();
	JPanel listOfCompoundPanel = new JPanel();
	JPanel compoundControlPanel = new JPanel();

	JPanel acidMainPanel = new JPanel();
	JPanel listOfAcidsPanel = new JPanel();
	JPanel acidControlPanel = new JPanel();

	JPanel baseMainPanel = new JPanel();
	JPanel listOfBasesPanel = new JPanel();
	JPanel baseControlPanel = new JPanel();

	JPanel chemicalMainPanel = new JPanel();
	JPanel listOfChemicalsPanel = new JPanel();
	JPanel chemicalControlPanel = new JPanel();

	public GUI() {
		setupPanels(elementMainPanel, listOfElementsPanel, elementControlPanel);
		setupPanels(metalMainPanel, listOfMetalsPanel, metalControlPanel);
		setupPanels(compoundMainPanel, listOfCompoundPanel, compoundControlPanel);
		setupPanels(acidMainPanel, listOfAcidsPanel, acidControlPanel);
		setupPanels(baseMainPanel, listOfBasesPanel, baseControlPanel);
		setupPanels(chemicalMainPanel, listOfChemicalsPanel, chemicalControlPanel);

		setupelementPanel();

		mainFrame.setPreferredSize(FRAME_SIZE);
		mainFrame.pack();

		mainPane.addTab("Element", elementMainPanel);
		mainPane.addTab("Metal", metalMainPanel);
		mainPane.addTab("Compound", compoundMainPanel);
		mainPane.addTab("Acid", acidMainPanel);
		mainPane.addTab("Base", baseMainPanel);
		mainPane.addTab("Chemical", chemicalMainPanel);

		mainFrame.add(mainPane);
		mainFrame.setVisible(true);
	}

	private void setupPanels(JPanel main, JPanel list, JPanel control) {
		list.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		control.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		list.setBackground(new Color(235, 91, 52));
		control.setBackground(new Color(52, 186, 235));
		main.setLayout(new BoxLayout(main, BoxLayout.LINE_AXIS));
		main.add(list);
		main.add(control);
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
				new ExecuterForCommands(
						new AddElementCmd(547, nameInput.getText(), Integer.parseInt(atomicNumberInput.getText()),
								Double.parseDouble(atomicMassInput.getText()), isMetalInput.isSelected(), 0));
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

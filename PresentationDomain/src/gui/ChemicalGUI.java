package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
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
}

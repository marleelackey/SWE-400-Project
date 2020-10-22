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

public class AcidGUI implements guiInterface {
	JPanel acidMainPanel = new JPanel();
	JPanel listOfAcidsPanel = new JPanel();
	JPanel acidControlPanel = new JPanel();
	
	public AcidGUI() {
		listOfAcidsPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .2), FRAME_SIZE.height));
		acidControlPanel.setPreferredSize(new Dimension((int) Math.floor(FRAME_SIZE.height * .8), FRAME_SIZE.height));
		listOfAcidsPanel.setBackground(new Color(235, 91, 52));
		acidControlPanel.setBackground(new Color(52, 186, 235));
		acidMainPanel.setLayout(new BoxLayout(acidMainPanel, BoxLayout.LINE_AXIS));
		acidMainPanel.add(listOfAcidsPanel);
		acidMainPanel.add(acidControlPanel);
		
		setuplistOfAcidsPanel();
		setupupdateAcidPanel();
		setupmodifyAcidAmountPanel();
	}

	private void setuplistOfAcidsPanel() {
		listOfAcidsPanel.add(new JLabel("Acids"));
	}

	private void setupupdateAcidPanel() {
		JButton updateAcidButton = new JButton("Update");
		JPanel updateAcidPanel = new JPanel(new GridLayout(0,2));
		updateAcidPanel.add(new JLabel("Weight: "));
		JTextField weightInput = new JTextField();
		updateAcidPanel.add(weightInput);
		updateAcidPanel.add(new JLabel("Volume: "));
		JTextField volumeInput = new JTextField();
		updateAcidPanel.add(volumeInput);
		updateAcidPanel.add(updateAcidButton);
		
		updateAcidButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command stuff goes here
				 * Integer.parseInt(weightInput.getText()) -- new weight
				 * Integer.parseInt(volumeInput.getText()) -- new volume
				 */
			}
		});
		
		acidControlPanel.add(updateAcidPanel);
	}
	
	private void setupmodifyAcidAmountPanel() {
		JPanel modifyAcidAmountPanel = new JPanel(new GridLayout(0, 2));
		modifyAcidAmountPanel.setBackground(new Color(220, 200, 220));	
		modifyAcidAmountPanel.add(new JLabel("Modify Amount"));
		JComboBox acidNameInput = new JComboBox(new String[] {"Lava", "Green", "Red"});
		modifyAcidAmountPanel.add(acidNameInput);
		modifyAcidAmountPanel.add(new JLabel("New Amount"));
		JTextField newAmountInput = new JTextField();
		modifyAcidAmountPanel.add(newAmountInput);
		JButton changeAmount = new JButton("Change");
		changeAmount.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				/**
				 * Command Stuff goes here
				 * Integer.parseInt(newAmountInput.getText()) -- new amount
				 */
			}
		});
		modifyAcidAmountPanel.add(changeAmount);
		acidControlPanel.add(modifyAcidAmountPanel);
	}
}

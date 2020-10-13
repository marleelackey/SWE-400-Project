package gui;
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
public class MasterGUI implements GUIInterface {

	JFrame mainFrame = new JFrame("SWE Rocks!");
	JTabbedPane mainPane = new JTabbedPane();

	public MasterGUI() {


		mainFrame.setPreferredSize(FRAME_SIZE);
		mainFrame.pack();

		mainPane.addTab("Element", ElementGUI.getElementMainPanel());
		mainPane.addTab("Metal", MetalGUI.getmetalMainPanel());
		mainPane.addTab("Compound", CompoundGUI.getCompoundMainPanel());
		mainPane.addTab("Acid", AcidGUI.getAcidMainPanel());
		mainPane.addTab("Base", BaseGUI.getBaseMainPanel());
		mainPane.addTab("Chemical", ChemicalGUI.getChemicalMainPanel());

		mainFrame.add(mainPane);
		mainFrame.setVisible(true);
	}
}

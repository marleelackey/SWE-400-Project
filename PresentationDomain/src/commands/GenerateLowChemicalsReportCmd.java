package commands;

import java.io.File;

/**
 * Command class to generate a report of the chemicals that are running low in
 * inventory
 * 
 * @author Madeline and Adam
 *
 */
public class GenerateLowChemicalsReportCmd {

	private File outputFile;

	/**
	 * Constructor
	 * 
	 * @param f the file to write the report to
	 */
	public GenerateLowChemicalsReportCmd(File f) {
		outputFile = f;
	}

	/**
	 * Execute method to invoke the generate low chemicals report command
	 */
	public void execute() {
		// TODO
	}

	public File getOutputFile() {
		return outputFile;
	}

}
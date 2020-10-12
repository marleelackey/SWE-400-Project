package commands;

/**
 * Executer that executes a command passed to it
 * 
 * @author Madeline & co.
 *
 */
public class ExecuterForCommands {

	/**
	 * Constructor that takes in a command and executes it
	 * 
	 * @param c the command to execute
	 */
	public ExecuterForCommands(CommandInterface c) {
		c.execute();
	}

}
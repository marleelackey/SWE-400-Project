/**
 * 
 */
package commands;

import java.util.ArrayList;

import domainObjects.MetalDomainObject;
import mappers.MetalMapper;

/**
 * Command to get all the metals
 * 
 * @author Ad&Mad
 *
 */
public class GetAllMetalsCmd implements CommandInterface {

	private ArrayList<MetalDomainObject> metals;

	/**
	 * Execute the command
	 */
	@Override
	public void execute() throws Exception {
		MetalMapper mm = new MetalMapper();
		metals = mm.getAllMetals();
	}

	/**
	 * @return the metals
	 */
	public ArrayList<MetalDomainObject> getMetals() {
		return metals;
	}

}
package quantifiedElementPackage;
import domainObjects.ElementDomainObject;

/**
 * Class to hold a relationship between an element and how many atoms of it are
 * in one molecule of its containing compound
 * 
 * @author Mad, Ace, Joshua B
 *
 */
public class QuantifiedElement {

	private ElementDomainObject element;
	private int quantityInCompound;

	/**
	 * Constructor
	 * 
	 * @param e the element
	 * @param q its quantity in its compound
	 */
	public QuantifiedElement(ElementDomainObject e, int q) {
		element = e;
		setQuantityInCompound(q);
	}

	public ElementDomainObject getElement() {
		return element;
	}

	public void setElement(ElementDomainObject element) {
		this.element = element;
	}

	public int getQuantityInCompound() {
		return quantityInCompound;
	}

	public void setQuantityInCompound(int quantityInCompound) {
		this.quantityInCompound = quantityInCompound;
	}

}
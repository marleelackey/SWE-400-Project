package Tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.sql.ResultSet;
import java.sql.Statement;

import org.junit.Test;

import datasource.CompoundMadeOfElementRDG;
import datasource.CompoundRDG;
import datasource.DatabaseException;
import datasource.DatabaseManager;
import datasource.ElementRDG;
import domainObjects.CompoundDomainObject;
import domainObjects.ElementDomainObject;
import mappers.CompoundMapper;
import mappers.ElementMapper;
import quantifiedElementPackage.QuantifiedElement;

/**
 * @author Joshua, Ace
 *
 */
public class TestCompoundMapper {
	
	@Test
	public static void testFindBy() {
		CompoundMapper mapper = new CompoundMapper();
		try {
			DatabaseManager.getSingleton().setTesting();
			mapper.findByID(0);
			assertEquals(mapper.getMoles(), 28.3, 0.001);
			DatabaseManager.getSingleton().rollBack();

		} catch (Exception e) {
			e.printStackTrace();
			DatabaseException.detectError(e, "Exception in TestElementMapper.testCreateElement()");
		}
	}
	
	@Test
	public static void testPersist() {
		CompoundMapper mapper = new CompoundMapper();
		try {
			DatabaseManager.getSingleton().setTesting();
			
			CompoundDomainObject compound = mapper.findByID(0);
			assertEquals(mapper.getMoles(), 28.3, 0.001);
			
			mapper.setMoles(28.4);
			compound.persist();
			
			CompoundRDG rdg = CompoundRDG.findByIDConcrete(0);
			assertEquals(28.4, rdg.getCompoundMoles(), 0.001);
		
			assertEquals(mapper.getMyElements().get(0).getElement().getElementName(), "element1");
			
			Statement stmt = DatabaseManager.getSingleton().getConnection().createStatement();
			stmt.executeQuery("SELECT * FROM CompoundMadeOfElement");
			ResultSet rs = stmt.getResultSet();

			int size = 0;
			if (rs != null) 
			{
			  rs.last();
			  size = rs.getRow(); 
			}
			if (size <= 3) {
				fail();
			}
			
			compound.getElements().remove(0);
			compound.persist();
//			mapper.getMyElements().remove(0);
//			mapper.persist();
			
			stmt = DatabaseManager.getSingleton().getConnection().createStatement();
			stmt.executeQuery("SELECT * FROM CompoundMadeOfElement");
			ResultSet rs2 = stmt.getResultSet();
			
			size = 0;
			if (rs2 != null) 
			{
			  rs2.last();
			  size = rs2.getRow(); 
			}
			System.out.println(size);
			if (size > 3) {
				fail();
			}
			
			ElementMapper em = new ElementMapper();
			em.createElement(30, "testElement", 12, 13, 10.10);
			ElementDomainObject e = new ElementDomainObject(em);
			mapper.getMyElements().add(new QuantifiedElement(e, 2));	
			mapper.persist();
			
			stmt = DatabaseManager.getSingleton().getConnection().createStatement();
			stmt.executeQuery("SELECT * FROM CompoundMadeOfElement");
			ResultSet rs3 = stmt.getResultSet();
			
			size = 0;
			if (rs3 != null) 
			{
			  rs3.last();
			  size = rs3.getRow(); 
			}
			System.out.println(size);
			if (size <= 3) {
				fail();
			}
			
//			
//			for (QuantifiedElement q : mapper.getMyElements()) {
//				System.out.println(q.getElement().getElementName() + "___" + q.getQuantityInCompound());
//			}
//			
			
			
			DatabaseManager.getSingleton().rollBack();
			
			
			
			
			
//			mapper.createElement(40, "element", 10, 10, 4.7);
//			ElementRDG rdg = ElementRDG.findByID(40);
//			assertEquals("element", rdg.getName());
			DatabaseManager.getSingleton().rollBack();


		} catch (Exception e) {
			e.printStackTrace();
			DatabaseException.detectError(e, "Exception in TestElementMapper.testCreateElement()");
		}
	}

	public static void runAllTheTests() {
		testFindBy();
//		testPersist();
		
	}

}
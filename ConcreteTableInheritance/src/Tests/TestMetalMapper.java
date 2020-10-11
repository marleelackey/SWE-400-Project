package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import mappers.MetalMapper;
import datasource.DatabaseException;
import datasource.DatabaseManager;
import datasource.MetalRDG;

public class TestMetalMapper {
	
	@Test
	public static void testCreateMetal() {
		MetalMapper mapper = new MetalMapper(40, "element", 10, 10, 30);
		try {
			DatabaseManager.getSingleton().setTesting();
			mapper.createMetal();
			MetalRDG rdg = MetalRDG.findByID(40);
			assertEquals(30, rdg.getDissolvedBy());
			DatabaseManager.getSingleton().rollBack();


		} catch (Exception e) {
			e.printStackTrace();
			DatabaseException.detectError(e, "Exception in TestMetalMapper.testCreateMetal()");
		}
	}

	public static void runAllTheTests() {
		testCreateMetal();
		
	}

}
package Tests;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import Classes.BaseDTO;

public class TestBaseDTO {
	
	@Test
	public void testBaseDTO() {
		BaseDTO dto = new BaseDTO(1, 2);
		assertEquals(1, dto.getID());
		assertEquals(2, dto.getSolute());

	}
	

}

package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.AcidDTO;

public class TestAcidDTO {
	
	@Test
	public void test() {
		AcidDTO dto = new AcidDTO(0, "Hydrochloric Acid");
		assertEquals(0, dto.getSolute());
		assertEquals("Hydrochloric Acid", dto.getName());
	}

}
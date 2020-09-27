package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import Classes.BaseDTO;



public class TestBaseDTO {

	@Test
	public void test() {
		BaseDTO dot = new BaseDTO(23, "Sodium Hydroxide" , 83);
		assertEquals(23, dot.getID());
		assertEquals("Sodium Hydroxide", dot.getName());
		assertEquals(83, dot.getSolute());
	}

}

package test.normalisation;

import static org.junit.Assert.*;

import org.junit.Test;

import normalisation.*;

public class NormalVilleTest {
	
	@Test
	public void TestNormalVilleMaj() {

		assertEquals("Marange", NormalisationVille.NormalVille("marange"));
		assertEquals("Marange", NormalisationVille.NormalVille("Marange"));

	}
	
	@Test
	public void TestNormalVillePrepo() {
		
		assertEquals("Montigny-lès-metz", NormalisationVille.NormalVille("Montigny lès metz"));

	}
	
	@Test
	public void TestNormalVilleSaint() {
		
		assertEquals("Saint-marie aux Chênes", NormalisationVille.NormalVille("ste marie aux chênes"));


	}

}

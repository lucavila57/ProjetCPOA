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
		
		assertEquals("Montigny-lès-Metz", NormalisationVille.NormalVille("Montigny lès Metz"));
		assertEquals("Marie-aux-Chênes", NormalisationVille.NormalVille("Marie aux Chênes"));

	}
	
	@Test
	public void TestNormalVilleSaint() {
		
		assertEquals("Saint-Marie-aux-Chênes", NormalisationVille.NormalVille("Ste Marie aux Chênes"));
		assertEquals("Saint-Julien-lès-Metz", NormalisationVille.NormalVille("St Julien lès Metz"));


	}

}

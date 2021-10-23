package test.normalisation;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import normalisation.NormalisationVille;

public class NormalVilleTestPrepoLes {

	@Test
	public void TestNormalVillePrepoMin() {

		assertEquals("Marange-l�s-grand-l�s-haut", NormalisationVille.NormalVilleles("Marange l�s grand l�s haut"));
		

	}
	
	@Test
	public void TestNormalVillePrepoMaj() {

		assertEquals("Marange-l�s-grand-l�s-haut", NormalisationVille.NormalVilleles("Marange L�s grand L�s haut"));
		

	}

}

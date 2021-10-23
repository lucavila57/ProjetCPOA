package test.normalisation;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import normalisation.NormalisationVille;

public class NormalVilleTestPrepoLes {

	@Test
	public void TestNormalVillePrepoMin() {

		assertEquals("Marange-lès-grand-lès-haut", NormalisationVille.NormalVilleles("Marange lès grand lès haut"));
		

	}
	
	@Test
	public void TestNormalVillePrepoMaj() {

		assertEquals("Marange-lès-grand-lès-haut", NormalisationVille.NormalVilleles("Marange Lès grand Lès haut"));
		

	}

}

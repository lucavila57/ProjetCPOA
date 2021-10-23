package test.normalisation;

import static org.junit.Assert.assertEquals;


import org.junit.Test;

import normalisation.NormalisationVille;

public class NormalVilleTestPrepoAux {

	@Test
	public void TestNormalVillePrepoMin() {

		assertEquals("Marange-aux-grand-aux-haut", NormalisationVille.NormalVilleaux("Marange aux grand aux haut"));
		

	}
	
	@Test
	public void TestNormalVillePrepoMaj() {

		assertEquals("Marange-aux-grand-aux-haut", NormalisationVille.NormalVilleaux("Marange Aux grand Aux haut"));
		

	}

}

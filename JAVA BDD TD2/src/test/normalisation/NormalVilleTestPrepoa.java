package test.normalisation;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import normalisation.NormalisationVille;

public class NormalVilleTestPrepoa {

	@Test
	public void TestNormalVillePrepoMin() {

		assertEquals("Marange-à-grand-à-haut", NormalisationVille.NormalVillea("Marange à grand à haut"));
		

	}
	
	@Test
	public void TestNormalVillePrepoMaj() {

		assertEquals("Marange-à-grand-à-haut", NormalisationVille.NormalVillea("Marange A grand A haut"));
		

	}

}

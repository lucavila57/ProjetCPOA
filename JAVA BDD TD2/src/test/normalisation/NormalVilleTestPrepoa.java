package test.normalisation;

import static org.junit.Assert.assertEquals;



import org.junit.Test;

import normalisation.NormalisationVille;

public class NormalVilleTestPrepoa {

	@Test
	public void TestNormalVillePrepoMin() {

		assertEquals("Marange-�-grand-�-haut", NormalisationVille.NormalVillea("Marange � grand � haut"));
		

	}
	
	@Test
	public void TestNormalVillePrepoMaj() {

		assertEquals("Marange-�-grand-�-haut", NormalisationVille.NormalVillea("Marange A grand A haut"));
		

	}

}

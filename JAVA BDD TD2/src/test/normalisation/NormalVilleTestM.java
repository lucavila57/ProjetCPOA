package test.normalisation;



import static org.junit.Assert.*;

import org.junit.Test;

import normalisation.NormalisationVille;

public class NormalVilleTestM {
	
	@Test
	public void TestNormalVilleDebMaj() {

		assertEquals("Marange", NormalisationVille.NormalVille("marange"));
		assertEquals("Marange", NormalisationVille.NormalVille("Marange"));

	}


}
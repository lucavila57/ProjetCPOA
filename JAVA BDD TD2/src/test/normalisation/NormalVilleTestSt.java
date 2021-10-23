package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestSt {
	@Test
	public void TestNormalVillePrepoSt() 
	{
		
		assertEquals("Marange-Saint-grand-Saint-haut",NormalisationVille.NormalVilleSt("Marange St grand St haut"));
	}

}

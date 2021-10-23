package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestSur {
	
	@Test
	public void TestNoramlVillePrepoSurMin() 
	{
		
		assertEquals("Marange-sur-grand-sur-haut",NormalisationVille.NormalVillesur("Marange sur grand sur haut"));
	}

	@Test
	public void TestNormalVillePrepoSurMaj() 
	{
	
		assertEquals("Marange-sur-grand-sur-haut",NormalisationVille.NormalVillesur("Marange Sur grand Sur haut"));
	}

}

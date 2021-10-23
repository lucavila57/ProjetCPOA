package test.normalisation;

import org.junit.Test;


import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestSurDeb {
	
	@Test
	public void TestNoramlVillePrepoSurDeb() 
	{
		
		assertEquals("Sur-Marange",NormalisationVille.NormalVilleSurdeb("Sur Marange"));
	}

	

}
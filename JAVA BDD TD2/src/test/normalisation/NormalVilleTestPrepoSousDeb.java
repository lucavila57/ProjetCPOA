package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoSousDeb {
	@Test
	public void TestNormalVillePrepoSousDeb() 
	{
		
		assertEquals("Sous-Marange",NormalisationVille.NormalVilleSousdeb("Sous Marange"));
	}

}

package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLeDeb {
	@Test
	public void TestNormalVillePrepoLeDeb() 
	{
		
		assertEquals("Le-Marange",NormalisationVille.NormalVilleLedeb("Le Marange"));
	}

}

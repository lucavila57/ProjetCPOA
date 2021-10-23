package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestStDeb {
	@Test
	public void TestNormalVillePrepoStDeb() 
	{
		
		assertEquals("Saint-Marange",NormalisationVille.NormalVilleStdeb("St Marange"));
	}

}


package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestSteDeb {
	@Test
	public void TestNormalVillePrepoSteDeb() 
	{
		
		assertEquals("Sainte-Marange",NormalisationVille.NormalVilleStedeb("Ste Marange"));
	}

}
 
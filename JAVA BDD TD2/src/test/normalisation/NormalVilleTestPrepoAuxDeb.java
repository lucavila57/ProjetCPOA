package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoAuxDeb {
	@Test
	public void TestNormalVillePrepoAuxDeb() 
	{
		
		assertEquals("Aux-Marange",NormalisationVille.NormalVilleauxdeb("Aux Marange"));
	}

}


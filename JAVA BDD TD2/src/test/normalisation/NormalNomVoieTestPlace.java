package test.normalisation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import normalisation.NormalisationNomVoie;

public class NormalNomVoieTestPlace {
	
@Test
	
	public void TestNormalVoiePlaceDeb()
	{
		
		assertEquals("place de la libération",NormalisationNomVoie.NormalVoiePlace("pl. de la libération"));
	}

	@Test

	public void TestNormalVoiePlace()
	{
		
		assertEquals("la place de la libération",NormalisationNomVoie.NormalVoiePlace("la pl. de la libération"));
	}

}

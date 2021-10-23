package test.normalisation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import normalisation.NormalisationNomVoie;

public class NormalNomVoieTestPlace {
	
@Test
	
	public void TestNormalVoiePlaceDeb()
	{
		
		assertEquals("place de la lib�ration",NormalisationNomVoie.NormalVoiePlace("pl. de la lib�ration"));
	}

	@Test

	public void TestNormalVoiePlace()
	{
		
		assertEquals("la place de la lib�ration",NormalisationNomVoie.NormalVoiePlace("la pl. de la lib�ration"));
	}

}

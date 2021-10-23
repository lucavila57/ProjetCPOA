package test.normalisation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import normalisation.NormalisationNomVoie;

public class NormalNomVoieTestAvenue {
	
	
    @Test    
	public void TestNormalVoieAvenueDeb()
	{
		
		assertEquals("avenue de la lib�ration",NormalisationNomVoie.NormalVoieAvenue("av. de la lib�ration"));
	}

	@Test
	public void TestNormalVoieAvenue()
	{
		assertEquals("l'avenue de la lib�ration",NormalisationNomVoie.NormalVoieAvenue("l'av. de la lib�ration"));
	
	}

}

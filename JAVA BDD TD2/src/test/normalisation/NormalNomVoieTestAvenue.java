package test.normalisation;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

import normalisation.NormalisationNomVoie;

public class NormalNomVoieTestAvenue {
	
	
    @Test    
	public void TestNormalVoieAvenueDeb()
	{
		
		assertEquals("avenue de la libération",NormalisationNomVoie.NormalVoieAvenue("av. de la libération"));
	}

	@Test
	public void TestNormalVoieAvenue()
	{
		assertEquals("l'avenue de la libération",NormalisationNomVoie.NormalVoieAvenue("l'av. de la libération"));
	
	}

}

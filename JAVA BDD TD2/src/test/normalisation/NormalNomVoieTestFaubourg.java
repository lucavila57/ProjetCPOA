package test.normalisation;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import normalisation.NormalisationNomVoie;


public class NormalNomVoieTestFaubourg {
	
@Test
	
	public void TestNormalVoieFaubourgDeb()
	{
		
		assertEquals("faubourg de la libéartion",NormalisationNomVoie.NormalVoieFaubourg("faub. de la libéartion"));
	}

	@Test

	public void TestNormalVoieFaubourg()
	{
		
		assertEquals("le faubourg de la libéartion",NormalisationNomVoie.NormalVoieFaubourg("le faub. de la libéartion"));
	}
	
@Test
	
	public void TestNormalVoieFaubourg2Deb()
	{
		
		assertEquals("faubourg de la libération",NormalisationNomVoie.NormalVoieFaubourg("fg de la libération"));
	}

	@Test

	public void TestNormalVoieFaubourg2()
	{
	
		assertEquals("le faubourg de la libération",NormalisationNomVoie.NormalVoieFaubourg("le fg de la libération"));
	}
}



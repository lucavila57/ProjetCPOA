package test.normalisation;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import normalisation.NormalisationNomVoie;


public class NormalNomVoieTestBoulevard {
	
	
    @Test
	public void TestNormalVoieBoulevardDeb()
	{
		
		assertEquals("boulevard de la libération",NormalisationNomVoie.NormalVoieboulevard("bd de la libération"));
	}
	@Test
	public void TestNormalVoieBoulevard()
	{
		
		assertEquals("le boulevard de la libération",NormalisationNomVoie.NormalVoieboulevard("le bd de la libération"));
	}
	@Test
	public void TestNormalVoieBoulevard2Deb()
	
	{
		
		assertEquals("boulevard de la libéartion",NormalisationNomVoie.NormalVoieboulevard("boul de la libéartion"));
	}
	
	@Test
	public void TestNormalVoieBoulevard2()
	{
		
		assertEquals("le boulevard de la libération",NormalisationNomVoie.NormalVoieboulevard("le boul de la libération"));
	}
	
	@Test
	
	public void TestNormalVoieBoulevard3Deb()
	{
		
		assertEquals("boulevard de la libéartion",NormalisationNomVoie.NormalVoieboulevard("boul. de la libéartion"));
	}
	@Test
	public void TestNormalVoieBoulevard3()
	{
		
		assertEquals("le boulevard de la libération",NormalisationNomVoie.NormalVoieboulevard("le boul. de la libération"));
	}
}

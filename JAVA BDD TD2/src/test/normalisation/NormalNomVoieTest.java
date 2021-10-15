package test.normalisation;

import static org.junit.Assert.*;

import org.junit.Test;

import normalisation.NormalisationNomVoie;


public class NormalNomVoieTest {

	@Test
	public void TestNormalNomVoieBoulevard() {

		assertEquals("boul Marange", NormalisationNomVoie.VoieNormaliseboulevard("boulevard Marange"));



	
}

	public void TestNormalNomVoieAvenue() {

		assertEquals("av Marange", NormalisationNomVoie.VoieNormaliseavenue("avenue Marange"));

	
}
	
	public void TestNormalNomVoieFaubourg() {

		assertEquals("fg. Marange", NormalisationNomVoie.VoieNormalisefaubourg("faubourg Marange"));

	
}
	
	public void TestNormalNomVoiePlace() {

		assertEquals("pl. Marange", NormalisationNomVoie.VoieNormaliseplace("place Marange"));

	
}
	
	
	

	}

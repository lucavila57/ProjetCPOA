package test.normalisation;

import static org.junit.Assert.*;

import org.junit.Test;

import normalisation.NormalisationNomVoie;


public class NormalNomVoieTest {

	@Test
	public void TestNormalNomVoieBoulevard() {

		assertEquals("boul Marange", NormalisationNomVoie.NormalNomVoie("boulevard Marange"));



	
}

	public void TestNormalNomVoieAvenue() {

		assertEquals("av Marange", NormalisationNomVoie.NormalNomVoie("avenue Marange"));

	
}
	
	public void TestNormalNomVoieFaubourg() {

		assertEquals("fg. Marange", NormalisationNomVoie.NormalNomVoie("faubourg Marange"));

	
}
	
	public void TestNormalNomVoiePlace() {

		assertEquals("pl. Marange", NormalisationNomVoie.NormalNomVoie("place Marange"));

	
}
	
	public void TestNormalNomVoieOk() {

		assertEquals("boulevard Marange", NormalisationNomVoie.NormalNomVoie("boulevard Marange"));

	
}
	}

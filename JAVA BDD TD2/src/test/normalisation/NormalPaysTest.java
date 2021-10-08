package test.normalisation;

import static org.junit.Assert.*;

import org.junit.Test;

import normalisation.*;

public class NormalPaysTest {

	@Test
	public void TestNormalPaysLuxembourg() {

		assertEquals("Luxembourg", NormalisationPays.NormalPays("letzebuerg"));
		assertEquals("Luxembourg", NormalisationPays.NormalPays("Letzebuerg"));

	}
	@Test
	public void TestNormalPaysBelgique() {

		assertEquals("Belgique", NormalisationPays.NormalPays("belgium"));
		assertEquals("Belgique", NormalisationPays.NormalPays("Belgium"));

	}
	@Test
	public void TestNormalPaysSuisse() {

		assertEquals("Suisse", NormalisationPays.NormalPays("switzerland"));
		assertEquals("Suisse", NormalisationPays.NormalPays("Switzerland"));

	}
	@Test
	public void TestNormalPaysSuisse2() {

		assertEquals("Suisse", NormalisationPays.NormalPays("schweiz"));
		assertEquals("Suisse", NormalisationPays.NormalPays("Schweiz"));

	}
	@Test
	public void TestNormalPaysOK() {
		
		assertEquals("Bonjour", NormalisationPays.NormalPays("Bonjour"));
	}

}

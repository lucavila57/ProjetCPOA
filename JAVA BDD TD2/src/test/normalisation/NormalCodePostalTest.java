package test.normalisation;

import static org.junit.Assert.*;


import org.junit.Test;

import normalisation.*;

public class NormalCodePostalTest {

	@Test
	public void TestNormalCodePostal0()
	{
		assertEquals("06000", NormalisationCodePostal.NormalCodePostal0("6000"));
	}
	
	@Test
	public void TestNormalCodePostalIndiqPays()
	{
		assertEquals("6000",NormalisationCodePostal.NormalCodePostalIndiqPays("L-6000"));
	}
}

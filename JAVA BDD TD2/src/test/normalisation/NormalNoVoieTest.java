package test.normalisation;

import static org.junit.Assert.*;


import org.junit.Test;

import normalisation.*;

public class NormalNoVoieTest {
	
		@Test
		public void TestNormalNoVoieVirgule() {

			assertEquals("3, rue des alouettes", NormalisationNoVoie.NormalNum("3 rue des alouettes"));

		
	}
		@Test
		public void TestNormalNoVoieOk() {
			
			assertEquals("3, rue des alouettes", NormalisationNoVoie.NormalNum("3, rue des alouettes"));

			
		}

}

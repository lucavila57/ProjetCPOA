package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLesDeb {
	@Test
	public void TestNormalVillePrepoLesDeb() 
	{
		
		assertEquals("L�s-Marange",NormalisationVille.NormalVilleLesdeb("L�s Marange"));
	}

}


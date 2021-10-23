package test.normalisation;

import org.junit.Test;

import normalisation.NormalisationVille;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLesDeb {
	@Test
	public void TestNormalVillePrepoLesDeb() 
	{
		
		assertEquals("Lès-Marange",NormalisationVille.NormalVilleLesdeb("Lès Marange"));
	}

}


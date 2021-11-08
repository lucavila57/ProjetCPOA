package testNorm.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLesDeb {
    @Test
    public void TestNormalVillePrepoLesDeb() {

        assertEquals("L�s-Marange", NormalisationVille.NormalVilleLesdeb("L�s Marange"));
    }

}


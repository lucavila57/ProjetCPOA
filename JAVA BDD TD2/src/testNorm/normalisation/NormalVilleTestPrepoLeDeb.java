package testNorm.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLeDeb {
    @Test
    public void TestNormalVillePrepoLeDeb() {

        assertEquals("Le-Marange", NormalisationVille.NormalVilleLedeb("Le Marange"));
    }

}

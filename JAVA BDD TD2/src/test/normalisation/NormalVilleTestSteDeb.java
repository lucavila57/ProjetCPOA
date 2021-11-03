package test.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestSteDeb {
    @Test
    public void TestNormalVillePrepoSteDeb() {

        assertEquals("Sainte-Marange", NormalisationVille.NormalVilleStedeb("Ste Marange"));
    }

}
 
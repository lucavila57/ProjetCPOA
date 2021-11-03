package test.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestSt {
    @Test
    public void TestNormalVillePrepoSt() {

        assertEquals("Marange-Saint-grand-Saint-haut", NormalisationVille.NormalVilleSt("Marange St grand St haut"));
    }

}

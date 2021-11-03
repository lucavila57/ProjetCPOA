package test.normalisation;


import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestSte {
    @Test
    public void TestNormalVillePrepoSte() {

        assertEquals("Marange-Sainte-grand-Sainte-haut", NormalisationVille.NormalVilleSte("Marange Ste grand Ste haut"));
    }

}


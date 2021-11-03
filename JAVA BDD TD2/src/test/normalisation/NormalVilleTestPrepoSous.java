package test.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestPrepoSous {
    @Test
    public void TestNormalVillePrepoSousMin() {

        assertEquals("Marange-sous-grand-sous-haut", NormalisationVille.NormalVillesous("Marange sous grand sous haut"));
    }

    @Test
    public void TestNormalVillePrepoSousMaj() {

        assertEquals("Marange-sous-grand-sous-haut", NormalisationVille.NormalVillesous("Marange Sous grand Sous haut"));
    }

}

package testNorm.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLes {

    @Test
    public void TestNormalVillePrepoMin() {

        assertEquals("Marange-l�s-grand-l�s-haut", NormalisationVille.NormalVilleles("Marange l�s grand l�s haut"));


    }

    @Test
    public void TestNormalVillePrepoMaj() {

        assertEquals("Marange-l�s-grand-l�s-haut", NormalisationVille.NormalVilleles("Marange L�s grand L�s haut"));


    }

}

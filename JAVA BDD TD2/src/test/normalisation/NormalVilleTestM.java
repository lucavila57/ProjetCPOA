package test.normalisation;


import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestM {

    @Test
    public void TestNormalVilleDebMaj() {

        assertEquals("Marange", NormalisationVille.NormalVille("marange"));
        assertEquals("Marange", NormalisationVille.NormalVille("Marange"));

    }


}
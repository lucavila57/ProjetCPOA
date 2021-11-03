package test.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalVilleTestStDeb {
    @Test
    public void TestNormalVillePrepoStDeb() {

        assertEquals("Saint-Marange", NormalisationVille.NormalVilleStdeb("St Marange"));
    }

}


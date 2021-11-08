package testNorm.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoAuxDeb {
    @Test
    public void TestNormalVillePrepoAuxDeb() {

        assertEquals("Aux-Marange", NormalisationVille.NormalVilleauxdeb("Aux Marange"));
    }

}


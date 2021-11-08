package testNorm.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoSousDeb {
    @Test
    public void TestNormalVillePrepoSousDeb() {

        assertEquals("Sous-Marange", NormalisationVille.NormalVilleSousdeb("Sous Marange"));
    }

}

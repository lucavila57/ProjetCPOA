package testNorm.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoadeb {
    @Test
    public void TestNormalVillePrepoadeb() {
        assertEquals("�-Marange", NormalisationVille.NormalVilledeba("A Marange"));
    }

}
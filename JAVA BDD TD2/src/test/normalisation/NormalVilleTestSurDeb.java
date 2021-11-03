package test.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestSurDeb {

    @Test
    public void TestNoramlVillePrepoSurDeb() {

        assertEquals("Sur-Marange", NormalisationVille.NormalVilleSurdeb("Sur Marange"));
    }


}
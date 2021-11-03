package test.normalisation;

import normalisation.NormalisationVille;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalVilleTestPrepoLe {

    @Test
    public void TestNormalVillePrepoMin() {

        assertEquals("Marange-le-grand-le-haut", NormalisationVille.NormalVilleLe("Marange le grand le haut"));


    }

    @Test
    public void TestNormalVillePrepoMaj() {

        assertEquals("Marange-le-grand-le-haut", NormalisationVille.NormalVilleLe("Marange Le grand Le haut"));


    }

}

package testNorm.normalisation;

import normalisation.NormalisationNomVoie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalNomVoieTestAvenue {


    @Test
    public void TestNormalVoieAvenueDeb() {

        assertEquals("avenue de la lib�ration", NormalisationNomVoie.NormalVoieAvenue("av. de la lib�ration"));
    }

    @Test
    public void TestNormalVoieAvenue() {
        assertEquals("l'avenue de la lib�ration", NormalisationNomVoie.NormalVoieAvenue("l'av. de la lib�ration"));

    }

}

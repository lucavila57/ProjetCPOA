package test.normalisation;

import normalisation.NormalisationNomVoie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalNomVoieTestPlace {

    @Test

    public void TestNormalVoiePlaceDeb() {

        assertEquals("place de la lib�ration", NormalisationNomVoie.NormalVoiePlace("pl. de la lib�ration"));
    }

    @Test

    public void TestNormalVoiePlace() {

        assertEquals("la place de la lib�ration", NormalisationNomVoie.NormalVoiePlace("la pl. de la lib�ration"));
    }

}

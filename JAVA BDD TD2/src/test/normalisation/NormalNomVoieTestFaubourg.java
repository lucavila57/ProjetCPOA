package test.normalisation;

import normalisation.NormalisationNomVoie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalNomVoieTestFaubourg {

    @Test

    public void TestNormalVoieFaubourgDeb() {

        assertEquals("faubourg de la lib�artion", NormalisationNomVoie.NormalVoieFaubourg("faub. de la lib�artion"));
    }

    @Test

    public void TestNormalVoieFaubourg() {

        assertEquals("le faubourg de la lib�artion", NormalisationNomVoie.NormalVoieFaubourg("le faub. de la lib�artion"));
    }

    @Test

    public void TestNormalVoieFaubourg2Deb() {

        assertEquals("faubourg de la lib�ration", NormalisationNomVoie.NormalVoieFaubourg("fg de la lib�ration"));
    }

    @Test

    public void TestNormalVoieFaubourg2() {

        assertEquals("le faubourg de la lib�ration", NormalisationNomVoie.NormalVoieFaubourg("le fg de la lib�ration"));
    }
}



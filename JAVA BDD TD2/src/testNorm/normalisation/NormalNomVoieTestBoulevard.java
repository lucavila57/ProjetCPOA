package testNorm.normalisation;

import normalisation.NormalisationNomVoie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class NormalNomVoieTestBoulevard {


    @Test
    public void TestNormalVoieBoulevardDeb() {

        assertEquals("boulevard de la lib�ration", NormalisationNomVoie.NormalVoieboulevard("bd de la lib�ration"));
    }

    @Test
    public void TestNormalVoieBoulevard() {

        assertEquals("le boulevard de la lib�ration", NormalisationNomVoie.NormalVoieboulevard("le bd de la lib�ration"));
    }

    @Test
    public void TestNormalVoieBoulevard2Deb() {

        assertEquals("boulevard de la lib�artion", NormalisationNomVoie.NormalVoieboulevard("boul de la lib�artion"));
    }

    @Test
    public void TestNormalVoieBoulevard2() {

        assertEquals("le boulevard de la lib�ration", NormalisationNomVoie.NormalVoieboulevard("le boul de la lib�ration"));
    }

    @Test

    public void TestNormalVoieBoulevard3Deb() {

        assertEquals("boulevard de la lib�artion", NormalisationNomVoie.NormalVoieboulevard("boul. de la lib�artion"));
    }

    @Test
    public void TestNormalVoieBoulevard3() {

        assertEquals("le boulevard de la lib�ration", NormalisationNomVoie.NormalVoieboulevard("le boul. de la lib�ration"));
    }
}

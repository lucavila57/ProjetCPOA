package test.normalisation;

import normalisation.NormalisationNoVoie;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NormalNoVoieTest {

    @Test
    public void TestNormalNoVoieVirgule() {

        assertEquals("3, rue des alouettes", NormalisationNoVoie.NormalNum("3 rue des alouettes"));


    }

    @Test
    public void TestNormalNoVoieOk() {

        assertEquals("3, rue des alouettes", NormalisationNoVoie.NormalNum("3, rue des alouettes"));


    }

}

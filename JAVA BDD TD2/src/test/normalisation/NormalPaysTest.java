package test.normalisation;
import static org.junit.jupiter.api.Assertions.*; 
import junit.framework.*;
import normalisation.*;


public class NormalPaysTest{
	
	public void TestNormalPaysOK() {
		
		assertEquals("Luxembourg", NormalisationPays.NormalPays("letzebuerg"));
	}
	
}
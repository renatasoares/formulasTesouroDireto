import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testNTNA3 {

	NTNA3 ntnA3;
	Precision precision;
	
	@Before
	public void setUp() throws Exception {
		ntnA3 = new NTNA3();
		precision = new Precision();
	}

	@Test
	public void testNominalValue() {
		double nominalValue = (3.23/2.99) * 1000;
		double nominalValueExpected = precision.formactNumber(nominalValue, 6, false, false);
		ntnA3.calculateNominalValue(3.23, 2.99);
		
		Assert.assertEquals(ntnA3.getNominalValue(), nominalValueExpected, 0);
	}
	
	@Test
	public void testPrecisionOfNominalValue() {
		double nominalValue = (3.23/2.99) * 1000;
		double nominalValueNotExpected = precision.formactNumber(nominalValue, 4, false, false);
		ntnA3.calculateNominalValue(3.23, 2.99);
		
		Assert.assertNotSame(ntnA3.getNominalValue(), nominalValueNotExpected);
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (15/100.0) * 3/12;
		double interestFactorExpected = precision.formactNumber(interestFactor, 8, true, false);

		Assert.assertEquals(ntnA3.calculateInterestFactor(15, 3), interestFactorExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculateInterestFactor() {
		double interestFactor = (15/100.0) * 3/12;
		double interestFactorNotExpected = precision.formactNumber(interestFactor, 4, true, false);

		Assert.assertNotSame(ntnA3.calculateInterestFactor(15, 3), interestFactorNotExpected);
	}
	
	@Test
	public void testCalculateInterest() {
		ntnA3.calculateNominalValue(3.23, 2.99);
		double interest = ntnA3.getNominalValue() * ntnA3.calculateInterestFactor(15, 3);
		double interestExpected = precision.formactNumber(interest, 6, false, false);
	
		Assert.assertEquals(ntnA3.calculateInterest(15, 3), interestExpected, 0);		
	}
	
	@Test
	public void testPreicisonOfCalculateInterest() {
		ntnA3.calculateNominalValue(3.23, 2.99);
		double interest = ntnA3.getNominalValue() * ntnA3.calculateInterestFactor(15, 3);
		double interestNotExpected = precision.formactNumber(interest, 3, false, false);

		Assert.assertNotSame(ntnA3.calculateInterest(15, 3), interestNotExpected);		
	}
}

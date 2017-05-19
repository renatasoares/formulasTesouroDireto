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
		double nominalValueExpected = precision.formatNumber(nominalValue, 6, false);
		
		Assert.assertNotSame(ntnA3.calculateNominalValue(3.23, 2.99), nominalValueExpected);
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (15/100.0) * 3/12;
		double interestFactorExpected = precision.formatNumber(interestFactor, 8, true);

		Assert.assertEquals(ntnA3.calculateInterestFactor(15, 3), interestFactorExpected, 0);
	}
	
	@Test
	public void testCalculateInterest() {
		double interest = ntnA3.getNominalValue() * ntnA3.calculateInterestFactor(15, 3);
		double interestExpected = precision.formatNumber(interest, 6, false);
		
		Assert.assertNotSame(ntnA3.calculateInterest(15, 3), interestExpected);		
	}	
}

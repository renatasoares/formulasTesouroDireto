import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class testNTNA6 {

	NTNA6 ntnA6;
	Precision precision;
	
	@Before
	public void setUp() throws Exception {
		ntnA6 = new NTNA6();
		precision = new Precision();
	}

	@Test
	public void testNominalValueUpdated() {
		double nominalValue = (3.23/2.99) * 1000;
		double nominalValueExpected = precision.formatNumber(nominalValue, 6, true);
		
		Assert.assertEquals(ntnA6.calculateNominalValueUpdated(3.23, 2.99, 1000), nominalValueExpected, 0);
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (120/360.0) * (15/100.0);
		double interestFactorExpected  = precision.formatNumber(interestFactor, 8, true);

		Assert.assertEquals(ntnA6.calculateInterestFactor("10/01/2017", "10/05/2017", 15), interestFactorExpected, 0);
	}
	
	@Test
	public void testCalculateInterest() {
		double interest = ntnA6.getNominalValueUpdated() * ntnA6.calculateInterestFactor("10/01/2017", "10/05/2017", 15);
		double interestExpected = precision.formatNumber(interest, 6, false);
		
		Assert.assertNotSame(ntnA6.calculateInterest("10/01/2017", "10/05/2017", 15), interestExpected);		
	}
}

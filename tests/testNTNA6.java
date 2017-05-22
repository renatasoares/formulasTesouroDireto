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
		double nominalValueExpected = precision.formactNumber(nominalValue, 6, true, true);
		ntnA6.calculateNominalValueUpdated(3.23, 2.99, 1000);
		
		Assert.assertEquals(ntnA6.getNominalValueUpdated(), nominalValueExpected, 0);
	}
	
	@Test
	public void testPrecisionOfNominalValueUpdated() {
		double nominalValue = (3.23/2.99) * 1000;
		double nominalValueNotExpected = precision.formactNumber(nominalValue, 6, true, false);
		ntnA6.calculateNominalValueUpdated(3.23, 2.99, 1000);
		
		Assert.assertNotSame(ntnA6.getNominalValueUpdated(), nominalValueNotExpected);
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (120/360.0) * (15/100.0);
		double interestFactorExpected  = precision.formactNumber(interestFactor, 8, true, false);

		Assert.assertEquals(ntnA6.calculateInterestFactor("10/01/2017", "10/05/2017", 15), interestFactorExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculateInterestFactor() {
		double interestFactor = (120/360.0) * (15/100.0);
		double interestFactorNotExpected  = precision.formactNumber(interestFactor, 2, true, false);

		Assert.assertNotSame(ntnA6.calculateInterestFactor("10/01/2017", "10/05/2017", 15), interestFactorNotExpected);
	}
	
	@Test
	public void testCalculateInterest() {
		ntnA6.calculateNominalValueUpdated(3.23, 2.99, 1000);
		double interest = ntnA6.getNominalValueUpdated() * ntnA6.calculateInterestFactor("10/01/2017", "10/05/2017", 15);
		double interestExpected = precision.formactNumber(interest, 6, false, false);

		Assert.assertEquals(ntnA6.calculateInterest("10/01/2017", "10/05/2017", 15), interestExpected, 0);		
	}
	
	@Test
	public void testPrecisionOfCalculateInterest() {
		ntnA6.calculateNominalValueUpdated(3.23, 2.99, 1000);
		double interest = ntnA6.getNominalValueUpdated() * ntnA6.calculateInterestFactor("10/01/2017", "10/05/2017", 15);
		double interestNotExpected = precision.formactNumber(interest, 3, false, false);

		Assert.assertNotSame(ntnA6.calculateInterest("10/01/2017", "10/05/2017", 15), interestNotExpected);		
	}
}

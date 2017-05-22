import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class testNTNA1 {

	NTNA1 ntnA1;
	Precision precision;
	
	@Before
	public void setUp() throws Exception {
		ntnA1 = new NTNA1();
		precision = new Precision();
	}

	@Test
	public void testCalculatePU() {
		double pu = (3.23/2.99)*(1000 * 0.8);
		double puExpected = precision.formactNumber(pu, 6, false, false);
		ntnA1.calculatePU(3.23, 2.99, 1000, 80);

		Assert.assertEquals(ntnA1.getPUAmortization(), puExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculatePU() {
		double pu = (3.23/2.99)*(1000 * 0.8);
		double puNotExpected = precision.formactNumber(pu, 3, false, false);
		ntnA1.calculatePU(3.23, 2.99, 1000, 80);

		Assert.assertNotSame(ntnA1.getPUAmortization(), puNotExpected);
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (120/360.0) * (15/100.0);
		double interestFactorExpected = precision.formactNumber(interestFactor, 8, true, false);

		Assert.assertEquals(ntnA1.calculateInterestFactor("10/01/2017", "10/05/2017", 15), interestFactorExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculateInterestFactor() {
		double interestFactor = (120/360.0) * (15/100.0);
		double interestFactorNotExpected = precision.formactNumber(interestFactor, 4, true, false);

		Assert.assertNotSame(ntnA1.calculateInterestFactor("10/01/2017", "10/05/2017", 15), interestFactorNotExpected);
	}
	
	@Test
	public void testCalculateInterest() {
		ntnA1.calculatePU(3.23, 2.99, 1000, 80);
		double interest = ntnA1.calculateInterestFactor("10/01/2017", "10/05/2017", 15) * ntnA1.getPUAmortization();
		double interestExpected = precision.formactNumber(interest, 6, false, false); 
		
		Assert.assertEquals(ntnA1.calculateInterest("10/01/2017", "10/05/2017", 15), interestExpected, 0);		
	}
	
	@Test
	public void testPrecisionOfCalculateInterest() {
		ntnA1.calculatePU(3.23, 2.99, 1000, 80);
		double interest = ntnA1.calculateInterestFactor("10/01/2017", "10/05/2017", 15) * ntnA1.getPUAmortization();
		double interestExpected = precision.formactNumber(interest, 3, false, false); 
		
		Assert.assertNotSame(ntnA1.calculateInterest("10/01/2017", "10/05/2017", 15), interestExpected);		
	}
}

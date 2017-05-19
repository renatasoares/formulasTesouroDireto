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
		double puExpected = precision.formatNumber(pu, 6, false);
		
		Assert.assertNotSame(ntnA1.calculatePU(3.23, 2.99, 1000, 80), puExpected );
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (120/360.0) * (15/100.0);
		double interestFactorExpected = precision.formatNumber(interestFactor, 8, true);

		Assert.assertEquals(ntnA1.calculateInterestFactor("10/01/2017", "10/05/2017", 15), interestFactorExpected, 0);
	}
	
	@Test
	public void testCalculateInterest() {
		double interestExpected = ntnA1.getPUAmortization() * (15/100.0) ;
		
		Assert.assertEquals(ntnA1.calculateInterest("10/01/2017", "10/05/2017", 15), interestExpected, 0);		
	}	

}

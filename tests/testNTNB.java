import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testNTNB {
	
	NTNB ntnB;
	Precision precision;
	
	@Before
	public void setUp() throws Exception {
		ntnB = new NTNB();
		precision = new Precision();
	}

	@Test
	public void calculateIncomeFactor() {
		double incomeFactor = Math.pow((0.30/0.18), (10/20));
		double incomeFactorExpected = precision.formatNumber(incomeFactor, 6, false);
	
		Assert.assertNotSame(ntnB.calculateIncomeFactor(0.30, 0.18, "25/01/2017", "05/02/2017"), incomeFactorExpected);
	}
	
	@Test
	public void testNominalValueUpdated() {
		double nominalValue =  Math.pow((0.30/0.18), (10/20)) * (0.39/0.17) * 1000;
		double nominalValueExpected = precision.formatNumber(nominalValue, 6, false);
		
		Assert.assertNotSame(ntnB.calculateNominalValueUpdated(0.30, 0.18, "25/01/2017", "05/02/2017", 0.39, 0.17, 1000), nominalValueExpected);
	}
	
	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = Math.pow(Math.pow(15/100.0 + 1, 3/12.0), 20/30.0);
		double interestFactorExpected  = precision.formatNumber(interestFactor, 8, false);

		Assert.assertNotSame(ntnB.calculateInterestFactor(15, 3, 20, 30), interestFactorExpected);
	}
	
	@Test
	public void testCalculateInterest() {
		double interest = ntnB.getNominalValueUpdated() * (ntnB.calculateInterestFactor(15, 3, 20, 30) - 1);
		double interestExpected = precision.formatNumber(interest, 6, false);
		
		Assert.assertNotSame(ntnB.calculateInterest(15, 3, 20, 30), interestExpected);		
	}
}

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testNTNA3 {

	NTNA1 ntnA3;
	Precision precision;
	
	@Before
	public void setUp() throws Exception {
		/*
		cotacaoDolarA = 3.23
		cotacaoDolarB = 2.99
		*/	
		ntnA3 = new NTNA3(3.23, 2.99);
		precision = new Precision();
	}

	@Test
	public void testNominalValue() {
		double nominalValue = (3.23/2.99) * 1000;
		double nominalValueExpected = precision.formatNumber(nominalValue, 6, false);
		
		Assert.assertNotSame(ntnA3.calculateNominalValue(), nominalValueExpected);
	}

	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = (15/100.0) * 3/12;
		double interestFactorExpected = precision.formatNumber(interestFactor, 8, true);

		Assert.assertEquals(ntnA3.calculateInterestFactor(15, 3), interestFactorExpected, 0);
	}
	
	@Test
	public void testCalculateInterest() {
		double interest = ntnA3.getValueNominal() * ntnA3.getInterestFactor();
		double interestExpected = precision.formatNumber(interest, 6, false);
		Assert.assertNotSame((ntnA3.calculateInterest(15, 3), interestExpected);		
	}	
}

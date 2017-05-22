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
	public void testcalculateIncomeFactor() {
		double incomeFactor = Math.pow((0.30/0.18), (10/20.0));
		double incomeFactorExpected = precision.formactNumber(incomeFactor, 6, false, false);
	
		Assert.assertEquals(ntnB.calculateIncomeFactor(0.30, 0.18, 10, 20), incomeFactorExpected, 0);
	}
	
	@Test
	public void testPrecisionOfcalculateIncomeFactor() {
		double incomeFactor = Math.pow((0.30/0.18), (10/20.0));
		double incomeFactorNotExpected = precision.formactNumber(incomeFactor, 3, false, false);
	
		Assert.assertNotSame(ntnB.calculateIncomeFactor(0.30, 0.18, 10, 20), incomeFactorNotExpected);
	}
	
	@Test
	public void testNominalValueUpdated() {
		double incomeFactor = Math.pow((0.30/0.18), (10/20.0));
		double incomeFactorExpected = precision.formactNumber(incomeFactor, 6, false, false);
		double nominalValue = incomeFactorExpected * (0.39/0.17) * 1000;
		double nominalValueExpected = precision.formactNumber(nominalValue, 6, false, false);
		ntnB.calculateNominalValueUpdated(0.30, 0.18, 10, 20, 0.39, 0.17, 1000);
		
		Assert.assertEquals(ntnB.getNominalValueUpdated(), nominalValueExpected, 0);
	}
	
	@Test
	public void testPrecisionOfNominalValueUpdated() {
		double incomeFactor = Math.pow((0.30/0.18), (10/20.0));
		double incomeFactorExpected = precision.formactNumber(incomeFactor, 6, false, false);
		double nominalValue = incomeFactorExpected * (0.39/0.17) * 1000;
		double nominalValueNotExpected = precision.formactNumber(nominalValue, 3, false, false);
		ntnB.calculateNominalValueUpdated(0.30, 0.18, 10, 20, 0.39, 0.17, 1000);
		
		Assert.assertNotSame(ntnB.getNominalValueUpdated(), nominalValueNotExpected);
	}
	
	@Test
	public void testCalculateInterestFactor() {
		double interestFactor = Math.pow(Math.pow(15/100.0 + 1, 3/12.0), 20/30.0);
		double interestFactorExpected  = precision.formactNumber(interestFactor, 8, false, false);

		Assert.assertEquals(ntnB.calculateInterestFactor(15, 3, 20, 30), interestFactorExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculateInterestFactor() {
		double interestFactor = Math.pow(Math.pow(15/100.0 + 1, 3/12.0), 20/30.0);
		double interestFactorNotExpected  = precision.formactNumber(interestFactor, 4, false, false);

		Assert.assertNotSame(ntnB.calculateInterestFactor(15, 3, 20, 30), interestFactorNotExpected);
	}
	
	@Test
	public void testCalculateInterest() {
		ntnB.calculateNominalValueUpdated(0.30, 0.18, 10, 20, 0.39, 0.17, 1000);
		double interest = ntnB.getNominalValueUpdated() * (ntnB.calculateInterestFactor(15, 3, 20, 30));
		double interestExpected = precision.formactNumber(interest, 6, false, false);

		Assert.assertEquals(ntnB.calculateInterest(15, 3, 20, 30), interestExpected, 0);		
	}
	
	@Test
	public void testPrecisionOfCalculateInterest() {
		ntnB.calculateNominalValueUpdated(0.30, 0.18, 10, 20, 0.39, 0.17, 1000);
		double interest = ntnB.getNominalValueUpdated() * (ntnB.calculateInterestFactor(15, 3, 20, 30));
		double interestNotExpected = precision.formactNumber(interest, 3, false, false);
		
		Assert.assertNotSame(ntnB.calculateInterest(15, 3, 20, 30), interestNotExpected);		
	}
}

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class testBTN {

	BTN btn;
	Precision p;
	
	@Before
	public void setUp() throws Exception {
		btn = new BTN(0.0031, 3.50, 9.80);
		p = new Precision();
	}
	
	@Test
	public void testUpdateUnitPrice() {
		double previousUnitPrice = btn.getUnitPrice();
		btn.updateUnitPrice();
		double updatedUnitPrice = btn.getUnitPrice();
		
		Assert.assertEquals(previousUnitPrice * btn.getUpdateParameter(), updatedUnitPrice, 0);
	}
	
	@Test
	public void testIfUnitPriceIsDiferentAfterUpdated(){
		double previousUnitPrice = btn.getUnitPrice();
		btn.updateUnitPrice();
		double updatedUnitPrice = btn.getUnitPrice();
		
		Assert.assertNotSame(previousUnitPrice,updatedUnitPrice);
	}
	
	@Test
	public void testPrecisionOfUpdateUnitPrice() {
		double previousWrongUnitPrice = p.formactNumber(btn.getUnitPrice() * btn.getUpdateParameter(), 2, false);
		btn.updateUnitPrice();
		double updatedUnitPrice = btn.getUnitPrice();
		
		Assert.assertNotSame(previousWrongUnitPrice, updatedUnitPrice);
	}
	
	@Test
	public void testCalculateInterestFactor(){
		int months = 2;
		double interestFactorExpected = 0.01570375;
		Assert.assertEquals(btn.calculateInterestFactor(months), interestFactorExpected, 0) ;
	}
	
	@Test
	public void testPrecisionOfCalculateInterestFactor(){
		int months = 2;
		double interestFactorNotExpected = 0.01570377;
		
		Assert.assertNotSame(btn.calculateInterestFactor(months), interestFactorNotExpected);
	}
	
	@Test
	public void testCalculateInterest(){
		int months = 2;
		double interestFactor = btn.calculateInterestFactor(months);
		double interestExpected = p.formactNumber(interestFactor * btn.getUnitPrice(), 6, false);
		
		Assert.assertEquals(btn.calculateInterest(months), interestExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculateInterest(){
		int months = 2;
		double interestFactor = btn.calculateInterestFactor(months);
		double interestNotExpected = p.formactNumber(interestFactor * btn.getUnitPrice(), 3, false);
		
		Assert.assertNotSame(btn.calculateInterest(months), interestNotExpected);
	}
	
	@Test
	public void testCalculatePrincipal(){
		int quantity = 3;
		double principalExpected = quantity * btn.getUnitPrice();
		btn.calculatePrincipal(quantity);
		
		Assert.assertEquals(btn.getPrincipal(), principalExpected, 0);
	}
	
	@Test
	public void testPrecisionOfCalculatePrincipal(){
		int quantity = 3;
		double principalNotExpected = p.formactNumber(quantity * btn.getUnitPrice(), 1, true);
		btn.calculatePrincipal(quantity);
		
		Assert.assertEquals(btn.getPrincipal(), principalNotExpected, 0);
	}

}
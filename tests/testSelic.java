import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class testSelic {

	Selic selic;
	
	@Before
	public void setUp() throws Exception {
		selic = new Selic();
		
		selic.registerSelicTax(1.20, "02/10/10");
		selic.registerSelicTax(1.50, "03/10/10");
		selic.registerSelicTax(1.70, "04/10/10");
		selic.registerSelicTax(1.80, "05/10/10");
	}
	
	@Test
	public void testCalculateProductFactor(){
		double productFactorExpected = 1.00019679;
		
		Assert.assertEquals(productFactorExpected, selic.calculateProductFactor("03/10/10", "05/10/10"), 0);
	}
	
	@Test
	public void testPrecisionOfCalculateProductFactor(){
		double productFactorNotExpected = 1.00019680;
		
		Assert.assertNotSame(productFactorNotExpected, selic.calculateProductFactor("03/10/10", "05/10/10"));
	}

}

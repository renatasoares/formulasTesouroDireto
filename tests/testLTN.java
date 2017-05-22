import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testLTN {
	LTN ltn;
	
	@Before
	public void setUp() throws Exception {
		ltn = new LTN(3.50);
	}
	
	@Test
	public void testCalculateOfUnitPrice(){
		double UPExpected = 0.994049;
		ltn.setUnitPrice();
		Assert.assertEquals(UPExpected, ltn.getUnitPrice(), 0);
	}
	
	@Test
	public void testPrecisionOfCalculateOfUnitPrice(){
		double UPNotExpected = 0.994050;
		ltn.setUnitPrice();
		Assert.assertNotSame(UPNotExpected, ltn.getUnitPrice());
	}

}

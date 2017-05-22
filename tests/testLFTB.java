import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testLFTB {
	Selic selic;
	LFTB lftb;
	Precision p;
	
	@Before
	public void setUp() throws Exception {
		p = new Precision();
		selic = new Selic();		

		selic.registerSelicTax(1.20, "02/10/2010");
		selic.registerSelicTax(1.50, "03/10/2010");
		selic.registerSelicTax(1.70, "04/10/2010");
		selic.registerSelicTax(1.80, "05/10/2010");
		
		lftb = new LFTB(selic);
		
		lftb.registerNominalValue(2.012121, "02/10/2010");
		lftb.registerNominalValue(3.323434, "03/10/2010");
		lftb.registerNominalValue(4.123121, "04/10/2010");
		lftb.registerNominalValue(5.123123, "05/10/2010");
	}
	
	@Test
	public void testUpdateNominalValue(){
		lftb.updateNominalValue("03/10/2010", "05/05/2010");
		double nominalValueExpected = 3.324088;
		double nominalValueUpdated = lftb.getUpdatedNominalValue();
		
		Assert.assertEquals(nominalValueExpected, nominalValueUpdated, 0);
	}

	@Test
	public void testIfNominalValueIsDiferentAfterUpdated(){
		double previousNominalValue = lftb.getUpdatedNominalValue();
		lftb.updateNominalValue("03/10/2010", "05/05/2010");
		double updatedNominalValue = lftb.getUpdatedNominalValue();
		
		Assert.assertNotSame(previousNominalValue,updatedNominalValue);
	}

	@Test
	public void testPrecisionOfUpdateNominalValue(){
		lftb.updateNominalValue("03/10/2010", "05/05/2010");
		double nominalValueNotExpected = 3.32408;
		double nominalValueUpdated = lftb.getUpdatedNominalValue();
		
		Assert.assertNotSame(nominalValueNotExpected, nominalValueUpdated);
	}
}

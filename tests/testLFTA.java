import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testLFTA {
	Selic selic;
	LFTA lfta;
	
	@Before
	public void setUp() throws Exception {
		selic = new Selic();		
		
		selic.registerSelicTax(1.20, "02/10/2010");
		selic.registerSelicTax(1.50, "03/10/2010");
		selic.registerSelicTax(1.70, "04/10/2010");
		selic.registerSelicTax(1.80, "05/10/2010");
		
		lfta = new LFTA(selic, 2.808082);
		
	}

	@Test
	public void testUpdateNominalValue() {
		double nominalValueExpected = 2.808554;
		lfta.updateNominalValue("02/10/2011", "03/12/2011", "01/01/2012", 10, 5);
		
		Assert.assertEquals(nominalValueExpected, lfta.getUpdatedNominalValue(), 0);
	}
	
	@Test
	public void testIfNominalValueIsDiferentAfterUpdated(){
		double previousNominalValue = lfta.getUpdatedNominalValue();
		lfta.updateNominalValue("02/10/2011", "03/12/2011", "01/01/2012", 10, 5);
		double nominalValueExpected = lfta.getUpdatedNominalValue();
		
		Assert.assertNotSame(previousNominalValue,nominalValueExpected);
	}
	
	@Test
	public void testPrecisionOfUpdateNominalValue(){
		double nominalValueNotExpected = 2.808555;
		lfta.updateNominalValue("02/10/2011", "03/12/2011", "01/01/2012", 10, 5);
		
		Assert.assertNotSame(nominalValueNotExpected, lfta.getUpdatedNominalValue());
	}

	

}

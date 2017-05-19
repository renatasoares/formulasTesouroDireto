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
	public void testCalculoPrecoUnitario(){
		double PUEsperado = 0.994049;
		ltn.setPrecoUnitario();
		Assert.assertEquals(PUEsperado, ltn.getPrecoUnitario(), 0);
	}

}

import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class testSelic {
//1.00019679
	Selic selic;
	
	@Before
	public void setUp() throws Exception {
		selic = new Selic();
		
		selic.registerTaxasSelic(1.20, "02/10/10");
		selic.registerTaxasSelic(1.50, "03/10/10");
		selic.registerTaxasSelic(1.70, "04/10/10");
		selic.registerTaxasSelic(1.80, "05/10/10");
	}
	
	@Test
	public void testcalculoFatorProdutorio(){
		double fatorProdutorioEsperado = 1.00019679;
		
		Assert.assertEquals(fatorProdutorioEsperado, selic.calcularFatorProdutorio("03/10/10", "05/10/10"), 0);
	}

}

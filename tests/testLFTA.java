import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testLFTA {
	Selic selic;
	LFTA lfta;
	
	@Before
	public void setUp() throws Exception {
		selic = new Selic();		
		
		selic.registerTaxasSelic(1.20, "02/10/10");
		selic.registerTaxasSelic(1.50, "03/10/10");
		selic.registerTaxasSelic(1.70, "04/10/10");
		selic.registerTaxasSelic(1.80, "05/10/10");
		
		lfta = new LFTA(selic, 2.808082);
		
	}

	@Test
	public void testAtualizarValorNominal() {
		double valorNominalEsperado = 2.808554;
		lfta.atualizarValorNominal("02/10/2011", "03/12/2011", "01/01/2012", 10, 5);
		
		Assert.assertEquals(valorNominalEsperado, lfta.getvalorNominalAtualizado(), 0);
	}
	
	@Test
	public void testValorNominalDiferenteAposAtualizado(){
		double valorNominalAntigo = lfta.getvalorNominalAtualizado();
		lfta.atualizarValorNominal("02/10/2011", "03/12/2011", "01/01/2012", 10, 5);
		double valorNominalAtualizado = lfta.getvalorNominalAtualizado();
		
		Assert.assertNotSame(valorNominalAntigo,valorNominalAtualizado);
	}

	

}

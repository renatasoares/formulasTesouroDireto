import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testLFTB {
	Selic selic;
	LFTB lftb;
	
	@Before
	public void setUp() throws Exception {
		selic = new Selic();		

		selic.registerTaxasSelic(1.20, "02/10/10");
		selic.registerTaxasSelic(1.50, "03/10/10");
		selic.registerTaxasSelic(1.70, "04/10/10");
		selic.registerTaxasSelic(1.80, "05/10/10");
		
		lftb = new LFTB(selic);
		
		lftb.registerValorNominal(2.012121, "02/10/10");
		lftb.registerValorNominal(3.323434, "03/10/10");
		lftb.registerValorNominal(4.123121, "04/10/10");
		lftb.registerValorNominal(5.123123, "05/10/10");
	}
	
	@Test
	public void testAtualizarValorNominal(){
		lftb.atualizarValorNominal("03/10/10", "05/05/10");
		double valorNAEsperado = 3.324088;
		double valorNominalAtualizado = lftb.getValorNominalAtualizado();
		
		Assert.assertEquals(valorNAEsperado, valorNominalAtualizado, 0);
	}

	@Test
	public void testValorNominalDiferenteAposAtualizado(){
		double valorNominalAntigo = lftb.getValorNominalAtualizado();
		lftb.atualizarValorNominal("03/10/10", "05/05/10");
		double valorNominalAtualizado = lftb.getValorNominalAtualizado();
		
		Assert.assertNotSame(valorNominalAntigo,valorNominalAtualizado);
	}

}

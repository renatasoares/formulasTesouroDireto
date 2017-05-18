import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testLFT {
	Selic selic;
	LFT lft;
	
	@Before
	public void setUp() throws Exception {
		selic = new Selic();		

		selic.registerTaxasSelic(1.20, "02/10/10");
		selic.registerTaxasSelic(1.50, "03/10/10");
		selic.registerTaxasSelic(1.70, "04/10/10");
		selic.registerTaxasSelic(1.80, "05/10/10");
		
		lft = new LFT(selic);
		
		lft.registerValorNominal(2.012121, "02/10/10");
		lft.registerValorNominal(3.323434, "03/10/10");
		lft.registerValorNominal(4.123121, "04/10/10");
		lft.registerValorNominal(5.123123, "05/10/10");
	}
	
	@Test
	public void testAtualizarValorNominal(){
		lft.atualizarValorNominal("03/10/10", "05/05/10");
		double valorNAEsperado = 3.324088;
		double valorNominalAtualizado = lft.getValorNominalAtualizado();
		
		Assert.assertEquals(valorNAEsperado, valorNominalAtualizado, 0);
	}

	@Test
	public void testValorNominalDiferenteAposAtualizado(){
		double valorNominalAntigo = lft.getValorNominalAtualizado();
		lft.atualizarValorNominal("03/10/10", "05/05/10");
		double valorNominalAtualizado = lft.getValorNominalAtualizado();
		
		Assert.assertNotSame(valorNominalAntigo,valorNominalAtualizado);
	}

}

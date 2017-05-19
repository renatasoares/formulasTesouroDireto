import org.junit.Before;
import org.junit.Test;

import org.junit.Assert;

public class testNTNA1 {

	NTNA1 ntnA1;
	Precision precision;
	
	@Before
	public void setUp() throws Exception {
		/*
		cotacaoDolarA = 3.23
		cotacaoDolarB = 2.99
		taxaJuros = 15
		*/	
		ntnA1 = new NTNA1(3.23, 2.99);
		precision = new Precision();
	}

	@Test
	public void testeCalculaPU() {
		double pu = (3.23/2.99)*(1000 * 0.8);
		double puEsperado = precision.formatNumber(pu, 6, false);
		
		Assert.assertNotSame(ntnA1.calculaPU(1000, 80), puEsperado);
	}

	@Test
	public void testeCalculaFatorJuros() {
		double fatorJuros = (120/360.0) * (15/100.0);
		double fatorJurosEsperado = precision.formatNumber(fatorJuros, 8, true);

		Assert.assertEquals(ntnA1.calculaFatorJuros("10/01/2017", "10/05/2017", 15), fatorJurosEsperado, 0);
	}
	
	@Test
	public void testeCalculaJuros() {
		double jurosEsperado = ntnA1.getPUAmortizacao() * (15/100.0) ;
		
		Assert.assertEquals(ntnA1.calculaJuros("10/01/2017", "10/05/2017", 15), jurosEsperado, 0);		
	}	

}

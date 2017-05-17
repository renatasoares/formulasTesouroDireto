import static org.junit.Assert.*;

import org.junit.Test;

public class testNTNA1 {

	NTNA1 ntnA1;
	
	@Test
	public void testeCalculaPU() {
		double cotacaoDolarA = 3.23;
		double cotacaoDolarB = 2.99;
		double vl = 1000;
		double puEsperado = 1080.267559;
		
		assertEquals(ntnA1.calculaPU(cotacaoDolarA, cotacaoDolarB, vl), puEsperado);
	}
	@Test
	public void testeCalculaFatorJuros() {
		int dtp = ntnA1.data(10, 4);
		int dtup = ntnA1.data(10, 8);
		double fatorJurosEsperado = 0.05666667;
		
		assertEquals(ntnA1.calculaFatorJuros(dtp, dtup), fatorJurosEsperado);
	}
	
	@Test
	public void testeCalculaJuros() {
		double PUam = 1080.267559;
		double fatorJuros = 0.05666667;
		double jurosEsperado = 61.215165;
		
		assertEquals(ntnA1.calculaJuros(PUam, fatorJuros), jurosEsperado);		
	}	

}

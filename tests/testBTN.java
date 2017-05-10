
import static org.junit.Assert.*;

import org.junit.Test;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class testBTN {

	BTN btn;
	
	@Before
	public void setUp() throws Exception {
		/*TR = 	0.0031;
		 PU = 3.50
		 juros = 9.80
		*/
		btn = new BTN(0.0031, 3.50, 9.80);
	}
	
	@Test
	public void testeAtualizacaoPU() {
		double PUanterior = btn.getPU();
		double PUatualizado = btn.atualizarPU();
		
		assertEquals(PUanterior * btn.getTR(), PUatualizado);
	}
	
	@Test
	public void testeCalculaFatorJuros(){
		int numeroDeMeses = 2;
		double fatorJurosEsperado = 1.01570375;
		
		assertEquals(btn.calculaFJ(numeroDeMeses), fatorJurosEsperado) ;
	}
	
	@Test
	public void testeCalculaJuros(){
		int numeroDeMeses;
		double fatorJuros = 1.01570375;
		double jurosEsperado = fatorJuros * btn.getPU();
		
		assertEquals(btn.calculaJuros(numeroDeMeses), jurosEsperado);
	}
	
	@Test
	public void testeCalculaPrincipal(){
		int quantidade = 3;
		double principalEsperado = quantidade * btn.getPU();
		
		assertEquals(btn.calculaPrincipal(quantidade), principalEsperado);
	}

}
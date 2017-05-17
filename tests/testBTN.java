import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class testBTN {

	BTN btn;
	
	@Before
	public void setUp() throws Exception {
		/*TR = 	0.0031;
		 PU = 3.50 00 00
		 juros = 9.80
		*/
		btn = new BTN(0.0031, 3.50, 9.80);
	}
	
	@Test
	public void testeAtualizacaoPU() {
		double PUanterior = btn.getPrecoUnitario();
		btn.atualizarPU();
		double PUatualizado = btn.getPrecoUnitario();
		
		Assert.assertEquals(PUanterior * btn.getParametroDeAtualizacao(), PUatualizado, 0);
	}
	
	@Test
	public void testeCalculaFatorJuros(){
		int numeroDeMeses = 2;
		double fatorJurosEsperado = 0.01570375;
		Assert.assertEquals(btn.calculaFatorDeJuros(numeroDeMeses), fatorJurosEsperado, 0) ;
	}
	
	@Test
	public void testeCalculaJuros(){
		Precision p = new Precision();
		int numeroDeMeses = 2;
		double fatorJuros = btn.calculaFatorDeJuros(numeroDeMeses);
		double jurosEsperado = p.formatNumber(fatorJuros * btn.getPrecoUnitario(), 6, false);
		
		Assert.assertEquals(btn.calculaJuros(numeroDeMeses), jurosEsperado, 0);
	}
	
	@Test
	public void testeCalculaPrincipal(){
		int quantidade = 3;
		double principalEsperado = quantidade * btn.getPrecoUnitario();
		btn.calculaPrincipal(quantidade);
		
		Assert.assertEquals(btn.getPrincipal(), principalEsperado, 0);
	}

}
import java.lang.Math;

public class BTN extends Precision {

	double parametroDeAtualizacao;
	double precoUnitario;
	double juros;
	double principal;
	
	public BTN(double parametroDeAtualizacao, double precoUnitario, double juros) {
		super();
		this.parametroDeAtualizacao = parametroDeAtualizacao;
		this.precoUnitario = precoUnitario;
		this.juros = juros;
	}
	
	public void atualizarPU(){
		double PU = this.precoUnitario * this.parametroDeAtualizacao;
		setPrecoUnitario(formatNumber(PU, 6, false));
	}
	
	public double calculaFatorDeJuros(int numeroMeses){
		double taxaJuros = 1 + (getJuros()/100);
		double FJ = Math.pow(taxaJuros, numeroMeses/12.0) - 1;
		return formatNumber(FJ, 8, true);
	}
	
	public double calculaJuros(int numeroMeses){
		double juros = calculaFatorDeJuros(numeroMeses) * getPrecoUnitario();
		return formatNumber(juros, 6, false);
	}
	
	public void calculaPrincipal(int quantidade){
		double principal = getPrecoUnitario()*quantidade;
		setPrincipal(formatNumber(principal, 2, true));
	}
	
	public double getParametroDeAtualizacao() {
		return this.parametroDeAtualizacao;
	}
	private void setParametroDeAtualizacao(double parametroDeAtualizacao) {
		this.parametroDeAtualizacao = parametroDeAtualizacao;
	}
	public double getPrecoUnitario() {
		return this.precoUnitario;
	}
	private void setPrecoUnitario(double precoUnitario) {
		this.precoUnitario = precoUnitario;
	}
	public double getJuros() {
		return this.juros;
	}

	private void setJuros(double juros) {
		this.juros = juros;
	}
	public double getPrincipal() {
		return this.principal;
	}
	private void setPrincipal(double principal) {
		this.principal = principal;
	}
}

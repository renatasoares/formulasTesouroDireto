public class NTNA1 extends Precision {

	double cotacaoDolarA;
	double cotacaoDolarB;
	double puAmortizacao;
		
	public NTNA1(double cotacaoDolarA, double cotacaoDolarB) {
		this.cotacaoDolarA = cotacaoDolarA;
		this.cotacaoDolarB = cotacaoDolarB;
	}
	
	public double calculaValorLiquido(double valorEmissao, int percentualAmortizacao) {
		double valorLiquido = (valorEmissao * percentualAmortizacao)/100;
		return valorLiquido;
	}
	
	public double calculaPU(double valorEmissao, int percentualAmortizacao) {
		double puAmortizacao = (getCotacaoDolarA()/getCotacaoDolarB()) * calculaValorLiquido(valorEmissao, percentualAmortizacao);
		setPUAmortizacao(formatNumber(puAmortizacao, 6, false));
		return formatNumber(puAmortizacao, 6, false);
	}
	
	public double calculaFatorJuros(String dtp, String dtup, int taxa) {
		Date date = new Date();
		double fator = (date.formactDate(dtp, dtup)/360.0) * (taxa/100.0);
		return formatNumber(fator, 8, true);
	}
	
	public double calculaJuros(String dtp, String dtup, int taxa) {
		double juros = getPUAmortizacao() * calculaFatorJuros(dtp, dtup, taxa);
		return formatNumber(juros, 6, false); 	
	}
	
	public double getCotacaoDolarA() {
		return cotacaoDolarA;
	}

	public void setCotacaoDolarA(double cotacaoDolarA) {
		this.cotacaoDolarA = cotacaoDolarA;
	}

	public double getCotacaoDolarB() {
		return cotacaoDolarB;
	}

	public void setCotacaoDolarB(double cotacaoDolarB) {
		this.cotacaoDolarB = cotacaoDolarB;
	}

	public double getPUAmortizacao() {
		return puAmortizacao;
	}

	public void setPUAmortizacao(double puAmortizacao) {
		this.puAmortizacao = puAmortizacao;
	}
}

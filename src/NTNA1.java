public class NTNA1 extends Precision {

	double cotacaoDolarA;
	double cotacaoDolarB;
	double puAmortizacao;
	double percentualAmortizacao;
	double valorEmissao;
	int taxaJuros;
	String dtp;
	String dtup;
		
	public NTNA1(double cotacaoDolarA, double cotacaoDolarB, int taxaJuros, double percentualAmortizacao, 
	double valorEmissao, String dtp, String dtup) {
		this.cotacaoDolarA = cotacaoDolarA;
		this.cotacaoDolarB = cotacaoDolarB;
		this.taxaJuros = taxaJuros;
		this.valorEmissao = valorEmissao;
		this.percentualAmortizacao = percentualAmortizacao;
		this.dtp = dtp;
		this.dtup = dtup;
	}
	
	public double calculaValorLiquido() {
		double valorLiquido = getValorEmissao() * getPercentualAmortizacao();
		return valorLiquido;
	}
	
	public double calculaPU() {
		double puAmortizacao = (getCotacaoDolarA()/getCotacaoDolarB()) * calculaValorLiquido();
		setPUAmortizacao(formatNumber(puAmortizacao, 6, false));
		return formatNumber(puAmortizacao, 6, false);
	}
	
	public double calculaFatorJuros(String dtp, String dtup) {
		Data data = new Data();
		double fator = (data.formataData(dtp, dtup)/360) * (getTaxaJuros()/100);
		return formatNumber(fator, 8, true);
	}
	
	public double calculaJuros() {
		double juros = getPUAmortizacao() * calculaFatorJuros(getDtp(), getDtup());
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

	public double getPercentualAmortizacao() {
		return percentualAmortizacao;
	}

	public void setPercentualAmortizacao(double percentualAmortizacao) {
		this.percentualAmortizacao = percentualAmortizacao;
	}

	public double getValorEmissao() {
		return valorEmissao;
	}

	public void setValorEmissao(double valorEmissao) {
		this.valorEmissao = valorEmissao;
	}

	public int getTaxaJuros() {
		return taxaJuros;
	}

	public void setTaxaJuros(int taxaJuros) {
		this.taxaJuros = taxaJuros;
	}
	
	public String getDtp() {
		return dtp;
	}

	public void setDtp(String dtp) {
		this.dtp = dtp;
	}

	public String getDtup() {
		return dtup;
	}

	public void setDtup(String dtup) {
		this.dtup = dtup;
	}
}

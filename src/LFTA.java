public class LFTA extends Selic{
	
	Selic selic = new Selic();
	Data data = new Data();
	private double valorNominalEmissao;
	private double valorNominalAtualizado;
	private static double taxaAcrescimo =  0.0245;
	
	public LFTA(Selic selic, double valorNominalEmissao) {
		super();
		this.selic = selic;
		this.valorNominalEmissao = formatNumber(valorNominalEmissao, 6, false);
	}
	
	public void atualizarValorNominal(String dataEmissao, String dataAtualizacao, String dataPagamento, int numeroParcelas, int parcelasAmortizadas){
		double DU = data.formataData(dataEmissao, dataAtualizacao);
		double DUt = data.formataData(dataEmissao, dataPagamento);
		double arg1 = getFatorProdutorio(dataEmissao, dataAtualizacao) * getValorNominalEmissao() * Math.pow((1 + taxaAcrescimo/100), DU/DUt);
		double arg2 = getFatorProdutorio(dataEmissao, dataAtualizacao) * getValorNominalEmissao() * Math.pow((1 + taxaAcrescimo), DU/DUt);
		double arg3 = 1/(numeroParcelas - parcelasAmortizadas);
		
		setvalorNominalAtualizado(formatNumber(arg1-(arg2*arg3), 6, false));
	}

	public double getFatorProdutorio(String dataEmissao, String dataAtualizacao) {
		return selic.calcularFatorProdutorio(dataEmissao, dataAtualizacao);
	}
	
	public double getValorNominalEmissao() {
		return valorNominalEmissao;
	}

	public void setValorNominalEmissao(double valorNominalEmissao) {
		this.valorNominalEmissao = valorNominalEmissao;
	}
	public double getvalorNominalAtualizado() {
		return valorNominalAtualizado;
	}

	public void setvalorNominalAtualizado(double valorNominalAtualizado) {
		this.valorNominalAtualizado = valorNominalAtualizado;
	}

}

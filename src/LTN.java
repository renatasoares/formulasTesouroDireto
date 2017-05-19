public class LTN extends Precision{
	double precoUnitario;
	double taxaIndicativa;
	
	public LTN(double taxaIndicativa){
		super();
		this.taxaIndicativa = taxaIndicativa;
	}
	
	public double getPrecoUnitario() {
		return precoUnitario;
	}

	public void setPrecoUnitario(){
		double PU = 1/Math.pow(1+getTaxaIndicativa(), 1/252.0);
		this.precoUnitario = formatNumber(PU, 6, false);
	}

	public double getTaxaIndicativa() {
		return taxaIndicativa;
	}
		
}

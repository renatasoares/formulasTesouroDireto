public class NTNA1 extends Precision {

	double puAmortization;
		
	public NTNA1() {
	}
	
	public double calculateNetValue(double emissionValue, int percentualAmortizacao) {
		double netValue = (emissionValue * percentualAmortizacao)/100;
		return netValue;
	}
	
	public double calculatePU(double quotationDolarA, double quotationDolarB, double emissionValue, int amortizationPercentege) {
		double puAmortization = (quotationDolarA/quotationDolarB) * calculateNetValue(emissionValue, amortizationPercentege);
		setPUAmortization(formactNumber(puAmortization, 6, false));
		return formactNumber(puAmortization, 6, false);
	}
	
	public double calculateInterestFactor(String dtp, String dtup, int rate) {
		Date date = new Date();
		double factor = (date.formactDate(dtp, dtup)/360.0) * (rate/100.0);
		return formactNumber(factor, 8, true);
	}
	
	public double calculateInterest(String dtp, String dtup, int rate) {
		double interest = getPUAmortization() * calculateInterestFactor(dtp, dtup, rate);
		return formactNumber(interest, 6, false); 	
	}
	
	public double getPUAmortization() {
		return puAmortization;
	}

	public void setPUAmortization(double puAmortization) {
		this.puAmortization = puAmortization;
	}
}

public class NTNA1 extends Precision {

	double puAmortization;
		
	public NTNA1() {
	}
	
	public double calculateNetValue(double emissionValue, double percentualAmortizacao) {
		double netValue = (emissionValue * percentualAmortizacao)/100;
		return netValue;
	}
	
	public void calculatePU(double quotationDolarA, double quotationDolarB, double emissionValue, double amortizationPercentege) {
		double puAmortization = (quotationDolarA/quotationDolarB) * calculateNetValue(emissionValue, amortizationPercentege);
		setPUAmortization(formactNumber(puAmortization, 6, false, false));
	}
	
	public double calculateInterestFactor(String dtp, String dtup, double rate) {
		Date date = new Date();
		double factor = (date.formactDate(dtp, dtup)/360.0) * (rate/100.0);
		return formactNumber(factor, 8, true, false);
	}
	
	public double calculateInterest(String dtp, String dtup, double rate) {
		double interest = getPUAmortization() * calculateInterestFactor(dtp, dtup, rate);
		return formactNumber(interest, 6, false, false); 	
	}
	
	public double getPUAmortization() {
		return this.puAmortization;
	}

	public void setPUAmortization(double puAmortization) {
		this.puAmortization = puAmortization;
	}
}

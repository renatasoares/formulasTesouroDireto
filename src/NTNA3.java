public class NTNA3 extends Precision {

	double quotationDolarA;
	double quotationDolarB;
	double nominalValue;
	double interestFactor;

	public double calculateNominalValue(double quotationDolarA, double quotationDolarB) {
		double nominalValue = (quotationDolarA/quotationDolarB) * 1000;
		setNominalValue(formatNumber(nominalValue, 6, false));
		return formatNumber(nominalValue, 6, false);
	}
	
	public double calculateInterestFactor(int rate, int n) {
		double interestFactor = (rate/100.0) * (n/12.0);
		return formatNumber(interestFactor, 8, true);
	}
	
	public double calculateInterest(int rate, int n) {
		double interest = getNominalValue() * calculateInterestFactor(rate, n);
		return formatNumber(interest, 6, false); 	
	}
	
	public double getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(double nominalValue) {
		this.nominalValue = nominalValue;
	}
}


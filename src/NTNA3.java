public class NTNA3 extends Precision {

	double quotationDolarA;
	double quotationDolarB;
	double nominalValue;
	double interestFactor;

	public NTNA3(double quotationDolarA, double quotationDolarB) {
		this.quotationDolarA = quotationDolarA;
		this.quotationDolarA = quotationDolarB;
	}
	
	public double calculateNominalValue() {
		double nominalValue = (getQuotationDolarA()/getQuotationDolarB()) * 100;
		setNominalValue(formatNumber(nominalValue, 6, false));
		return formatNumber(nominalValue, 6, false);
	}
	
	public double calculateInterestFactor(int rate, int n) {
		double interestFactor = (rate/100.0) * (n/12.0);
		setInterestFactor(formatNumber(interestFactor, 8, true));
		return formatNumber(interestFactor, 8, true);
	}
	
	public double calculateInterest(int rate, int n) {
		double interest = getNominalValue() * calculateInterestFactor(rate, n);
		return formatNumber(interest, 6, false); 	
	}
	
	public double getQuotationDolarA() {
		return quotationDolarA;
	}

	public void setQuotationDolarA(double quotationDolarA) {
		this.quotationDolarA = quotationDolarA;
	}

	public double getQuotationDolarB() {
		return quotationDolarB;
	}

	public void setQuotationDolarB(double quotationDolarB) {
		this.quotationDolarB = quotationDolarB;
	}
	
	public double getNominalValue() {
		return nominalValue;
	}

	public void setNominalValue(double nominalValue) {
		this.nominalValue = nominalValue;
	}
	
	public double getInterestFactor() {
		return interestFactor;
	}
	
	public void setInterestFactor(double interestFactor) {
		this.interestFactor = interestFactor;
	}
}


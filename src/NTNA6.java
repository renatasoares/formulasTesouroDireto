public class NTNA6 extends Precision {

	double nominalValueUpdated;

	public double calculateNominalValueUpdated(double quotationDolarA, double quotationDolarB, double emissionValue) {
		double nominalValue = (quotationDolarA/quotationDolarB) * emissionValue;
		setNominalValueUpdated(formatNumber(nominalValue, 6, true));
		return formatNumber(nominalValue, 6, true);
	}
	
	public double calculateInterestFactor(String dtp, String dtup, int rate) {
		Date date = new Date();
		double fator = (date.formactDate(dtp, dtup)/360.0) * (rate/100.0);
		return formatNumber(fator, 8, true);
	}
	
	public double calculateInterest(String dtp, String dtup, int rate) {
		double interest = getNominalValueUpdated() * calculateInterestFactor(dtp, dtup, rate);
		return formatNumber(interest, 6, false); 	
	}
	
	public double getNominalValueUpdated() {
		return nominalValueUpdated;
	}

	public void setNominalValueUpdated(double nominalValueUpdated) {
		this.nominalValueUpdated = nominalValueUpdated;
	}

}


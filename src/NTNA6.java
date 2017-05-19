public class NTNA6 extends Precision {

	double nominalValueUpdated;

	public double calculateNominalValueUpdated(double quotationDolarA, double quotationDolarB, double emissionValue) {
		double nominalValue = (quotationDolarA/quotationDolarB) * emissionValue;
		setNominalValueUpdated(formactNumber(nominalValue, 6, true, false));
		return formactNumber(nominalValue, 6, true, false);
	}
	
	public double calculateInterestFactor(String dtp, String dtup, double rate) {
		Date date = new Date();
		double fator = (date.formactDate(dtp, dtup)/360.0) * (rate/100.0);
		return formactNumber(fator, 8, true, false);
	}
	
	public double calculateInterest(String dtp, String dtup, double rate) {
		double interest = getNominalValueUpdated() * calculateInterestFactor(dtp, dtup, rate);
		return formactNumber(interest, 6, false, false); 	
	}
	
	public double getNominalValueUpdated() {
		return nominalValueUpdated;
	}

	public void setNominalValueUpdated(double nominalValueUpdated) {
		this.nominalValueUpdated = nominalValueUpdated;
	}

}


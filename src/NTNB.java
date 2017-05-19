
public class NTNB extends Precision{
	
	double nominalValueUpdated;
	
	public double calculateIncomeFactor(double ipcat1, double ipcat0, int dc, int dct) {
		double doubleDCT = dct;
		double incomeFactor = Math.pow((ipcat1/ipcat0), (dc/doubleDCT));
		return formactNumber(incomeFactor, 6, false);	
	}
		
	public double calculateNominalValueUpdated(double ipcat1, double ipcat0, int dc, int dct, double ipcatA, double ipcatB, double vn) {
		double nominalValue = calculateIncomeFactor(ipcat1, ipcat0, dc, dct) * (ipcatA/ipcatB) * vn;
		setNominalValueUpdated(formactNumber(nominalValue, 6, false));
		return formactNumber(nominalValue, 6, true);
	}
	
	public double calculateInterestFactor(int rate, int n, int dcp, int dct) {
		double doubleDCT = dct;
		double fator = Math.pow(Math.pow((rate/100.0 + 1), n/12.0), (dcp/doubleDCT));
		return formactNumber(fator, 8, false);
	}
	
	public double calculateInterest(int rate, int n, int dcp, int dct) {
		double interest = getNominalValueUpdated() * calculateInterestFactor(rate, n, dcp, dct);
		return formactNumber(interest, 6, false); 	
	}
	
	public double getNominalValueUpdated() {
		return nominalValueUpdated;
	}

	public void setNominalValueUpdated(double nominalValueUpdated) {
		this.nominalValueUpdated = nominalValueUpdated;
	}

}

public class LFTA extends Selic{
	
	Selic selic = new Selic();
	Date date = new Date();
	private double emissionNominalValue;
	private double updatedNominalValue;
	private static double increaseTax =  0.0245;
	
	public LFTA(Selic selic, double emissionNominalValue) {
		super();
		this.selic = selic;
		this.emissionNominalValue = formactNumber(emissionNominalValue, 6, false, false);
	}
	
	public void updateNominalValue(String emissionDate, String updateDate, String paymentDate, int numberOfPlots, int amortizedPlots){
		double DU = date.formactDate(emissionDate, updateDate);
		double DUt = date.formactDate(emissionDate, paymentDate);
		double arg1 = getProductFactor(emissionDate, updateDate) * getEmissionNominalValue() * Math.pow((1 + increaseTax/100), DU/DUt);
		double arg2 = getProductFactor(emissionDate, updateDate) * getEmissionNominalValue() * Math.pow((1 + increaseTax), DU/DUt);
		double arg3 = 1/(numberOfPlots - amortizedPlots);
		
		setUpdatedNominalValue(formactNumber(arg1-(arg2*arg3), 6, false, false));
	}

	public double getProductFactor(String emissionDate, String updateDate) {
		return selic.calculateProductFactor(emissionDate, updateDate);
	}
	
	public double getEmissionNominalValue() {
		return emissionNominalValue;
	}

	public void setEmissionNominalValue(double emissionNominalValue) {
		this.emissionNominalValue = emissionNominalValue;
	}
	public double getUpdatedNominalValue() {
		return updatedNominalValue;
	}

	public void setUpdatedNominalValue(double updatedNominalValue) {
		this.updatedNominalValue = updatedNominalValue;
	}

}

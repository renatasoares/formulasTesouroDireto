import java.lang.Math;

public class BTN extends Precision {

	double updateParameter;
	double unitPrice;
	double interest;
	double principal;
	
	public BTN(double updateParameter, double unitPrice, double interest) {
		super();
		this.updateParameter = updateParameter;
		this.unitPrice = unitPrice;
		this.interest = interest;
	}
	
	public void updateUnitPrice(){
		double PU = this.unitPrice * this.updateParameter;
		setUnitPrice(formactNumber(PU, 6, false, false));
	}
	
	public double calculateInterestFactor(int months){
		double interestRate = 1 + (getInterest()/100);
		return formactNumber(Math.pow(interestRate, months/12.0) - 1, 8, true, false);
	}
	
	public double calculateInterest(int months){
		double interest = calculateInterestFactor(months) * getUnitPrice();
		return formactNumber(interest, 6, false, false);
	}
	
	public void calculatePrincipal(int quantity){
		double principal = getUnitPrice()*quantity;
		setPrincipal(formactNumber(principal, 2, true, false));
	}
	
	public double getUpdateParameter() {
		return this.updateParameter;
	}
	private void setUpdateParameter(double updateParameter) {
		this.updateParameter = updateParameter;
	}
	public double getUnitPrice() {
		return this.unitPrice;
	}
	private void setUnitPrice(double precoUnitario) {
		this.unitPrice = precoUnitario;
	}
	public double getInterest() {
		return this.interest;
	}

	private void setInterest(double interest) {
		this.interest = interest;
	}
	public double getPrincipal() {
		return this.principal;
	}
	private void setPrincipal(double principal) {
		this.principal = principal;
	}
}

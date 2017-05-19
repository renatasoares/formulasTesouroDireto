public class LTN extends Precision{
	double unitPrice;
	double indicativeTax;
	
	public LTN(double indicativeTax){
		super();
		this.indicativeTax = indicativeTax;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(){
		double UP = 1/Math.pow(1+getIndicativeTax(), 1/252.0);
		this.unitPrice = formactNumber(UP, 6, false);
	}

	public double getIndicativeTax() {
		return indicativeTax;
	}
		
}

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

public class Precision {
	
	public double formactNumber(double number, int scale, boolean arredondar){
		String format = "#.";
		for(int i=0; i<scale;i++){
			format += "#";
		}
		
		NumberFormat nf = new DecimalFormat (format, new DecimalFormatSymbols (new Locale ("en", "US")));
		
		if(arredondar){
			nf.setRoundingMode(RoundingMode.HALF_UP);
		}
		
		return Double.parseDouble(nf.format(number));
	}
}

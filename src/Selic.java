import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Selic extends Precision{
	
	private final Map<String, Double> selic = new HashMap<String, Double>();
	
	public void registerSelicTax(double tax, String date){
		double precisionTax = formactNumber(tax, 2, false, false);
		selic.put(date, precisionTax);
	}
	
	private Map<String, Double> sortSelicTaxesbyDate(){
        Map<String, Double> sortedMap = new TreeMap<String, Double>(selic);
        return sortedMap;
	}
	
	public double calculateProductFactor(String baseDate, String finalDate){
		double productFactor = 1;
		boolean findDate = false;
		Map <String, Double> sortedSelicTaxes = sortSelicTaxesbyDate();
		Set<Entry<String, Double>> set = sortedSelicTaxes.entrySet();
		Iterator<Entry<String, Double>> i = set.iterator();

		while(i.hasNext()) {
		    Map.Entry<String, Double> values = (Map.Entry<String, Double>)i.next();
		    if(values.getKey() == baseDate){
		    	findDate = true;
		    }
		    if(values.getKey() == finalDate){
		    	findDate = false;
		    	productFactor *= Math.pow((values.getValue()/100)+1, 1/252.0);
		    }
		    if(findDate){
		    	productFactor *= Math.pow((values.getValue()/100)+1, 1/252.0);
		    }
		}
		
		return formactNumber(productFactor, 8, true, false);
	}
	
}
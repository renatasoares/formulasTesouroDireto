import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class LFTB extends Selic{

	double updatedNominalValue;
	Selic selic = new Selic();
	
	public LFTB(Selic selic) {
		super();
		this.selic = selic;
	}
	
	private final Map<String, Double> nominalValue = new HashMap<String, Double>();
	
	public void registerNominalValue(double baseNominalValue, String date){
		double precisionNominalValue = formactNumber(baseNominalValue, 6, false, false);
		nominalValue.put(date, precisionNominalValue);
	}

	public void updateNominalValue(String baseDate, String finalDate){
		Set<Entry<String, Double>> set = nominalValue.entrySet();
		Iterator<Entry<String, Double>> i = set.iterator();

		while(i.hasNext()) {
		    Map.Entry<String, Double> values = (Map.Entry<String, Double>)i.next();
		    if(values.getKey() == baseDate){
		    	double nominalValueA = values.getValue()* selic.calculateProductFactor(baseDate, finalDate);
		    	setUpdatedNominalValue(formactNumber(nominalValueA, 6 , false, false));
		    }
		}
	}

	public double getUpdatedNominalValue() {
		return updatedNominalValue;
	}

	public void setUpdatedNominalValue(double valorNominalAtualizado) {
		this.updatedNominalValue = valorNominalAtualizado;
	}
	
}

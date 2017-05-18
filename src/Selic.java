import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

public class Selic extends Precision{
	
	private final Map<String, Double> selic = new HashMap<String, Double>();
	
	public void registerTaxasSelic(double taxa, String data){
		double precisionTaxa = formatNumber(taxa, 2, false);
		selic.put(data, precisionTaxa);
	}
	
	private Map<String, Double> sortTaxasSelicbyDate(){
        Map<String, Double> treeMap = new TreeMap<String, Double>(selic);
        return treeMap;
	}
	
	public double calcularFatorProdutorio(String dataBase, String dataFinal){
		double fatorProdutorio = 1;
		boolean findData = false;
		Map <String, Double> sortedTaxasSelic = sortTaxasSelicbyDate();
		Set<Entry<String, Double>> set = sortedTaxasSelic.entrySet();
		Iterator<Entry<String, Double>> i = set.iterator();

		while(i.hasNext()) {
		    Map.Entry<String, Double> entrada = (Map.Entry<String, Double>)i.next();
		    if(entrada.getKey() == dataBase){
		    	findData = true;
		    }
		    if(entrada.getKey() == dataFinal){
		    	findData = false;
		    	fatorProdutorio *= Math.pow((entrada.getValue()/100)+1, 1/252.0);
		    }
		    if(findData){
		    	fatorProdutorio *= Math.pow((entrada.getValue()/100)+1, 1/252.0);
		    }
		}
		
		return formatNumber(fatorProdutorio, 8, true);
	}
	
}
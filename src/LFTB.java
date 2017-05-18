import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.Map.Entry;

public class LFT extends Selic{

	double valorNominalAtualizado;
	Selic selic = new Selic();
	
	public LFT(Selic selic) {
		super();
		this.selic = selic;
	}
	
	private final Map<String, Double> valorNominal = new HashMap<String, Double>();
	
	public void registerValorNominal(double valorNominalBase, String data){
		double precisionValorNominal = formatNumber(valorNominalBase, 6, false);
		valorNominal.put(data, precisionValorNominal);
	}

	public void atualizarValorNominal(String dataBase, String dataFinal){
		Set<Entry<String, Double>> set = valorNominal.entrySet();
		Iterator<Entry<String, Double>> i = set.iterator();

		while(i.hasNext()) {
		    Map.Entry<String, Double> valores = (Map.Entry<String, Double>)i.next();
		    if(valores.getKey() == dataBase){
		    	double valorNominalA = valores.getValue()* selic.calcularFatorProdutorio(dataBase, dataFinal);
		    	setValorNominalAtualizado(formatNumber(valorNominalA, 6 , false));
		    }
		}
	}

	public double getValorNominalAtualizado() {
		return valorNominalAtualizado;
	}

	public void setValorNominalAtualizado(double valorNominalAtualizado) {
		this.valorNominalAtualizado = valorNominalAtualizado;
	}
	
}

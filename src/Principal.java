public class Principal {
	public static void main(String[] args){
		Selic selic = new Selic();		

		selic.registerTaxasSelic(1.20, "02/10/2010");
		selic.registerTaxasSelic(1.50, "03/10/2010");
		selic.registerTaxasSelic(1.70, "04/10/2010");
		selic.registerTaxasSelic(1.80, "05/10/2010");
		
		LFTB lftb = new LFTB(selic);
		
		lftb.registerValorNominal(2.012121, "02/10/2010");
		lftb.registerValorNominal(3.323434, "03/10/2010");
		lftb.registerValorNominal(4.123121, "04/10/2010");
		lftb.registerValorNominal(5.123123, "05/10/2010");
		
		double aux = selic.calcularFatorProdutorio("03/10/2010", "05/10/2010");
		System.out.println(aux);
		
		lftb.atualizarValorNominal("03/10/2010", "05/05/2010");
		
		double valorNA = lftb.getValorNominalAtualizado();
		System.out.println(valorNA);
		
		LFTA lfta = new LFTA(selic, 2.808082);
		lfta.atualizarValorNominal("02/10/2011", "03/12/2011", "01/01/2012", 10, 5);
		
		System.out.println(lfta.getvalorNominalAtualizado());
	}
}

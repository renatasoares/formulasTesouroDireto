import java.util.Locale;
import java.util.Scanner;

public class Principal {
	public static void main(String[] args){
		Scanner scanner = new Scanner(System.in);  
		scanner.useLocale(Locale.ENGLISH);
		
		while(true){
			System.out.println("Menu");
			System.out.println("1 - BTN");
			System.out.println("2 - LFT-A");
			System.out.println("3 - LFT-B");
			System.out.println("4 - LTN");
			System.out.println("5 - Sair");
			System.out.println("Digite a opção desejada: ");
			
			int opcao = scanner.nextInt();
						
			if(opcao == 1){
				System.out.println("Digite o parâmetro de atualização: ");
				double TR = scanner.nextDouble();
				
				System.out.println("Digite o preco unitario: ");
				double PU = scanner.nextDouble();
				
				System.out.println("Digite os juros: ");
				double juros = scanner.nextDouble();
				
				BTN btn = new BTN(TR, PU, juros);

				System.out.println("Atualizando o preco unitario...");
				btn.atualizarPU();
				System.out.printf("Preco unitário atualizado igual a %f\n", btn.getPrecoUnitario());
				
				System.out.println("Digite o número de meses para o cálculo do fator de juros:");
				int numeroMeses = scanner.nextInt();
				System.out.printf("Fator de juros igual a %f\n", btn.calculaFatorDeJuros(numeroMeses));
				System.out.printf("Juros igual a %s\n", btn.calculaJuros(numeroMeses));
				
				System.out.println("Digite a quantidade para o cálculo do principal");
				int quantidade = scanner.nextInt();
				btn.calculaPrincipal(quantidade);
				System.out.printf("Principal igual a %f\n", btn.getPrincipal());
							
			}			

			else if(opcao == 2){
				Selic selic = new Selic();
							
				selic.registerTaxasSelic(1.20, "02/10/2010");
				selic.registerTaxasSelic(1.50, "03/11/2010");
				selic.registerTaxasSelic(1.70, "04/12/2010");
				selic.registerTaxasSelic(1.80, "05/01/2010");
				selic.registerTaxasSelic(1.90, "06/02/2011");
				selic.registerTaxasSelic(1.61, "07/03/2011");
				selic.registerTaxasSelic(1.72, "08/10/2011");
				selic.registerTaxasSelic(1.83, "09/11/2011");
				selic.registerTaxasSelic(1.24, "10/10/2013");
				selic.registerTaxasSelic(1.52, "11/10/2013");
				selic.registerTaxasSelic(1.71, "12/10/2013");
				selic.registerTaxasSelic(1.12, "13/10/2013");
				
				System.out.println("Digite o valor nominal da emissão: ");
				double valorNominalEmissao = scanner.nextDouble();
				LFTA lfta = new LFTA(selic, valorNominalEmissao);
				
				System.out.println("Obs.: Taxas selic já cadastradas nas datas 02/10/2010,"
						+ "03/11/2010, 04/12/2010, 05/01/2010, 06/02/2011, 07/03/2011, 08/10/2011,"
						+  "09/11/2011, 10/10/2013, 11/10/2013, 12/10/2013 e 13/10/2013");
				System.out.println("Digite datas entre as apresentadas acima e exatamente neste formato");
				System.out.printf("\n");
				
				System.out.println("Digite a data de emissao: ");
				String dataEmissao = scanner.next();

				System.out.println("Digite a data da próxima atualização: ");
				String dataAtualizacao = scanner.next();
				
				System.out.println("Digite a data do pagamento: ");
				String dataPagamento = scanner.next();
				
				System.out.println("Digite o número de parcelas total: ");
				int numeroParcelas = scanner.nextInt();
				
				System.out.println("Digite o número de parcelas já armotizadas: ");
				int parcelasAmortizadas = scanner.nextInt();
				
				lfta.atualizarValorNominal(dataEmissao, dataAtualizacao, dataPagamento, numeroParcelas, parcelasAmortizadas);
				System.out.printf("Valor nominal atualizado igual a %s\n", lfta.getvalorNominalAtualizado());
				
			}
			else if(opcao == 3){
				Selic selic = new Selic();
				
				selic.registerTaxasSelic(1.20, "02/10/2010");
				selic.registerTaxasSelic(1.50, "03/11/2010");
				selic.registerTaxasSelic(1.70, "04/12/2010");
				selic.registerTaxasSelic(1.80, "05/01/2010");
				selic.registerTaxasSelic(1.90, "06/02/2011");
				selic.registerTaxasSelic(1.61, "07/03/2011");
				selic.registerTaxasSelic(1.72, "08/10/2011");
				selic.registerTaxasSelic(1.83, "09/11/2011");
				selic.registerTaxasSelic(1.24, "10/10/2013");
				selic.registerTaxasSelic(1.52, "11/10/2013");
				selic.registerTaxasSelic(1.71, "12/10/2013");
				selic.registerTaxasSelic(1.12, "13/10/2013");
				
				LFTB lftb = new LFTB(selic);
				
				lftb.registerValorNominal(2.012121, "02/10/2010");
				lftb.registerValorNominal(3.323434, "03/11/2010");
				lftb.registerValorNominal(4.123121, "04/12/2010");
				lftb.registerValorNominal(5.123123, "05/01/2010");
				lftb.registerValorNominal(1.902112, "06/02/2011");
				lftb.registerValorNominal(2.619823, "07/03/2011");
				lftb.registerValorNominal(3.712112, "08/10/2011");
				lftb.registerValorNominal(5.808163, "09/11/2011");
				lftb.registerValorNominal(5.212834, "10/10/2013");
				lftb.registerValorNominal(3.521212, "11/10/2013");
				lftb.registerValorNominal(1.771711, "12/10/2013");
				lftb.registerValorNominal(9.122232, "13/10/2013");
				
				System.out.println("Obs.: Taxas selic e valores nominais já cadastrados nas datas 02/10/2010,"
						+ "03/11/2010, 04/12/2010, 05/01/2010, 06/02/2011, 07/03/2011, 08/10/2011,"
						+  "09/11/2011, 10/10/2013, 11/10/2013, 12/10/2013 e 13/10/2013");
				System.out.println("Digite datas entre as apresentadas acima e exatamente neste formato");
				
				System.out.println("Digite a data base: ");
				String dataBase = scanner.next();
				
				System.out.println("Digite a data final: ");
				String dataFinal = scanner.next();

				lftb.atualizarValorNominal(dataBase, dataFinal);
				double valorNA = lftb.getValorNominalAtualizado();
				System.out.printf("O valor nominal atualizado é %f\n", valorNA);
				
			}
			else if(opcao == 4){
				System.out.println("Digite a taxa indicativa: ");
				double taxa = scanner.nextDouble();
				
				LTN ltn = new LTN(taxa);
				ltn.setPrecoUnitario();
				
				System.out.printf("O preço unitário atualizado é %f\n", ltn.getPrecoUnitario());
				
			}
			
			else if(opcao == 5){
				System.out.println("Saindo...");
				break;
			}
			
		}
		scanner.close();
	}
}

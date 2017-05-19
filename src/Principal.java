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
			System.out.println("6 - NTN-A3");
			System.out.println("7 - NTN-A6");
			System.out.println("8 - NTN-B");
			System.out.println("9 - Sair");
			System.out.println("Digite a opção desejada: ");
			
			int option = scanner.nextInt();
						
			if(option == 1){
				System.out.println("Digite o parâmetro de atualização: ");
				double updateParameter = scanner.nextDouble();
				
				System.out.println("Digite o preco unitario: ");
				double unitPrice = scanner.nextDouble();
				
				System.out.println("Digite os juros: ");
				double interest = scanner.nextDouble();
				
				BTN btn = new BTN(updateParameter, unitPrice, interest);

				System.out.println("Atualizando o preco unitario...");
				btn.updateUnitPrice();
				System.out.printf("Preco unitário atualizado igual a %f\n", btn.getUnitPrice());
				
				System.out.println("Digite o número de meses para o cálculo do fator de juros:");
				int months = scanner.nextInt();
				System.out.printf("Fator de juros igual a %f\n", btn.calculateInterestFactor(months));
				System.out.printf("Juros igual a %s\n", btn.calculateInterest(months));
				
				System.out.println("Digite a quantidade para o cálculo do principal");
				int quantity = scanner.nextInt();
				btn.calculatePrincipal(quantity);
				System.out.printf("Principal igual a %f\n", btn.getPrincipal());
							
			}			

			else if(option == 2){
				Selic selic = new Selic();
							
				selic.registerSelicTax(1.20, "02/10/2010");
				selic.registerSelicTax(1.50, "03/11/2010");
				selic.registerSelicTax(1.70, "04/12/2010");
				selic.registerSelicTax(1.80, "05/01/2010");
				selic.registerSelicTax(1.90, "06/02/2011");
				selic.registerSelicTax(1.61, "07/03/2011");
				selic.registerSelicTax(1.72, "08/10/2011");
				selic.registerSelicTax(1.83, "09/11/2011");
				selic.registerSelicTax(1.24, "10/10/2013");
				selic.registerSelicTax(1.52, "11/10/2013");
				selic.registerSelicTax(1.71, "12/10/2013");
				selic.registerSelicTax(1.12, "13/10/2013");
				
				System.out.println("Digite o valor nominal da emissão: ");
				double valorNominalEmissao = scanner.nextDouble();
				LFTA lfta = new LFTA(selic, valorNominalEmissao);
				
				System.out.println("Obs.: Taxas selic já cadastradas nas datas 02/10/2010,"
						+ "03/11/2010, 04/12/2010, 05/01/2010, 06/02/2011, 07/03/2011, 08/10/2011,"
						+  "09/11/2011, 10/10/2013, 11/10/2013, 12/10/2013 e 13/10/2013");
				System.out.println("Digite datas entre as apresentadas acima e exatamente neste formato");
				System.out.printf("\n");
				
				System.out.println("Digite a data de emissao: ");
				String emissionDate = scanner.next();

				System.out.println("Digite a data da próxima atualização: ");
				String updateDate = scanner.next();
				
				System.out.println("Digite a data do pagamento: ");
				String paymentDate = scanner.next();
				
				System.out.println("Digite o número de parcelas total: ");
				int numberOfPlots = scanner.nextInt();
				
				System.out.println("Digite o número de parcelas já armotizadas: ");
				int amortizedPlots = scanner.nextInt();
				
				lfta.updateNominalValue(emissionDate, updateDate, paymentDate, numberOfPlots, amortizedPlots);
				System.out.printf("Valor nominal atualizado igual a %s\n", lfta.getUpdatedNominalValue());
				
			}
			else if(option == 3){
				Selic selic = new Selic();
				
				selic.registerSelicTax(1.20, "02/10/2010");
				selic.registerSelicTax(1.50, "03/11/2010");
				selic.registerSelicTax(1.70, "04/12/2010");
				selic.registerSelicTax(1.80, "05/01/2010");
				selic.registerSelicTax(1.90, "06/02/2011");
				selic.registerSelicTax(1.61, "07/03/2011");
				selic.registerSelicTax(1.72, "08/10/2011");
				selic.registerSelicTax(1.83, "09/11/2011");
				selic.registerSelicTax(1.24, "10/10/2013");
				selic.registerSelicTax(1.52, "11/10/2013");
				selic.registerSelicTax(1.71, "12/10/2013");
				selic.registerSelicTax(1.12, "13/10/2013");
				
				LFTB lftb = new LFTB(selic);
				
				lftb.registerNominalValue(2.012121, "02/10/2010");
				lftb.registerNominalValue(3.323434, "03/11/2010");
				lftb.registerNominalValue(4.123121, "04/12/2010");
				lftb.registerNominalValue(5.123123, "05/01/2010");
				lftb.registerNominalValue(1.902112, "06/02/2011");
				lftb.registerNominalValue(2.619823, "07/03/2011");
				lftb.registerNominalValue(3.712112, "08/10/2011");
				lftb.registerNominalValue(5.808163, "09/11/2011");
				lftb.registerNominalValue(5.212834, "10/10/2013");
				lftb.registerNominalValue(3.521212, "11/10/2013");
				lftb.registerNominalValue(1.771711, "12/10/2013");
				lftb.registerNominalValue(9.122232, "13/10/2013");
				
				System.out.println("Obs.: Taxas selic e valores nominais já cadastrados nas datas 02/10/2010,"
						+ "03/11/2010, 04/12/2010, 05/01/2010, 06/02/2011, 07/03/2011, 08/10/2011,"
						+  "09/11/2011, 10/10/2013, 11/10/2013, 12/10/2013 e 13/10/2013");
				System.out.println("Digite datas entre as apresentadas acima e exatamente neste formato");
				
				System.out.println("Digite a data base: ");
				String baseDate = scanner.next();
				
				System.out.println("Digite a data final: ");
				String finalDate = scanner.next();

				lftb.updateNominalValue(baseDate, finalDate);
				double nominalValue = lftb.getUpdatedNominalValue();
				System.out.printf("O valor nominal atualizado é %f\n", nominalValue);
				
			}
			else if(option == 4){
				System.out.println("Digite a taxa indicativa: ");
				double tax = scanner.nextDouble();
				
				LTN ltn = new LTN(tax);
				ltn.setUnitPrice();
				
				System.out.printf("O preço unitário atualizado é %f\n", ltn.getUnitPrice());
				
			} else if (option == 5) {
				NTNA1 ntnA1 = new NTNA1();

				System.out.println(
						"Digite a cotação do dólar útil anterior à data de atualização, pagamento ou vencimento: ");
				double quotationDolarA = scanner.nextDouble();
				System.out.println("Digite a cotação do dólar do dia útil anterior à data base ou de emissão: ");
				double quotationDolarB = scanner.nextDouble();
				System.out.println("Digite o valor de emissão do título: ");
				double emissionValue = scanner.nextDouble();
				System.out.println("Digite o percentual de amortização (sem o '%'): ");
				double amortizationPercentege = scanner.nextDouble();

				ntnA1.calculatePU(quotationDolarA, quotationDolarB, emissionValue, amortizationPercentege);
				System.out.printf("O preço unitário de amortização é %f\n", ntnA1.getPUAmortization());

				System.out.println("Digite a data referente ao pagamento do título atual: ");
				String dtp = scanner.next();
				System.out.println("Digite a data referente ao último pagamento do título: ");
				String dtup = scanner.next();
				System.out.println("Digite a taxa de juros em porcentagem ao ano (sem o '%'): ");
				double rate = scanner.nextDouble();

				double interest = ntnA1.calculateInterest(dtp, dtup, rate);
				System.out.printf("O valor unitário do juros é de %f\n", interest);

			} else if (option == 6) {
				NTNA3 ntnA3 = new NTNA3();

				System.out.println(
						"Digite a cotação do dólar útil anterior à data de atualização, pagamento ou vencimento: ");
				double quotationDolarA = scanner.nextDouble();
				System.out.println("Digite a cotação do dólar do dia útil anterior à data base ou de emissão: ");
				double quotationDolarB = scanner.nextDouble();

				ntnA3.calculateNominalValue(quotationDolarA, quotationDolarB);
				System.out.printf("O valor nominal é de %f\n", ntnA3.getNominalValue());

				System.out.println("Digite a taxa de juros em porcentagem ao ano (sem o '%'): ");
				double rate = scanner.nextDouble();
				System.out.println("Digite o número de meses referente ao período de pagamento de juros: ");
				int n = scanner.nextInt();

				double interest = ntnA3.calculateInterest(rate, n);
				System.out.printf("O valor unitário do juros é de %f\n", interest);
			} else if (option == 7) {
				NTNA6 ntnA6 = new NTNA6();

				System.out.println(
						"Digite a cotação do dólar útil anterior à data de atualização, pagamento ou vencimento: ");
				double quotationDolarA = scanner.nextDouble();
				System.out.println("Digite a cotação do dólar do dia útil anterior à data base ou de emissão: ");
				double quotationDolarB = scanner.nextDouble();
				System.out.println("Digite o valor de emissão do título: ");
				double emissionValue = scanner.nextDouble();

				ntnA6.calculateNominalValueUpdated(quotationDolarA, quotationDolarB, emissionValue);
				System.out.printf("O valor nominal atualizado é de %f\n", ntnA6.getNominalValueUpdated());

				System.out.println("Digite a data referente ao pagamento do título: ");
				String dtp = scanner.next();
				System.out.println("Digite a data referente ao último pagamento do título: ");
				String dtup = scanner.next();
				System.out.println("Digite a taxa de juros em porcentagem ao ano (sem o '%'): ");
				double rate = scanner.nextDouble();

				double interest = ntnA6.calculateInterest(dtp, dtup, rate);
				System.out.printf("O valor unitário do juros é de %f\n", interest);
				
			} else if (option == 8) {
				NTNB ntnb = new NTNB();

				System.out.println("Digite o índice de preços ao consumidor amplo do mês anterior ao de atualização: ");
				double ipcat1 = scanner.nextDouble();
				System.out.println(
						"Digite o índice de preços ao consumidor amplo do mês anterior ao de data-base ou emissão: ");
				double ipcat0 = scanner.nextDouble();
				System.out.println(
						"Digite número de dias corridos, entre o décimo quinto dia do mês da emissão (inclusive) até o dia para o qual se deseja realizar o ajuste ");
				int dc = scanner.nextInt();
				System.out.println("Digite o  número de dias corridos correspondentes entre o décimo quinto dia do\n"
						+ "mês da emissão (inclusive) até o décimo quinto dia do mês subsequente ao da emissão");
				int dct = scanner.nextInt();
				System.out.println("Digite índice de preços ao consumidor amplo (IPCA) do mês de emissão: ");
				double ipcatA = scanner.nextDouble();
				System.out.println("Digite índice de preços ao consumidor amplo (IPCA) ao de data-base ou emissão: ");
				double ipcatB = scanner.nextDouble();
				System.out.println("Digite o valor nominal de emissão do título: ");
				double vn = scanner.nextDouble();

				ntnb.calculateNominalValueUpdated(ipcat1, ipcat0, dc, dct, ipcatA, ipcatB, vn);
				System.out.printf("O valor nominal atualizado é de %f\n", ntnb.getNominalValueUpdated());

				System.out.println("Digite a taxa de juros em porcentagem ao ano (sem o '%'): ");
				double rate = scanner.nextDouble();
				System.out.println("Digite o número de meses referente ao período de pagamento de juros: ");
				int n = scanner.nextInt();
				System.out.println("Digite o número de dias corridos contados desde a data de emissão,\n"
						+ "incorporação ou último pagamento de juros, se houver, até a data de\n"
						+ "atualização, pagamento ou vencimento ");
				int dcp = scanner.nextInt();
				System.out.println("Digite o número de dias corridos contados desde a data de emissão,\n"
						+ "incorporação ou último pagamento de juros, se houver, até a data do\n"
						+ "próximo pagamento ou vencimento ");
				int dctJ = scanner.nextInt();

				double interest = ntnb.calculateInterest(rate, n, dcp, dctJ);
				System.out.printf("O valor unitário do juros é de %f\n", interest);
				
			} else if (option == 9) {
				System.out.println("Saindo...");
				break;
			}
		}
		scanner.close();
	}
}

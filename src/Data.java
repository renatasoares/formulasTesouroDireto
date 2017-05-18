
public class Data {
	
	public int formataData(String dataInicial, String dataFinal){
	  String data1[] = dataInicial.split("/");
	  int diaInicial = Integer.parseInt(data1[0]); 
	  int mesInicial = Integer.parseInt(data1[1]);
	  int anoInicial = Integer.parseInt(data1[2]); 
	  int segundosDataInicial = diaInicial*24 + (mesInicial-1)*24*30 + (anoInicial -1)*24*360;
  
	  String data2[] = dataFinal.split("/");
	  int diaFinal = Integer.parseInt(data2[0]); 
	  int mesFinal = Integer.parseInt(data2[1]);
	  int anoFinal = Integer.parseInt(data2[2]); 
	  int segundosDataFinal = diaFinal*24 + (mesFinal-1)*24*30 + (anoFinal -1)*24*360;

	  int diferencaDias = (segundosDataFinal - segundosDataInicial)/24; 
	  System.out.println(diferencaDias);
	  return diferencaDias;
	}  
}

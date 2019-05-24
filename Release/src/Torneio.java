import java.util.Random;

public class Torneio {
	public static int[] torneio(int tamPop, int taxaCruzamento, int[] score) {
		Random r = new Random();
		int[] x = new int[tamPop];
		int[] x3 = new int[tamPop];
		int a=0, b=0, c=tamPop-1;
			
		x=aleatorio(tamPop);
			
		do {
				int n1=x[a]-1;
				a++;
				int n2=x[a]-1;
				a++;
				if(score[n1]>score[n2]){
					x3[b]=n1;
					b++;
					x3[c]=n1;
					c--;
				}else {
					x3[b]=n2;
					b++;
					x3[c]=n2;
					c--;
				}
		}while(a<tamPop);
		
		return x3;
	}
	
	public static int[] aleatorio(int d) {
	    Random random = new Random();
	    int[] repetir = new int[d];
	    for (int i = 0; i < repetir.length; i++) {
	        boolean novoNumero = false;
	        int numero = 0;
	        while (!novoNumero) {
	            numero = random.nextInt(d+1); 
	            novoNumero = verificar(numero, repetir);
	        }
	        repetir[i] = numero;
	    }
	    return repetir;
	}
	
	private static boolean verificar(int numero, int[] lista) {
	    for (int i = 0; i < lista.length; i++) {
	        if (numero == lista[i]) {
	            return false;
	        }
	    }
	    return true;
	}
	
	
}

import java.util.Random;

public class Solucao {

	public static void main(String[] args) {
		int k=3, M=3, P=3; 
		int tamPop=100, geracao=200, tamIndividuo=10, custoMax=125;
		int taxaCruzamento=80, taxaMut=1;
		
		int custo[] = {60,40,40,30,20,20,25,70,50,20};
		
		int[] score= new int[tamPop];
		int[][] populacao = new int[tamPop][tamIndividuo];
		int[] selecao = new int[tamPop];
		
		
		Aptidao pop = new Aptidao();
		Torneio tor = new Torneio();
		OrdenaPopulacao ord = new OrdenaPopulacao();

		populacao=popInicial(tamPop,tamIndividuo,k,custoMax, custo);
		
		int a=1;

		do {
			score=pop.aptidao(populacao, M, k, P);
			ord.ordena(score, populacao);

			selecao=tor.torneio(tamPop, taxaCruzamento, score);
			populacao =cruzamento(populacao, selecao, taxaCruzamento);

			populacao=reparo(populacao, custoMax, custo);
			
			populacao=mutacao(populacao, taxaMut, k, custoMax, custo);
			populacao=reparo(populacao, custoMax, custo);
			

			a++;

		}while(a<=geracao);
		
		for(int j=0; j<tamIndividuo; j++) {
			System.out.printf("%d|", populacao[0][j]);
		}
		System.out.printf("\tScore: %d\n", score[0]);
	}
	
	public static int[] individuo(int n, int k, int[] custo) {
		int x[] = new int[n];
		int aux1=0, aux2=0, aux3=0;
		for(int i=0;i<n;i++) {
			x[i]=(int)(Math.random()*(k+1));
			switch (x[i]) {
				case 1:
					aux1=aux1+custo[i];
					if(aux1 > 125) {
						x[i]=0;
					}
					break;
				case 2:
					aux2=aux2+custo[i];
					if(aux2 > 125) {
						x[i]=0;
					}
					break;
				case 3:
					aux3=aux3+custo[i];
					if(aux3 > 125) {
						x[i]=0;
					}
					break;
			}
		}
		return x;
	}
	
		public static int[][] popInicial(int tamPop, int tamIndividuo, int k, int custoMax, int[] custo){
		int popInicial[][] = new int[tamPop][tamIndividuo];
		for(int i=0; i<tamPop; i++) {
			int[] x=individuo(tamIndividuo,k, custo);
			int aux=0;
			for(int j=0; j<tamIndividuo; j++) {
				popInicial[i][j]=x[j];
				aux=popInicial[i][j]*custo[j];
				if(aux>custoMax) {
					popInicial[i][j]=0;
				}
			}
		}
		return popInicial;
	}
	public static int[][] cruzamento(int[][] populacao, int[] selecao, int taxaCruzamento) {
		int a=0, aux, n=1, m1, m2; 
		int taxa;
		taxa=(80*populacao.length)/100;
		
		while(a<taxa) {
			m1=(selecao[a]);
			m2=(selecao[a+1]);
			
			n=(int)(1+Math.random()*(populacao[0].length));
			
			for(int i=0; i<populacao[0].length; i++) {
				if(i>=n) {
					aux=populacao[m1][i];
					populacao[m1][i]=populacao[m2][i];
					populacao[m2][i]=aux;
				}
			}
			a=a+2;
		}
		
		return populacao;
		
	}
	
	public static int[][] reparo(int[][] populacao, int custoMax, int[] custo){
		for(int i=0; i<populacao.length;i++) {
			int aux1=0, aux2=0, aux3=0;
			for(int j=0; j<populacao[0].length;j++) {
				switch(populacao[i][j]) {
				case 1:
					aux1=aux1+custo[j];
					if(aux1 > 125) {
						populacao[i][j]=0;
					}
					break;
				case 2:
					aux2=aux2+custo[j];
					if(aux2 > 125) {
						populacao[i][j]=0;
					}
					break;
				case 3:
					aux3=aux3+custo[j];
					if(aux3 > 125) {
						populacao[i][j]=0;
					}
					break;
				}
			}
		}

		return populacao;
	}
	
	public static int[][] mutacao(int[][] populacao,int taxaMut, int k, int custoMax, int[] custo){
		Random r = new Random();
		
		float mutacao=taxaMut/100;
		
		for(int i=0; i<populacao.length;i++) {
			float n=r.nextFloat();
			if(mutacao>n){
				int mutLocal=(int)(Math.random()*(populacao[0].length));
				
				for(int j=0; j<populacao[0].length;j++) {
					if(j==mutLocal) {
						int mutar=(int)(Math.random()*(k+1));
						populacao[i][j]=mutar;
					}
				}
			}
		}
		return populacao;
	}

}

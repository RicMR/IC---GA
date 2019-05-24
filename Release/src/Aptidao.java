
public class Aptidao {
	public static int[] aptidao(int[][] populacao, int M, int k, int P) {
		int[] score = new int[populacao.length];
		int[][] x=new int[populacao.length][populacao[0].length];
		int[][] y= new int[populacao.length][populacao[0].length];
		
		for(int i=0; i<populacao.length;i++) {
			for(int j=0;j<populacao[0].length;j++) {

				x[i][j]=populacao[i][j];

				if(x[i][j]==0) {
					y[i][j]=0;
				}else {
					y[i][j]=1;
				}
			}
		}

		for(int i=0;i<populacao.length;i++) {
			int[] importancia=imp(M,populacao[0].length);
			int[] r=risco(populacao[0].length);
			score[i]=0;

			for(int j=0;j<populacao[0].length;j++) {
				score[i]=(((importancia[j]*(P-x[i][j]+1)-r[j]*x[i][j])*y[i][j])+score[i]);
			}
		}
		return score;
	}
	
	public static int[] risco(int tamInd){
		int risco[] = {3,6,2,6,4,8,9,7,6,6};
		return risco;
	}
	
	public static int[] imp(int M, int tamInd) {
		int j, i, aux;

		int w[] = {3,4,2};

		int V[][]= {{10,8,6,5,7,8,6,9,6,10},{10,10,4,9,7,6,6,8,7,10},{5,6,8,1,5,2,4,3,5,7}};
		
		int importancia[]=new int[tamInd];

		for(i=0;i<tamInd;i++) {
			aux=0;
			for(j=0;j<M;j++){
				aux=((V[j][i]*w[j])+aux);
			}
			importancia[i]=aux;
		}
		return importancia;	
	}


}
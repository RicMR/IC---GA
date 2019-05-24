
public class OrdenaPopulacao {
	public static void ordena(int[] score, int[][] pop) {
		int aux1, aux2;
		for(int i=0; i<(score.length);i++) {
			for(int j=0; j<((score.length)-1);j++) {
				if(score[j]<score[j+1]) {
					aux1=score[j];
					score[j]=score[j+1];
					score[j+1]=aux1;
					for(int a=0; a>pop[0].length;a++) {
						aux2=pop[j][a];
						pop[j][a]=pop[j+1][a];
						pop[j+1][a]=aux2;
					}
				}
			}
		}
		System.out.printf("\nPopulacao ordenada:");

		for(int i=0; i<pop[0].length; i++) {
			System.out.printf("%d", pop[0][i]);
		}
		System.out.printf("\nScore: %d\n", score[0]);
			System.out.printf("\n");


	}
}

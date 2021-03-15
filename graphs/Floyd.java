import java.util.Scanner;

//Oryol Margarita
//Algorithm Floyda
//Task A

public class Floyd {
	public static void main(String[] args) {

		int INF = Integer.MAX_VALUE/2;
		
		Scanner sc = new Scanner(System.in);

		int vertex = sc.nextInt();
		int s = sc.nextInt() - 1;
		int t = sc.nextInt() - 1;

		int[][] d = new int[vertex][vertex];

		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				d[i][j] = sc.nextInt();
				if(d[i][j] == -1) d[i][j] = INF;
			}
		}
		
		for (int k = 0; k < vertex; k++) {
			for (int i = 0; i < vertex; i++) {
				for (int j = 0; j < vertex; j++) {
					if (d[i][j] > d[i][k] + d[k][j])
						d[i][j] = Math.min(d[i][j], d[i][k] + d[k][j]);
						//next[i][j] = next[i][k];
				}
			}
		}

		if(d[s][t] == INF) System.out.print(-1);
		else System.out.print(d[s][t]);

	}
}

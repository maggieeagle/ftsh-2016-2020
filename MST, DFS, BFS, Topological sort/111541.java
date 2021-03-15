//Oryol_Margarita
//DFS
//informatics 111541

import java.util.Scanner;

public class B {
	static int V;
	static int[][] edges;

	static int[] used;

	static int count2 = 0;

	public static void dfs(int num) {
		used[num] = 1;
		count2++;
		for (int i = 0; i < V; i++) {
			if (used[i] == 0 && edges[num][i] == 1) {
				dfs(i);
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // number of vertex
		//E = sc.nextInt(); // number of edges
		used = new int[V];

		 edges = new int[V][V];
		 
	        for (int i = 0; i < V; i++) {
	            for (int j = 0; j < V; j++) {
	                edges[i][j] = sc.nextInt();
	            }
	        }

		dfs(0);

		int count = 0;
		 for (int i = 0; i < V; i++) {
	            for (int j = 0; j < i+1; j++) {
	                count+=edges[i][j];
	            }
	        }
		
		if(count2 == V && count == V-1) System.out.print("YES");
		else System.out.print("NO");
		
		sc.close();
	}
}

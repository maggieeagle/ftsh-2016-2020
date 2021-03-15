//Oryol_Margarita
//DFS

import java.util.Scanner;

public class Dfs_algorithm {
	static int V;
	static int E;
	static int[][] edges;

	static int[] used;

	public static void dfs(int num) {
		used[num] = 1;
		for (int i = 0; i < E; i++) {
			if (edges[i][0] == num) {
				if (used[edges[i][1]] == 0)
					dfs(edges[i][1]);
			}
			if (edges[i][1] == num) {
				if (used[edges[i][0]] == 0)
					dfs(edges[i][0]);
			}
		}
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		V = sc.nextInt(); // number of vertex
		E = sc.nextInt(); // number of edges

		edges = new int[E][2];
		used = new int[V];

		for (int i = 0; i < E; i++) {
			edges[i][0] = sc.nextInt();
			edges[i][1] = sc.nextInt();
		}

		dfs(0);

		for (int i = 0; i < used.length; i++) {
			if (used[i] == 1)
				System.out.print(i + " ");
		}

		sc.close();
	}
}
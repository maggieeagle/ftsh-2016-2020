import java.util.ArrayList;
import java.util.Scanner;

//Oryol Margarita
//The shortest way
//informatics 160

public class S {
	public static void main(String[] args) {

		int INF = Integer.MAX_VALUE / 2;

		Scanner sc = new Scanner(System.in);

		int vertex = sc.nextInt();

		int[][] d = new int[vertex][vertex];

		int distance[] = new int[vertex];
		boolean[] used = new boolean[vertex];
		int[] p = new int[vertex];

		for (int i = 0; i < vertex; i++) {
			for (int j = 0; j < vertex; j++) {
				d[i][j] = sc.nextInt();
				if (d[i][j] == 0)
					d[i][j] = INF;
			}
		}

		int start = sc.nextInt() - 1;
		int finish = sc.nextInt() - 1;

		for (int i = 0; i < vertex; i++) {
			if (i == start)
				distance[i] = 0;
			else
				distance[i] = INF;
			used[i] = false;
		}

		/*
		 * for(int j = 0; j < vertex-1;j++) { int min = INF; for(int i = 0; i < vertex;
		 * i++) { if(visited[i]==false && distance[i]<=min) { min = distance[i];
		 * 
		 * } } }
		 */

		while (true) {
			int v = -1;
			for (int i = 0; i < vertex; i++) {
				if (used[i] == false && distance[i] < INF && (v == -1 || distance[v] > distance[i])) {
					v = i;
				}
			}
			if (v == -1)
				break;
			used[v] = true;
			for (int i = 0; i < vertex; i++) {
				if (used[i] == false && d[v][i] <= INF) {
					if (distance[v] + d[v][i] < distance[i]) {
						distance[i] = distance[v] + d[v][i];
						p[i] = v;
					}
					// distance[i] = Math.min(distance[i], distance[v] + d[v][i]);

				}
			}
		}

		/*
		 * for(int i = 0; i < vertex; i++) { int min = INF; int v = -1; for(int j = 0; j
		 * < vertex; j++) { if(used[j] == false && distance[j] < min) { v = i; min =
		 * d[i][j]; } }
		 * 
		 * }
		 */

		ArrayList<Integer> way = new ArrayList<>();

		if (distance[finish] < INF) {
			if (distance[finish] != 0) {
				System.out.println(distance[finish]);
				int i = finish;
				way.add(finish);
				while (i != start) {
					way.add(p[i]);
					i = p[i];
				}

				for (int j = way.size() - 1; j >= 0; j--) {
					System.out.print(way.get(j) + 1 + " ");
				}
			}
			else System.out.println(0);
		} else
			System.out.print(-1);

	}
}

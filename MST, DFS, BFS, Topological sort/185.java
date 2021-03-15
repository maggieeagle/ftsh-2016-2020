//Oryol Margarita
//22.01.2019
// kruskal's algorithm

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class kruskals_algorithm {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int M = sc.nextInt();
		int N = sc.nextInt();

		int[][] edges = new int[N][3];

		for (int i = 0; i < N; i++) {
				edges[i][0] = sc.nextInt() - 1;
				edges[i][1] = sc.nextInt() - 1;
				edges[i][2] = sc.nextInt();
		}

		//Arrays.sort(edges, Comparator.comparingInt(arr -> arr[2]));
		
		Arrays.sort(edges, new Comparator<int[]>() {
		public int compare(int[] o1, int[] o2) {
			return Integer.compare(o1[2], o2[2]);
		}
		});
		
		int[] color = new int[M];

		for (int i = 0; i < M; i++)
			color[i] = i;
		
		int sum = 0;
		
		for (int i = 0; i < N; i++) {
			if (color[edges[i][0]] != color[edges[i][1]]) {
				int col = color[edges[i][0]];
				for (int j = 0; j < M; j++) {
					if (color[j] == col) {
						color[j] = color[edges[i][1]];
					}
				}
				sum+=edges[i][2];
			}
		}

		System.out.print(sum);
	}

}

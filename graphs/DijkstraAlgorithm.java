import java.util.ArrayList;
import java.util.Scanner;

//Oryol Margarita
//DijkstraAlgorithm

public class DijkstraAlgorithm {
	
	static Scanner sc = new Scanner(System.in);
	
	static int n; // vertex
	static int m; // edges
	static ArrayList<Integer>[] arr; // список смежности
	// static ArrayList<Integer> weight[]; //вес ребра в орграфе
	static int used[];
	static int dist[]; // distant for start vertex
	int start; // start vertex

	/*public static void dejkstra(int s) {
		dist[s] = 0; // distant for start vertex is 0
		for (int j = 0; j < n; j++) {
			int v = -1;
			int pred_dist = Integer.MAX_VALUE;
			for (int i = 0; i < n; i++) {
				if (used[i] == 0 && dist[i] < pred_dist) {
					v = i;
					pred_dist = dist[i];
				}
			}
			for (int i = 0; i < arr[v].size(); i++) {
				int u = arr[v].get(i);
				int weightU = weight[v].get(i);
				if (dist[v] + weightU < dist[u]) {
					dist[u] = dist[v] + weightU;
				}
			}
			used[v] = 1;
		}
	}*/

	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
	/*public static ArrayList<Integer>[] read(int vertex_num) { // читаем список смежности (на вход - кол-во вершин)
		ArrayList<Integer>[] brr = new ArrayList[vertex_num];
		
		for(int i = 0; i < n; i++) {
			String string = sc.nextLine();
			String[] strarr = string.split(" ");
		        for (int iter = 0; iter < strarr.length; iter++) {
		            brr[i].add(Integer.parseInt(strarr[i]));
		        }

		}

		return brr;
	}*/
	//!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!

	public static void main(String[] args) {

		int n = sc.nextInt();
		
		arr = new ArrayList[n];
		
		for(int i = 0; i < n; i++) {
			String string = sc.nextLine();
			String[] strarr = string.split(" ");
		        for (int iter = 0; iter < strarr.length; iter++) {
		            arr[i].add(Integer.parseInt(strarr[i]));
		        }

		}
		
		for(int i = 0; i < n; i++) {
		        for (int j = 0; j < arr[i].size(); j++) {
		        	System.out.print(arr[i].get(j));
		        }
		        System.out.println();
		}
		
	}
}

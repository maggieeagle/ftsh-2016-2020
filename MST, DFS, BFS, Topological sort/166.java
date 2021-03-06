//Oryol Margarita
//informatics 166

public class A {

	static int N;
	static int[] color;
	//static String[] color;
	static boolean flag =false;
	static Stack<Integer> answer = new Stack<Integer>();
	static LinkedList<Integer>[] edges;
	
	static void dfs(int vertex) {
		if(color[vertex] == 2) return;
		if(color[vertex] == 1) {
			flag = true;
			return;
		}
		if(color[vertex] == 0) {
			color[vertex] = 1;
			
			for(int i = 0; i < edges[vertex].size(); i++) {
				dfs(edges[vertex].get(i));
			}
			
			color[vertex] = 2;
			answer.push(vertex);
		}
	}

	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		
		edges = new LinkedList[N];
		for (int i = 0; i < edges.length; i++)
            edges[i] = new LinkedList();
		
		color = new int[N];

		for (int i = 0; i < M; i++) {
			int v = sc.nextInt() - 1;
			int u = sc.nextInt() - 1;
			edges[v].add(u);
		}
		
		for(int i = 0; i < N; i++) dfs(i);
			if (flag == true)System.out.print("No");
			else {
				System.out.println("Yes");
				
				/*for(int i = 0; i < answer.size(); i++) {
					System.out.print((int)answer.pop() + 1 + " ");
				}*/
				while (answer.size() > 0)
	                System.out.print((int)answer.pop() + 1 + " ");
			}
	}
}

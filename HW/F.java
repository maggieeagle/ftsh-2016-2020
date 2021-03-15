import java.util.Scanner;

//Oryol_Margarita
//F

public class F {
	static int[][] a;
	static int[][] best_split;
	static char[] string;

	public static void answer(int i, int j) {
		if (a[i][j] == j - i + 1)
			return;
		
		/*if (a[i][j] == 0) {
			for (int k = i; k < j + 1; k++) {
				System.out.print(a[k]);
				return;
			}
		}*/
		
		if(best_split[i][j]==-1) {
			System.out.print(string[i]);
			answer(i+1, j-1);
			System.out.print(string[j]);
			return;
		}
		answer(i, best_split[i][j]);
		answer(best_split[i][j] + 1, j);
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		String str = sc.next();

		sc.close();

		int string_length = str.length();

		string = new char[string_length];

		for (int i = 0; i < string_length; i++)
			string[i] = str.charAt(i);

		a = new int[string_length][string_length];
		best_split = new int[string_length][string_length];

		for (int i = 0; i < string_length; i++) {
			a[i][i] = 1;
		}

		for (int j = 0; j < string_length; j++) {
			for (int i = j - 1; i >= 0; i--) {
				int n = 1000000; // best number of deleted brackets
				int split = -1; // best string split
				if (string[i] == '(' && string[j] == ')' || string[i] == '[' && string[j] == ']'
						|| string[i] == '{' && string[j] == '}')
					n = a[i + 1][j - 1];
				for (int k = i; k < j; k++) {
					if (a[i][k] + a[k + 1][j] < n) {
						n = a[i][k] + a[k + 1][j];
						split = k;
					}
				}
				a[i][j] = n;
				best_split[i][j] = split;
				// System.out.println(n);
			}
		}

		/*
		 * for(int i = 0; i < string_length; i++) { for(int j = 0; j < string_length;
		 * j++) { System.out.print(a[i][j] + " "); } System.out.println(); }
		 */
		//System.out.println(a[0][string_length - 1]);
		answer(0, string_length - 1);

	}
}

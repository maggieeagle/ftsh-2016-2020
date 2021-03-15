import java.util.Scanner;

//Oryol Margarita
//C

public class C {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int k = sc.nextInt(); // number of colors

		char[] colors = new char[k]; // colors
		int[] prices = new int[k]; // prices of each color

		for (int i = 0; i < k; i++) {
			colors[i] = sc.next().charAt(0);
			prices[i] = sc.nextInt();
		}

		String str = sc.nextLine();

		char[] line = new char[str.length()]; // start line

		for (int i = 0; i < str.length(); i++)
			line[i] = str.charAt(i);

		int n = sc.nextInt(); // number of sequences

		String[] subsequences = new String[n];

		for (int i = 0; i < n; i++)
			subsequences[i] = sc.next();

		int[][] a = new int[line.length][line.length]; // can we take all the chips from l to r without take any of another chips?
		int[][] b = new int[line.length][line.length]; // max of gold we can take from line [l,r]
		int[][][][] c = new int[line.length][line.length][n][150];

		for (int l = 0; l < line.length - 1; l++) {
			for (int r = l; r < line.length; r++) {
				for (k = l; k < r + 1; k++) {
					if (a[l][k] == 1 && a[k + 1][r] == 1)
						a[l][r] = 1; // we can...
				}
			}
		}

		for (int l = 0; l < line.length - 1; l++) {
			for (int r = l; r < line.length; r++) {
				//if(a[l][r]==0)
			}
		}

	}
}

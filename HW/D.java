import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//Oryol Margarita
//D

public class D {

	// static int[] arr;

	static double[][] max;
	static double[][] min;

	static int[][] sp_max;
	static int[][] sp_min;

	static String[][] s_max;
	static String[][] s_min;

	static int r_max[][];
	static int r_min[][];
	static int l_max[][];
	static int l_min[][];

	static ArrayList<Character> znaks = new ArrayList<Character>();
	static ArrayList<Double> nums = new ArrayList<Double>();

	public static void find_max(int n) {

		for (int i = 0; i < n; i++) { // start conditions
			max[i][i] = nums.get(i);
		}

		for (int l = 0; l < n; l++) { // take different pieces
			for (int i = 0; i < n - l; i++) {

				int j = i + l;

				for (int k = i; k < j; k++) { // run through the piece

					// let's find all parameters for maximum:

					// left - max, right - max

					if (max[i][j] < max[i][k] + max[k + 1][j] && znaks.get(k) == '+') {

						max[i][j] = max[i][k] + max[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "+";
						r_max[i][j] = 1;
						l_max[i][j] = 1;
					}

					if (max[i][j] < max[i][k] - max[k + 1][j] && znaks.get(k) == '-') {

						max[i][j] = max[i][k] - max[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "-";
						r_max[i][j] = 1;
						l_max[i][j] = 1;
					}

					if (max[i][j] < max[i][k] * max[k + 1][j] && znaks.get(k) == '*') {

						max[i][j] = max[i][k] * max[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "*";
						r_max[i][j] = 1;
						l_max[i][j] = 1;
					}

					// left - max, right - min

					if (max[i][j] < max[i][k] + min[k + 1][j] && znaks.get(k) == '+') {

						max[i][j] = max[i][k] + min[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "+";
						r_max[i][j] = 0;
						l_max[i][j] = 1;
					}

					if (max[i][j] < max[i][k] - min[k + 1][j] && znaks.get(k) == '-') {

						max[i][j] = max[i][k] - min[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "-";
						r_max[i][j] = 0;
						l_max[i][j] = 1;
					}

					if (max[i][j] < max[i][k] * min[k + 1][j] && znaks.get(k) == '*') {

						max[i][j] = max[i][k] * min[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "*";
						r_max[i][j] = 0;
						l_max[i][j] = 1;
					}

					// left_min, right- max

					if (max[i][j] < min[i][k] + max[k + 1][j] && znaks.get(k) == '+') {

						max[i][j] = min[i][k] + max[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "+";
						r_max[i][j] = 1;
						l_max[i][j] = 0;
					}

					if (max[i][j] < min[i][k] - max[k + 1][j] && znaks.get(k) == '-') {

						max[i][j] = min[i][k] - max[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "-";
						r_max[i][j] = 1;
						l_max[i][j] = 0;
					}

					if (max[i][j] < min[i][k] * max[k + 1][j] && znaks.get(k) == '*') {

						max[i][j] = min[i][k] * max[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "*";
						r_max[i][j] = 1;
						l_max[i][j] = 0;
					}

					// left - min, right - min

					if (max[i][j] < min[i][k] + min[k + 1][j] && znaks.get(k) == '+') {

						max[i][j] = min[i][k] + min[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "+";
						r_max[i][j] = 0;
						l_max[i][j] = 0;
					}

					if (max[i][j] < min[i][k] - min[k + 1][j] && znaks.get(k) == '-') {

						max[i][j] = min[i][k] - min[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "-";
						r_max[i][j] = 0;
						l_max[i][j] = 0;
					}

					if (max[i][j] < min[i][k] * min[k + 1][j] && znaks.get(k) == '*') {

						max[i][j] = min[i][k] * min[k + 1][j];
						sp_max[i][j] = k;
						s_max[i][j] = "*";
						r_max[i][j] = 0;
						l_max[i][j] = 0;
					}

					// for minimum:

					// left - max, right - max

					if (min[i][j] > max[i][k] + max[k + 1][j] && znaks.get(k) == '+') {

						min[i][j] = max[i][k] + max[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "+";
						r_min[i][j] = 1;
						l_min[i][j] = 1;
					}

					if (min[i][j] > max[i][k] - max[k + 1][j] && znaks.get(k) == '-') {

						min[i][j] = max[i][k] - max[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "-";
						r_min[i][j] = 1;
						l_min[i][j] = 1;
					}

					if (min[i][j] > max[i][k] * max[k + 1][j] && znaks.get(k) == '*') {

						min[i][j] = max[i][k] * max[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "*";
						r_min[i][j] = 1;
						l_min[i][j] = 1;
					}

					// left - max, right - min

					if (min[i][j] > max[i][k] + min[k + 1][j] && znaks.get(k) == '+') {

						min[i][j] = max[i][k] + min[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "+";
						r_min[i][j] = 0;
						l_min[i][j] = 1;
					}

					if (min[i][j] > max[i][k] - min[k + 1][j] && znaks.get(k) == '-') {

						min[i][j] = max[i][k] - min[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "-";
						r_min[i][j] = 0;
						l_min[i][j] = 1;
					}

					if (min[i][j] > max[i][k] * min[k + 1][j] && znaks.get(k) == '*') {

						min[i][j] = max[i][k] * min[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "*";
						r_min[i][j] = 0;
						l_min[i][j] = 1;
					}

					// left_min, right- max

					if (min[i][j] > min[i][k] + max[k + 1][j] && znaks.get(k) == '+') {

						min[i][j] = min[i][k] + max[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "+";
						r_min[i][j] = 1;
						l_min[i][j] = 0;
					}

					if (min[i][j] > min[i][k] - max[k + 1][j] && znaks.get(k) == '-') {

						min[i][j] = min[i][k] - max[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "-";
						r_min[i][j] = 1;
						l_min[i][j] = 0;
					}

					if (min[i][j] > min[i][k] * max[k + 1][j] && znaks.get(k) == '*') {

						min[i][j] = min[i][k] * max[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "*";
						r_min[i][j] = 1;
						l_min[i][j] = 0;
					}

					// left - min, right - min

					if (min[i][j] < min[i][k] + min[k + 1][j] && znaks.get(k) == '+') {

						min[i][j] = min[i][k] + min[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "+";
						r_min[i][j] = 0;
						l_min[i][j] = 0;
					}

					if (min[i][j] < min[i][k] - min[k + 1][j] && znaks.get(k) == '-') {

						min[i][j] = min[i][k] - min[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "-";
						r_min[i][j] = 0;
						l_min[i][j] = 0;
					}

					if (min[i][j] < min[i][k] * min[k + 1][j] && znaks.get(k) == '*') {

						min[i][j] = min[i][k] * min[k + 1][j];
						sp_min[i][j] = k;
						s_min[i][j] = "*";
						r_min[i][j] = 0;
						l_min[i][j] = 0;
					}

				}
			}
		}
	}

	public static String max_value(int i, int j) { // find max value of a piece using recursion

		String l_max_v = " "; // left max value
		String r_max_v = " "; // right max value

		if (i == j)
			return Double.toString(nums.get(i));

		if (l_max[i][j] == 1)
			l_max_v = max_value(i, sp_max[i][j]);
		else
			l_max_v = min_value(i, sp_max[i][j]);

		if (r_max[i][j] == 1)
			r_max_v = max_value(sp_max[i][j] + 1, j);
		else
			r_max_v = min_value(sp_max[i][j] + 1, j);

		return "(" + l_max_v + ")" + s_max[i][j] + "(" + r_max_v + ")";
	}

	public static String min_value(int i, int j) { // find min value of a piece using recursion

		String l_min_v; // left min value
		String r_min_v; // right min value

		// recursion

		if (i == j)
			return Double.toString(nums.get(i));

		if (l_min[i][j] == 1)
			l_min_v = max_value(i, sp_min[i][j]);
		else
			// System.out.print(i + "/" + j + "/" + sp_min[i][j]);
			//try {
				l_min_v = min_value(i, sp_min[i][j]);
			//} catch (java.lang.StackOverflowError exceptionObject) {
			//	l_min_v = "0";
			//}

		if (r_min[i][j] == 1)
			r_min_v = max_value(sp_min[i][j] + 1, j);
		else
			r_min_v = min_value(sp_min[i][j] + 1, j);

		return "(" + l_min_v + ")" + s_min[i][j] + "(" + r_min_v + ")";
	}

	public static void main(String[] args) throws FileNotFoundException {

		Scanner sc = new Scanner(System.in);
		// int n = sc.nextInt(); //length of string with numbers
		// arr = new int[n]; //string with numbers

		/*
		 * for (int i = 0; i < n; i++) { arr[i] = sc.nextInt(); }
		 */

		String str = sc.nextLine();

		// String str = new String("2+3*0.02*4*0.02*5");

		for (String num : str.split("[\\-+* ]+")) {
			nums.add(Double.parseDouble(num));
		}

		for (int i = 0; i < str.length(); i++)
			if (str.charAt(i) == '*' || str.charAt(i) == '+' || str.charAt(i) == '-')
				znaks.add(str.charAt(i));

		int n = nums.size();
		// double[] arr = new double[n];
		// for(int i = 0; i < n; i++) arr[i] = nums.get(i);

		max = new double[n][n]; // max value of a piece
		min = new double[n][n]; // min value of a piece

		sp_max = new int[n][n]; // split for max
		sp_min = new int[n][n]; // split for min
		s_max = new String[n][n]; // sign for max
		s_min = new String[n][n]; // sign for min
		r_max = new int[n][n]; // right max |1 - max
		r_min = new int[n][n]; // right min |0 - min
		l_max = new int[n][n]; // left max |
		l_min = new int[n][n]; // left min |

		find_max(n);

		System.out.println(max[0][n - 1]);

		/*
		 * for(int i = 0; i < n; i++) { for(int j = 0; j < n; j++) {
		 * System.out.print(l_max[i][j] + " "); } System.out.println(); }
		 */

		System.out.print(max_value(0, n - 1));
		sc.close();
	}
}
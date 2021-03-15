
//Oryol Margarita
//E

import java.util.Scanner;

public class E {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		int n = sc.nextInt();
		int k = sc.nextInt();
		int number = 0;

		String str = sc.next();
		char[] string = new char[n];

		sc.close();

		for (int i = 0; i < n; i++)
			string[i] = str.charAt(i);

		int[][] a = new int[n][n];

		
		for(int i = 0; i < n; i++) {
			a[i][i] = 0;
		}
		
		for (int i = 1; i < n; i++) {
			for (int j = i - 1; j >= 0; j--) {

				if(j + 1 == i) {
					if(string[j]==string[i]) a[j][i] = 0;
					else a[j][i] = 1;
				}
				if(i - j > 1) {
					if (string[j] != string[i])
						a[j][i] = 1 + a[j + 1][i - 1];
					else
						a[j][i] = a[j + 1][i - 1];
				}
				/*}
				else {
					if (string[j] != string[i])
						a[j][i] = 1 + a[i-1][j+1];
					else
						a[j][i] = a[i-1][j+1];
				}*/

				if (a[j][i] <= k)
					number++;
			}
		}

		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		
		System.out.print(number + n);
	}

}
